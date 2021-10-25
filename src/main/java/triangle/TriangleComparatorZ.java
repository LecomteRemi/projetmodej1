package triangle;


import java.util.Comparator;

public class TriangleComparatorZ implements Comparator<Triangle>{

	@Override
	public int compare(Triangle t1, Triangle t2) {
		Point[] points1=t1.getPoints();
		Point[] points2=t2.getPoints();
		for(int i=0; i<points1.length;i++) {
			if(points1[i].getZ()>points2[i].getZ()) {
				return 1;
			}else if(points1[i].getZ()>points2[i].getZ()) {
				return -1;
			}
		}
		return 0;
	}
	
}
