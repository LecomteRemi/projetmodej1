package triangle;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import repere.Repere;
import triangle.Face;
import triangle.Point;
import utilitaire.Matrice;
import javafx.scene.shape.ArcType;


/**
 * JavaFX app pour tester la génération 2D
 * @author Cheikh bassirou Mbaye
 * @version 28/09/2021
 */

public class App extends Application {
	/**
	 * Attribut qui stocke une liste de points dans une collection
	 */
	public List<Point> listePoint = new ArrayList<>();
	/**
	 * Attribut qui stocke une liste de Face dans une collection
	 */
	public List<Face> listeface = new ArrayList<>();
	
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Des triangle");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                new double[]{210, 210, 240, 240}, 4);
 gc.strokePolygon(new double[]{60, 90, 60, 90},
                  new double[]{210, 210, 240, 240}, 4);
 gc.strokePolyline(new double[]{110, 140, 110, 140},
                   new double[]{210, 210, 240, 240}, 4);
      
        listePoint.add(new Point(-20,-20,20));
        listePoint.add(new Point(20,-20,20));
        listePoint.add(new Point(0,20,0));
        listePoint.add(new Point(0,-20,-20));
       /* listePoint.add(new Point(5,29,6));
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
        listePoint.add(new Point(64,63,5));*/
        
        
        listeface.add(new Face(0,1,2,listePoint));
        listeface.add(new Face(1,2,3,listePoint));
        listeface.add(new Face(2,0,3,listePoint));
        listeface.add(new Face(1,3,0,listePoint));
        /*listeface.add(new Face(2,5,6,listePoint));
        listeface.add(new Face(3,1,4,listePoint));
        listeface.add(new Face(1,2,3,listePoint));
        listeface.add(new Face(2,2,5,listePoint));
        listeface.add(new Face(3,1,4,listePoint));*/
        
        
        FaceSorter faceSorter= FaceSorter.faceSorterZ();
        faceSorter.sort(listeface);
        
        /*
        //drawShapes(gc);
        Point p1 = new Point(90,30);
        Point p2 = new Point(190,170);
        Point p3 = new Point(10,170);
        Face triangle = new Face(new Point[] {p1, p2, p3});
        triangle.drawTriangle(gc,new Point(90,30),new Point(190,170),new Point(10,170));
        */
      
        try {
			Repere repere=new Repere();

			//repere.turnOnYAxisOf(180);
			//repere.turnOnXAxisOf(90);
			for (Point point : listePoint) {


					point.transform(repere);
					
			}
			faceSorter.sort(listeface); 
        for (Face face : listeface) {
        	double[] x=new double[3];
        	double[] y=new double[3];
        	for(int i=0; i<face.getPoints().length; i++) {
        		x[i]=face.getPoints()[i].getX()+100;
        		y[i]=face.getPoints()[i].getY()+100;

        	}
        	//gc.setLineWidth(1);
 
        	gc.strokePolygon(x, y, face.getPoints().length);
        }
        root.getChildren().add(canvas);
        Button button=new Button("tourner de 90 degré sur y");
        button.setOnAction(e->{
        
				try {
					repere.turnOnYAxisOf(90);
					gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
					
			    	for (Point point : listePoint) {


						point.transform(repere);
						
				}
				//faceSorter.sort(listeface); 
	        for (Face face : listeface) {
	        	double[] x=new double[3];
	        	double[] y=new double[3];
	        	for(int i=0; i<face.getPoints().length; i++) {
	        		x[i]=face.getPoints()[i].getX()+100;
	        		y[i]=face.getPoints()[i].getY()+100;

	        	}
	          	//gc.setLineWidth(1);
	 
	        	gc.strokePolygon(x, y, face.getPoints().length);
	        	
	        } 
	        System.out.println("-----------------");
	        for (Point point : listePoint) {
				System.out.println(Arrays.toString(point.getMatricialCoordonnnee()));
			}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
        });
        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
       
        } catch (Exception e) {
        	System.out.println("\n\n-------------------"+e.toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    /*
    private void drawShapes(GraphicsContext gc) {
		// TODO Auto-generated method stub
    	
    	int firstX = 90;
        int secondX = 190;
        int thirdX = 10;

        int firstY =30;
        int secondY =170;
        int thirdY =170;
        gc.strokePolygon(
        		new double[]{firstX, secondX,thirdX},
                new double[]{firstY, secondY, thirdY}, 3);
                
    
		
	}
      */
    
    
    
	public static void main(String[] args) {
        launch();
    }

}