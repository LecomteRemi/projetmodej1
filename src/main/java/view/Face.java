package view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;

/**
 * Matrice d'adjacence servant à représenter les arcs 
 * @author Cheikh bassirou Mbaye
 * @version 28/09/2021
 */

public class Face{
	/**
	 * Tableau de Points appartenant à la face.
	 */
	private Point[] points;

	/**
	 * Constructeur acceptant un tableau de points 
	 * @param Tableau de points
	 * @author Cheikh bassirou Mbaye
	 * @version 28/09/2021
	 */
	public Face(Point[] points) {
		this.points=points;
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
	public Face(int a, int b, int c, List<Point> point) {
		this(new Point[] {point.get(a),point.get(b),point.get(c)});
	}
	
	/**
	 * récupère le tableau de point appartenant à la face
	 * @return le Tableau des points appartenant à la face
	 * @author Cheikh bassirou Mbaye
	 * @version 28/09/2021
	 */
	public Point[] getPoints() {
		return points;
	}
	
	/**
	 * Méthode qui tri un tableau de point par ordre croissant
	 * @param Tableau de points
	 * @author Cheikh bassirou Mbaye
	 * @version 28/09/2021
	 */
	public void sortPoint(Comparator<Point> comparator) {
		Arrays.sort(points, comparator);
	}

	
}