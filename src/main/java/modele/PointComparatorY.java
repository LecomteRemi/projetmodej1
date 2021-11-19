package modele;

import java.util.Comparator;

public class PointComparatorY implements Comparator<Point>{
	@Override
	public int compare(Point point1, Point point2) {
		double res=point1.getY()-point2.getY();
		return res<0?-1:res>0?1:0;
	}
}