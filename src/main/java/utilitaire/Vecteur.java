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
		this.x=p1.getX()-p2.getX();
		this.y=p1.getY()-p2.getY();
		this.z=p1.getZ()-p2.getZ();
	}
	
	public double scalaire(Vecteur other) {
		return 0;
		//return this.x*other.x+this.y*other.y+this.z*other.z;
	}
	public double getNorme() {
		double sommeCarre=x*x+y*y+z*z;
		return Math.sqrt(sommeCarre);
	}
	public Vecteur produitVectoriel(Vecteur other) {
		double x=this.y*other.z-this.z*other.y;
		double y=this.z*other.x-this.x*other.z;
		double z=this.x*other.y-this.y*other.x;
		return new Vecteur(x, y, z);
	}
	public Vecteur divide(double diviseur) {
		double x=this.x/diviseur;
		double y=this.y/diviseur;
		double z=this.z/diviseur;
		return new Vecteur(x, y, z);
	}
	
	public static void main(String[] args) {
		Vecteur v1 =new Vecteur(10,9,90);
		Vecteur v2=new Vecteur(-5, 2, 0);
		System.out.println(v1.scalaire(v2));
>>>>>>> 90572512b61e403419ed29378cad68e4e679057c
	}
	
}
