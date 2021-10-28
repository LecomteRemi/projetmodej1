package triangle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javafx.scene.canvas.GraphicsContext;

public class Face{
	
	private Point[] points;

	
	public Face(Point[] points) {
		this.points=points;
	}
	public Face(int a, int b, int c, List<Point> point) {
		this(new Point[] {point.get(a),point.get(b),point.get(c)});
	}
	
	public Point[] getPoints() {
		return points;
	}
	
	public void sortPoint(Comparator<Point> comparator) {
		Arrays.sort(points, comparator);
	}

	
}