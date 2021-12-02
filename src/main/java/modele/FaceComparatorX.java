package modele;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Matrice d'adjacence servant à représenter les arcs 
 * @author Cheikh bassirou Mbaye
 * @version 28/09/2021
 */
public class FaceComparatorX implements FaceComparator{
	@Override
	public int compare(Face t1, Face t2) {
		double x=t1.getBarycenter().getX()-t2.getBarycenter().getX();
		return x>0?1:x==0?0:-1;
	}

	@Override
	public double getX2D(Point point) {
		return point.getZ();
	}

	@Override
	public double getY2D(Point point) {
		return point.getY();
	}
}
