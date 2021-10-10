package lecture;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Lecture {
	public static void lecture(String file) {
		String line;
		String entete=""; //pour mettre toute la partie avant les coordonnées des points, sera gérée plus tard
		String données=""; // en attendant que je fasse la séparation entre points et faces
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			line = br.readLine();
			while(!line.split(" ")[0].equals("end_header")) {
				entete = entete +line+"\n";
				line = br.readLine();
			}
			ecrire_fichier(entete, "./ressources/entete.txt");
			line = br.readLine();
			while (line!=null) {
				données = données +line+"\n";
				line = br.readLine();
			}
			ecrire_fichier(données, "./ressources/coordonnes.txt");
		}catch(IOException e) {
			System.out.println("Une erreur est survenue");
			e.printStackTrace();
		}
	}
	
	public static void stocker_donnees(String[] line, String d) {
		for(int i =0; i< line.length; i++) {
			d += line[i];
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
	
	public static void main(String [] args) {
		lecture("./ressources/test.ply");
	}
}
