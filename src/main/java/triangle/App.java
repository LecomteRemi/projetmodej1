package triangle;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import triangle.Face;
import triangle.Point;


/**
 * JavaFX App
 */
public class App extends Application {
	public List<Point> listePoint = new ArrayList<>();
	public List<Face> listeface = new ArrayList<>();
	
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Des triangle");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
      
        listePoint.add(new Point(5,29,0));
        listePoint.add(new Point(36,57,0));
        listePoint.add(new Point(20,63,2));
        listePoint.add(new Point(80,42,4));
        listePoint.add(new Point(5,29,6));
        listePoint.add(new Point(86,11,6));
        listePoint.add(new Point(19,69,0));
        listePoint.add(new Point(102,40,4));
        listePoint.add(new Point(11,71,3));
        listePoint.add(new Point(55,88,1));
        listePoint.add(new Point(76,15,4));
        listePoint.add(new Point(05,29,5));
        listePoint.add(new Point(93,53,7));
        listePoint.add(new Point(63,42,1));
        listePoint.add(new Point(67,74,4));
        listePoint.add(new Point(38,33,3));
        listePoint.add(new Point(64,63,5));
        
        
        listeface.add(new Face(0,1,2,listePoint));
        listeface.add(new Face(1,3,4,listePoint));
        listeface.add(new Face(2,1,3,listePoint));
        listeface.add(new Face(0,3,4,listePoint));
        listeface.add(new Face(2,5,6,listePoint));
        listeface.add(new Face(3,1,4,listePoint));
        listeface.add(new Face(1,2,3,listePoint));
        listeface.add(new Face(2,2,5,listePoint));
        listeface.add(new Face(3,1,4,listePoint));
        
        
        FaceSorter faceSorter= FaceSorter.faceSorterX();
        faceSorter.sort(listeface);
        drawTriangles(gc,listeface);
        /*
        drawShapes(gc);
        Point p1 = new Point(90,30);
        Point p2 = new Point(190,170);
        Point p3 = new Point(10,170);
        Face triangle = new Face(new Point[] {p1, p2, p3});
        triangle.drawTriangle(gc,new Point(90,30),new Point(190,170),new Point(10,170));
        */
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    
    
    private void drawTriangles(GraphicsContext gc ,List<Face> listFace) {
    	for(int i=0; i<listFace.size();i++){
    		  Face face=listFace.get(i);
    		  Point p1=face.getPoints()[0];
    		  Point p2=face.getPoints()[1];
    		  Point p3=face.getPoints()[2];
    		  drawTriangle(gc,p1,p2,p3);
    		}
    }
    
    
    
	private void drawTriangle(GraphicsContext gc, Point p1, Point p2, Point p3) {
		gc.strokePolygon(
        		new double[]{p1.getX(), p2.getX(),p3.getX()},
                new double[]{p1.getY(), p2.getY(), p3.getY()}, 3);
		
	}




	public static void main(String[] args) {
        launch();
    }

}