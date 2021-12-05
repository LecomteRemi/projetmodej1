package modele;

import utilitaire.Vecteur;

public class Eclairage {
	public Vecteur getN(Point[] points) {
		return null;
	}
	public double brightCoeff(Vecteur normal, Vecteur lightVector) {
		double scalaire=normal.scalaire(lightVector);
		return scalaire/(normal.getNorme()*lightVector.getNorme());
		
	}
}
