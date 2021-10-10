package triangle;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BasicOpsTest extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(300, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
    	List<Point> points = new ArrayList<Point>();
    	
    	double  Vertices[][] = 
    		{
    		    {-5.0, -5.0},
    		    { 0.0,  5.0},
    		    { 5.0, -5.0},
    		    {10.0,  5.0},
    		    {15.0, -5.0},
    		    {20.0,  5.0, 0.0}
    		};
    	
    	
    	int i = 0;
    	while(i<points.size()) {
    		Point v1 = points.get(i);
    		Point v2 = points.get(i+1);
    		Point v3 = points.get(i+2);
    		// a continuer pour la prochaine fois 
    	}
    	
    	for (int j=0; j < Vertices.length ;j++) {
    		double firstX = Vertices[i][0] ;
            double secondX = Vertices[i+1][0];
            double thirdX = Vertices[i+2][0];
            
            double firstY = Vertices[i][1] ;
            double secondY = Vertices[i+1][1];
            double thirdY = Vertices[i+2][1];
            gc.setFill(Color.GREEN);
            gc.fillPolygon(new double[]{firstX, secondX,thirdX},
                    new double[]{firstY, secondY, thirdY}, 3);
    	}
    	
    	/*
        int firstX = 90;
        int secondX = 190;
        int thirdX = 10;

        int firstY =30;
        int secondY =170;
        int thirdY =170;
        
        

                gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.fillPolygon(new double[]{firstX, secondX,thirdX},
                new double[]{firstY, secondY, thirdY}, 3);

        gc.strokePolygon(new double[]{firstX, secondX,thirdX},
                new double[]{firstY, secondY, thirdY}, 3);

        gc.setFill(javafx.scene.paint.Color.BLACK);
        */
        //gc.fillText("1", firstX - 3, firstY - 4);
        //gc.fillText("2", secondX - 3, secondY - 4);
        //gc.fillText("3", thirdX - 3, thirdY - 4);


    }
}