package utilitaire;

import modele.Point;

public class Vecteur {
	
	protected double x;
	protected double y;
	protected double z;
	
	public Vecteur(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vecteur(Point p1, Point p2) {
		this.x=p2.getX()-p1.getX();
		this.y=p2.getY()-p1.getY();
		this.z=p2.getZ()-p1.getZ();
	}
	/**
	 * calcule le produit scalaire entre le vecteur passé en parametre et le vecteur courant 
	 * @param other : un vecteur 
	 * @return le produit scalaire 
	 */
	public double scalaire(Vecteur other) {
		return this.x*other.x+this.y*other.y+this.z*other.z;
	}
	public double getNorme() {
		double sommeCarre=x*x+y*y+z*z;
		return Math.sqrt(sommeCarre);
	}
	/**
	 *calcule le produit vectoriel entre le vecteur passé en parametre et le vecteur courant  
	 * @param other un vecteur 
	 * @return un vecteur normal au deux vecteurs 
	 */
	public Vecteur produitVectoriel(Vecteur other) {
		double x=this.y*other.z-this.z*other.y;
		double y=this.z*other.x-this.x*other.z;
		double z=this.x*other.y-this.y*other.x;
		return new Vecteur(x, y, z);
	}
	/**
	 * 
	 * @param diviseur
	 * @return
	 */
	public Vecteur divide(double diviseur) {
		double x=this.x/diviseur;
		double y=this.y/diviseur;
		double z=this.z/diviseur;
		return new Vecteur(x, y, z);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vecteur other = (Vecteur) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}


	
	
	
}
