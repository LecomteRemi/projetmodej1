package triangle;

import java.util.Comparator;

/**
 * Matrice d'adjacence servant à représenter les arcs 
 * @author Cheikh bassirou Mbaye
 * @version 28/09/2021
 */
public class FaceComparatorX implements Comparator<Face>{
	@Override
	public int compare(Face t1, Face t2) {
		Point[] points1=t1.getPoints();
		Point[] points2=t2.getPoints();
		for(int i=0; i<points1.length;i++) {
			if(points1[i].getX()>points2[i].getX()) {
				return 1;
			}else if(points1[i].getX()>points2[i].getX()) {
				return -1;
			}
		}
		return 0;
	}
}
