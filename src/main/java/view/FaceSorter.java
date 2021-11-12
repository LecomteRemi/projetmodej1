package view;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FaceSorter {
	public Comparator<Face> faceComparator;
	public Comparator<Point> pointComparator;
	
	protected FaceSorter(Comparator<Face> triangleComparator, Comparator<Point> pointComparator) {
		this.faceComparator = triangleComparator;
		this.pointComparator = pointComparator;
	}
	public static FaceSorter faceSorterZ() {
		return new FaceSorter(new FaceComparatorZ(), new PointComparatorZ());
	}
	public static FaceSorter faceSorterX() {
		return new FaceSorter(new FaceComparatorX(), new PointComparatorX());
	}
	public static FaceSorter faceSorterY() {
		return new FaceSorter(new FaceComparatorY(), new PointComparatorY());
	}
	
	public void sort(Face[] faces) {
		for(int i=0; i<faces.length;i++) {
			faces[i].sortPoint(pointComparator);
		}
		Arrays.sort(faces, faceComparator);
	}
	
	public void sort(List<Face> faces) {
		for(int i=0; i<faces.size();i++) {
			faces.get(i).sortPoint(pointComparator);
		}
		faces.sort(faceComparator);
	}
	
	
}
