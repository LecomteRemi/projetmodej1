package triangle;

import javafx.scene.canvas.GraphicsContext;

public class Triangle{
	private Point p1 , p2 , p3 ;

	
	public Triangle(Point p1, Point p2, Point p3) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
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