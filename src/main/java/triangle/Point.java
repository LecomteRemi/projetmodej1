package triangle;

import repere.Repere;

public class Point {
	protected double x;
	protected double y;
	protected double z;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Point(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z=z;
	}
	public Point(double[] coordonnnee) {
		this(coordonnnee[0],coordonnnee[1],coordonnnee[2]);
	}

	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public double getZ() {
		return z;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public String toString() {
		return ("(" + x + "," + y + "," + z + ")");
	}

	public void translate(int dx, int dy, int dz) {
		x = x + dx;
		y = y + dy;
		z = z + dz;
	}
	public double[] getMatricialCoordonnnee(){
		return new double[] {x,y,z,1};
	}
	public void transform(Repere repere) throws Exception {
		Point pointInRepere=repere.getPointInRepere(this);
		this.x=pointInRepere.x;
		this.y=pointInRepere.y;
		this.z=pointInRepere.z;
	}

}