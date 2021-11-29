package modele;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FaceSorter {
	public Comparator<Face> faceComparator;
	
	protected FaceSorter(Comparator<Face> triangleComparator) {
		this.faceComparator = triangleComparator;
	}
	public static FaceSorter faceSorterZ() {
		return new FaceSorter(new FaceComparatorZ());
	}
	public static FaceSorter faceSorterX() {
		return new FaceSorter(new FaceComparatorX());
	}
	public static FaceSorter faceSorterY() {
		return new FaceSorter(new FaceComparatorY());
	}
	
	public void sort(Face[] faces) {
		Arrays.sort(faces, faceComparator);
	}
	
	public void sort(List<Face> faces) {
		faces.sort(faceComparator);
	}
	
	
}
