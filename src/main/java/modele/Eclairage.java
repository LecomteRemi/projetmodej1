package modele;

import utilitaire.Vecteur;

public class Eclairage {
	protected static Eclairage instance;
	private Eclairage() {
		
	}
	
	public static Eclairage getInstance() {
		if(instance==null) {
			instance=new Eclairage();
		}
		return instance;
	}
	public double brightCoeff(Face face, Vecteur lightVector) {
		Vecteur normale=face.getNormal();
		double scalaire=normale.scalaire(lightVector);
		double res=scalaire/(normale.getNorme()*lightVector.getNorme());
		res=res<0?0:res;
		res=res;
		return res;
		
	}
}
