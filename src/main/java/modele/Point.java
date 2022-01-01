package modele;

import controle.Repere;
import javafx.scene.paint.Color;
import utilitaire.Vecteur;
/**
 * 
 * @author Cheikh bassirou Mbaye
 * @version 12/09/2021
 */
public class Point {
	/**
	 * Attribut qui stocke la position x du point
	 */
	protected double x;
	/**
	 * Attribut qui stocke la position y du point
	 */
	protected double y;
	/**
	 * Attribut qui stocke la position z du point
	 */
	protected double z;
	
	protected Color color;

	
	/**
	 * Constructeur récupérant les positions x, y et z pour les assigner au point
	 * @param x
	 * @param y
	 * @param z
	 * @author Cheikh bassirou Mbaye
     * @version 12/09/2021
	 */
	public Point(double x, double y, double z) {
		this(x,y,z,null);
	}
	public Point(double x, double y, double z, Color color) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.color=color;
	}
	
	/**
	 * Constructeur récupérant les valeurs d'un Tableau double pour les assigner au point
	 * @param coordonnnee
	 * @author Cheikh bassirou Mbaye
     * @version 12/09/2021
	 */
	public Point(double[] coordonnnee) {
		this(coordonnnee[0],coordonnnee[1],coordonnnee[2]);
	}

	/**
	 * retourne la position x du point
	 * @return x
	 * @author Cheikh bassirou Mbaye
     * @version 12/09/2021
	 */
	public double getX() {
		return this.x;
	}

	/**
	 * retourne la position y du point
	 * @return y
	 * @author Cheikh bassirou Mbaye
     * @version 12/09/2021
	 */
	public double getY() {
		return this.y;
	}

	/**
	 * retourne la position z du point
	 * @return
	 * @author Cheikh bassirou Mbaye
     * @version 12/09/2021
	 */
	public double getZ() {
		return z;
	}
	
	/**
	 * set une nouvelle valeur à X
	 * @param x
	 * @author Cheikh bassirou Mbaye
     * @version 12/09/2021
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * set une nouvelle valeur à Y
	 * @param y
	 * @author Cheikh bassirou Mbaye
     * @version 12/09/2021
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * set une nouvelle valeur à Z
	 * @param z
	 * @author Cheikh bassirou Mbaye
     * @version 12/09/2021
	 */
	public void setZ(double z) {
		this.z = z;
	}

	/**
	 * @author Cheikh bassirou Mbaye
     * @version 12/09/2021
	 */
	public String toString() {
		return ("(" + x + "," + y + "," + z + ")");
	}

	/**
	 * Fonction qui simule la translation du point
	 * @param dx
	 * @param dy
	 * @param dz
	 * @author Cheikh bassirou Mbaye
     * @version 12/09/2021
	 */
	public void translate(double dx, double dy, double dz) {
		x = x + dx;
		y = y + dy;
		z = z + dz;
	}
	
	/**
	 * retourne les 3 coordonnées du point.
	 * @return Double {x,y,z,?}
	 * @author Cheikh bassirou Mbayem*l
     * @version 12/09/2021
	 */
	public double[] getMatricialCoordonnnee(){
		return new double[] {x,y,z,1};
	}
	
	
	/**
	 * retourne les nouvelles coordonées suite à l'adaptation du repère
	 * @param repere
	 * @throws Exception
	 * @author Cheikh bassirou Mbaye
     * @version 12/09/2021
	 */
	public void transform(Repere repere) throws Exception {
		Point pointInRepere=repere.getPointInRepere(this);
		this.x=pointInRepere.x;
		this.y=pointInRepere.y;
		this.z=pointInRepere.z;
	}
	
	public Color getColor() {
		return color==null?Color.WHITE:color;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
			return false;
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
			return false;
		if (Double.doubleToLongBits(z) != Double.doubleToLongBits(other.z))
			return false;
		return true;
	}

	public Point translate(Vecteur vector) {
		double x=this.x+vector.getX();
		double y=this.y+vector.getY();
		double z=this.z+vector.getZ();
		return new Point(x, y, z);
	}
	
}