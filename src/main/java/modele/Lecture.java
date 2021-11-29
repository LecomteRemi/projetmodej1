package modele;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lecture {
	private static List<Point> listePoints = new ArrayList<Point>();
	private static List<Face> listeFaces = new ArrayList<Face>();
	
	public static Modele creation_modele(String file) {
		lecture(file);
		return new Modele(listeFaces, listePoints);
		
	}
	
	@SuppressWarnings("unused")
	public static void lecture(String file) {
		String line;
		String entete=""; //pour mettre toute la partie avant les coordonnées des points, sera gérée plus tard
		String coordonnees=""; 
		String faces=""; 
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			line = br.readLine();
			String[] splited;
			while(!line.split(" ")[0].equals("end_header")) {
				entete = entete +line+"\n";
				line = br.readLine();
			}
			//--------Points--------
			line = br.readLine();
			while (line!=null && !est_ligne_face(line)) {
				creation_point(line);
				coordonnees = coordonnees +line+"\n";
				line = br.readLine();
			}
			//--------Faces--------
			int nbptFace ;
			int cpt=0;
			while(line!=null && est_ligne_face(line)) {
				nbptFace = getNbPointsFaces(line);
				creation_faces(line, nbptFace);
				System.out.println(listeFaces.get(listeFaces.size()-1));
				faces= faces +line+"\n";
				line = br.readLine();
				cpt++;
			}
			System.out.println(listeFaces.size());
		}catch(IOException e) {
			System.out.println("Une erreur est survenue");
			e.printStackTrace();
		}
	}
	
	
	private static void creation_point(String line) {
		String [] splited = line.split(" ");
		if(splited.length==3) {
			listePoints.add(new Point((Float.parseFloat(splited[0])), (Float.parseFloat(splited[1])), (Float.parseFloat(splited[2])) ) );
		}
	}

	
	private static void creation_faces(String line, int nbpoint) {
		String [] splited = line.split(" ");
		ArrayList<Point> pointDeFace = new ArrayList<Point>();
		for(int i=1; i<=nbpoint; i++) {
			pointDeFace.add(listePoints.get(Integer.parseInt(splited[i])));
		}
		listeFaces.add(new Face(pointDeFace));
	}
	
	private static void ecrire_fichier(String ligne, String fichier_dest) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(fichier_dest);
			writer.println(ligne);
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable");
			e.printStackTrace();
		}
	}
	
	private static boolean est_ligne_face(String ligne) {
		String[] mots = ligne.split(" ");
		Scanner scanner = new Scanner(mots[0]);
		if(scanner.hasNextInt()) {
		int nb = scanner.nextInt();
		if(nb==mots.length-1) {
			return true;
		}
		}
		return false;
	}
	
	private static int getNbPointsFaces(String line) {
		String [] splited = line.split(" ");
		return Integer.parseInt(splited[0]);
	}
	
	public static void main(String [] args) {
		lecture("./exemples/vache.ply");
		//lecture("./exemples/skull.ply");
	}
}
