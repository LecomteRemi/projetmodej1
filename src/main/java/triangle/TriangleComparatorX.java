package triangle;

import java.util.Comparator;

public class TriangleComparatorX implements Comparator<Triangle>{
	@Override
	public int compare(Triangle t1, Triangle t2) {
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
