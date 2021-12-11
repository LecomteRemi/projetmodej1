package modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import modele.Point;
import utilitaire.Vecteur;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Matrice d'adjacence servant à représenter les arcs 
 * @author Cheikh bassirou Mbaye
 * @version 28/09/2021
 */

public class Face{
	/**
	 * Tableau de Points appartenant à la face.
	 */
	private List<Point> points;
	private Point barycenter;
	protected Color color;
	protected Color finalColor;

	/**
	 * Constructeur acceptant un tableau de points 
	 * @param Tableau de points
	 * @author Cheikh bassirou Mbaye
	 * @version 28/09/2021
	 */
	public Face(Point[] points, Color color) {
		ArrayList<Point> pointsList = new ArrayList<Point>();
		for(int i=0; i<points.length; i++) {
			pointsList.add(points[i]);
		}
		this.points=pointsList;
		this.color=color;
		calculBarycenter();
	}
	public Face(Point[] points) {
		this(points, null);
	}
	
	/**
	 * Constructeur recevant une liste de points
	 * @param a : coordonnée x
	 * @param b : coordonnée y
	 * @param c : coordonnée z
	 * @param Liste de points
	 * @author Cheikh bassirou Mbaye
	 * @version 28/09/2021
	 */
	public Face(List<Point> points) {
		this.points = points;
		calculBarycenter();
	}
	
	/**
	 * récupère le tableau de point appartenant à la face
	 * @return le Tableau des points appartenant à la face
	 * @author Cheikh bassirou Mbaye
	 * @version 28/09/2021
	 */
	public List<Point> getPoints() {
		return points;
	}
	
	public Face(int a, int b, int c, List<Point> point) {
		this(new Point[] {point.get(a),point.get(b),point.get(c)});
	}
	
	/**
	 * Méthode qui tri un tableau de point par ordre croissant
	 * @param Tableau de points
	 * @author Cheikh bassirou Mbaye
	 * @version 28/09/2021
	 */
	/*public void sortPoint(Comparator<Point> comparator) {
		Collections.sort(points, comparator);
	}*/
	public void calculBarycenter() {
		double x=0;
		double y=0;
		double z=0;
		for (Point point : points) {
			x+=point.getX();
			y+=point.getY();
			z+=point.getZ();
		}
		this.barycenter=new Point(x/points.size(), y/points.size(), z/points.size());
		
	}
	public Point getBarycenter() {
		return this.barycenter;
	}
	
	
	/*public Point[] sortedPoint(Face face) {
		
		return null;
	}*/
	public void calculFinalColor(Vecteur lightVector) {
		Color baseColor;
		if(this.color==null) {
			baseColor = points.get(0).getColor();
		}else {
			baseColor=this.color;
		}
		double brightCoeff=Eclairage.getInstance().brightCoeff(this, lightVector);
		double red;
		double green;
		double blue;
		red=baseColor.getRed()*brightCoeff;
		green=baseColor.getGreen()*brightCoeff;
		blue=baseColor.getBlue()*brightCoeff;
		
		
		finalColor=new Color(red, green, blue, 1);
		
	}
	
	public Vecteur getNormal() {
		//ab^ac :/ ||ab^ac||
		Vecteur v1=new Vecteur(points.get(0), points.get(1));
		Vecteur v2=new Vecteur(points.get(0), points.get(2));
		Vecteur produitVectoriel=v1.produitVectoriel(v2);
		double norme=produitVectoriel.getNorme();
		return produitVectoriel.divide(norme);
	}
	
	public Color getColor() {
		return finalColor;
	}

	
}