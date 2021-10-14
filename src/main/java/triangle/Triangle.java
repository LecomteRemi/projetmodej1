package triangle;

import java.util.Arrays;
import java.util.Comparator;

import javafx.scene.canvas.GraphicsContext;

public class Triangle{
	private Point[] points;

	
	public Triangle(Point[] points) {
		this.points=points;
	}

	public Point[] getPoints() {
		return points;
	}
	public void sortPoint(Comparator<Point> comparator) {
		Arrays.sort(points, comparator);
	}

    public void drawTriangle(GraphicsContext gc,Point p1, Point p2 , Point p3) {
    	double[] abscusses = new double[]{p1.getX(), p2.getX(),p3.getX()};
    	double[] ordonnes = new double[]{p1.getY(), p2.getY(),p3.getY()};
    	gc.strokePolygon(abscusses,ordonnes, 3);
		
    }
    
    
    public void drawTriangle(GraphicsContext gc,double x1, double y1, double x2, double y2, double x3, double y3 ) {
    	drawTriangle(gc,new Point(x1,y1), new Point(x2,y2) ,new Point(x3,y3));
    }
	
}