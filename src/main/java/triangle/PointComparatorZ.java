package triangle;

import java.util.Comparator;

public class PointComparatorZ implements Comparator<Point>{
	
	@Override
	public int compare(Point point1, Point point2) {
		double res=point1.getZ()-point2.getZ();
		return res<0?-1:res>0?1:0;
	}

}
