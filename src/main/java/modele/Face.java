package modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import modele.Point;

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

	/**
	 * Constructeur acceptant un tableau de points 
	 * @param Tableau de points
	 * @author Cheikh bassirou Mbaye
	 * @version 28/09/2021
	 */
	public Face(Point[] points) {
		ArrayList<Point> pointsList = new ArrayList<Point>();
		for(int i=0; i<points.length; i++) {
			pointsList.add(points[i]);
		}
		this.points=pointsList;
		calculBarycenter();
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
	
	
	public Point[] sortedPoint(Face face) {
		
		return null;
	}
	public Color getColor() {
		return Color.SKYBLUE;
	}
	
	
	public double min(double a ,double  b ,double c ) {
		return Math.min(c, Math.min(a, b));
	}
	
	/**
	 * 
	 * @param face
	 * @return une liste des points appartenant a la face passee en parametre , mais cette liste est triee selon les coordonnees
	 * z et y (par exemple le premier element de la liste contient 
	 */
	public List<Point> plusPetitZ(Face face) {
		List<Point> trieeSelonZY = new ArrayList<>();
		List<Point> listeFaceCourante = face.getPoints();
		Point p1 = listeFaceCourante.get(0);
		Point p2 = listeFaceCourante.get(1);
		Point p3 = listeFaceCourante.get(2);
		if(min(p1.getZ(), p2.getZ(), p3.getZ())==p1.getZ()) {
			trieeSelonZY.add(p1);
			if(Math.min(p2.getY(), p3.getY())==p2.getY()) {
				trieeSelonZY.add(p2);
			}else if (Math.min(p2.getY(), p3.getY())==p3.getY()) {
				trieeSelonZY.add(p3);
			}
		}else if(min(p1.getZ(), p2.getZ(), p3.getZ())==p2.getZ()) {
			trieeSelonZY.add(p2);
			if(Math.min(p1.getY(), p3.getY())==p1.getY()) {
				trieeSelonZY.add(p1);
			}else if (Math.min(p1.getY(), p3.getY())==p3.getY()) {
				trieeSelonZY.add(p3);
			}
		}else if(min(p1.getZ(), p2.getZ(), p3.getZ())==p3.getZ()) {
			trieeSelonZY.add(p3);
			if(Math.min(p1.getY(), p2.getY())==p1.getY()) {
				trieeSelonZY.add(p1);
			}else if (Math.min(p1.getY(), p2.getY())==p2.getY()) {
				trieeSelonZY.add(p2);
			}
		}
		
		return trieeSelonZY;
		
		
	}

	
}