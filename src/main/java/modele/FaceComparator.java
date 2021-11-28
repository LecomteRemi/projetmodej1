package modele;

import java.util.Comparator;

import view.Face;

public interface FaceComparator extends Comparator<Face> {
	int compare(Face t1, Face t2);
	double getX2D(Point point);
	double getY2D(Point point);
}
