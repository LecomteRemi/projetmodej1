package modele;

import java.util.Comparator;

public interface FaceComparator extends Comparator<Face> {
	int compare(Face t1, Face t2);
	double getX2D(Point point);
	double getY2D(Point point);
}
