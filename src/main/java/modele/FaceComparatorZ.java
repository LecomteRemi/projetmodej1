package modele;


import java.util.ArrayList;
import java.util.Comparator;

public class FaceComparatorZ implements FaceComparator{

	@Override
	public int compare(Face t1, Face t2) {
		double z=t1.getBarycenter().getZ()-t2.getBarycenter().getZ();
		return z>0?1:z==0?0:-1;
	}

	@Override
	public double getX2D(Point point) {
		return point.getX();
	}

	@Override
	public double getY2D(Point point) {
		return point.getY();
	}
	
}
