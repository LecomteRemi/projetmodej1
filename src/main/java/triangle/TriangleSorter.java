package triangle;

import java.util.Arrays;
import java.util.Comparator;

public class TriangleSorter {
	public Comparator<Triangle> triangleComparator;
	public Comparator<Point> pointComparator;
	
	protected TriangleSorter(Comparator<Triangle> triangleComparator, Comparator<Point> pointComparator) {
		this.triangleComparator = triangleComparator;
		this.pointComparator = pointComparator;
	}
	public TriangleSorter triangleSorterZ() {
		return new TriangleSorter(new TriangleComparatorZ(), new PointComparatorZ());
	}
	public TriangleSorter triangleSorterX() {
		return new TriangleSorter(new TriangleComparatorX(), new PointComparatorX());
	}
	public TriangleSorter triangleSorterY() {
		return new TriangleSorter(new TriangleComparatorY(), new PointComparatorY());
	}
	public void sort(Triangle[] triangles) {
		for(int i=0; i<triangles.length;i++) {
			triangles[i].sortPoint(pointComparator);
		}
		Arrays.sort(triangles, triangleComparator);
	}
	
	
}
