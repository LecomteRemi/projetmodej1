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
	
		
	}
	
}
