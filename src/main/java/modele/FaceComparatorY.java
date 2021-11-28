package modele;

import java.util.ArrayList;
import java.util.Comparator;

import view.Face;

public class FaceComparatorY implements FaceComparator{
	@Override
	public int compare(Face t1, Face t2) {
		double y=t1.getBarycenter().getY()-t2.getBarycenter().getY();
		return y>0?1:y==0?0:-1;
	}

	@Override
	public double getX2D(Point point) {
		return point.getX();
	}

	@Override
	public double getY2D(Point point) {
		return point.getZ();
	}
}
