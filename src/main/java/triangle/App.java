package triangle;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
	
	double[] vertexListe = new double[] {
			
			
	};
	
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Des triangle");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //drawShapes(gc);
        Point p1 = new Point(90,30);
        Point p2 = new Point(190,170);
        Point p3 = new Point(10,170);
        Triangle triangle = new Triangle(new Point[] {p1, p2, p3});
        triangle.drawTriangle(gc,new Point(90,30),new Point(190,170),new Point(10,170));
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
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