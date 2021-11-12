package modele;

import java.util.ArrayList;

public class Modele {
	private ArrayList<Face> faces;
	
	public Modele(ArrayList<Face> faces) {
		this.faces = faces;
	}

	@Override
	public String toString() {
		return "Modele [faces=" + faces + "]";
	} 
}
