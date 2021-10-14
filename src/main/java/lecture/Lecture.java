package lecture;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {
	public static void lecture(String file) {
		String line;
		String entete=""; //pour mettre toute la partie avant les coordonnées des points, sera gérée plus tard
		String coordonnees=""; 
		String faces="";
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			line = br.readLine();
			while(!line.split(" ")[0].equals("end_header")) {
				entete = entete +line+"\n";
				line = br.readLine();
			}
			ecrire_fichier(entete, "./ressources/entete.txt");
			line = br.readLine();
			while (line!=null && !est_ligne_face(line)) {
				coordonnees = coordonnees +line+"\n";
				line = br.readLine();
			}
			ecrire_fichier(coordonnees, "./ressources/coordonnes.txt");
			while(line!=null) {
				faces= faces +line+"\n";
				line = br.readLine();
			}
			ecrire_fichier(faces, "./ressources/faces.txt");
		}catch(IOException e) {
			System.out.println("Une erreur est survenue");
			e.printStackTrace();
		}
	}
	
	
	public static void ecrire_fichier(String ligne, String fichier_dest) {
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
	
	public static boolean est_ligne_face(String ligne) {
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
	
	public static void main(String [] args) {
		lecture("./ressources/test.ply");
	}
}

