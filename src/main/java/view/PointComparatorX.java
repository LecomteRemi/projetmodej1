package view;

import java.util.Comparator;

public class PointComparatorX implements Comparator<Point>{
	@Override
	public int compare(Point point1, Point point2) {
		double res=point1.getX()-point2.getX();
		return res<0?-1:res>0?1:0;
	}
}
