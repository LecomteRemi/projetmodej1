package view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controle.Repere;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modele.Lecture;
import modele.Modele;
import modele.Point;
import utilitaire.Observer;
import utilitaire.Subject;
import view.Face;
import view.FaceSorter;


/**
 * JavaFX App
 */
public class App extends Application implements Observer{

	/**
	 * Attribut qui stocke une liste de points dans une collection
	 */
	public List<Point> listePoint = new ArrayList<>();
	/**
	 * Attribut qui stocke une liste de Face dans une collection
	 */
	public List<Face> listeface = new ArrayList<>();
	Modele modele;
	protected FaceSorter faceSorter= FaceSorter.faceSorterZ();
	Canvas canvas = new Canvas(300, 250);
	
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Projet Modelisation");
        Group root = new Group();
        GraphicsContext gc = canvas.getGraphicsContext2D();
       modele = Lecture.creation_modele("./exemples/vache.ply");
      modele.attach(this);
      listePoint = modele.getListPoints();
      listeface = modele.getListeFaces();
      

        
        
        FaceSorter faceSorter = FaceSorter.faceSorterZ();
        faceSorter.sort(listeface);

      
        try {
		
        try {
			DrawModele(modele, canvas);
		} catch (Exception e1) {
			
        }
        
        root.getChildren().add(canvas);
        Button button = new Button("tourner de 5 degrés sur y");
        
        button.setOnAction(e->{
        	try {
				modele.turnOnYAxis(5);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}});
                Button button2=new Button("tourner de 5 degrés sur x");
        button2.setOnAction(e->{
        		try {
					modele.turnOnXAxis(5);
				} catch (Exception e1) {
					
				}
        });		
			
   
        root.getChildren().add(buttonBox( modele));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
       
        } catch (Exception e) {
        	System.out.println("\n\n-------------------"+e.toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
   private void drawTriangles(GraphicsContext gc ,List<Face> listFace) {
    	for(int i=0; i<listFace.size();i++){
    		  Face face=listFace.get(i);
    		  Point p1=face.getPoints().get(0);
    		  Point p2=face.getPoints().get(1);
    		  Point p3=face.getPoints().get(2);
    		  drawTriangle(gc,p1,p2,p3);
    		}
    }
    
    
    
	private void drawTriangle(GraphicsContext gc, Point p1, Point p2, Point p3) {
		gc.strokePolygon(
        		new double[]{p1.getX(), p2.getX(),p3.getX()},
                new double[]{p1.getY(), p2.getY(), p3.getY()}, 3);
		
	}
	
	protected void DrawModele(Modele modele, Canvas canvas) {
		List<Face> faceList=modele.getListeFaces();
		this.faceSorter.sort(faceList);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    	
		
		//faceSorter.sort(listeface); 
		for (Face face : modele.getListeFaces()) {
			double[] x=new double[3];
			double[] y=new double[3];
			for(int i=0; i<face.getPoints().size(); i++) {
				x[i]=face.getPoints().get(i).getCurrentX()*20+100;
				y[i]=face.getPoints().get(i).getCurrentY()*20+100;

			}
			gc.strokePolygon(x, y, face.getPoints().size());
			gc.setFill(Color.WHITE);
			gc.fillPolygon(x, y, face.getPoints().size());
		}
		
	}




	public static void main(String[] args) {
        launch();
    }



	@Override
	public void update(Subject subj) {
		DrawModele(modele, canvas);
		
	}



	@Override
	public void update(Subject subj, Object data) {

		DrawModele(modele, canvas);
		
	}
	
	public VBox buttonBox( Modele modele) {
		VBox res=new VBox();
		Button yPlusButton=new Button("/\\");
		yPlusButton.setOnAction(e->{
			try {
				modele.turnOnXAxis(5);
			} catch (Exception e1) {}
		});

		Button xPlusButton=new Button(">");
		xPlusButton.setOnAction(e->{
			try {
				modele.turnOnYAxis(5);
			} catch (Exception e1) {}
		});

		Button yMoinsButton=new Button("\\/");
		yMoinsButton.setOnAction(e->{
			try {
				modele.turnOnXAxis(-5);
			} catch (Exception e1) {}
		});

		Button xMoinsButton=new Button("<");
		xMoinsButton.setOnAction(e->{
			try {
				modele.turnOnYAxis(-5);
			} catch (Exception e1) {}
		});
		HBox xButtonBox=new HBox();
		
		Button zoomButton =new Button("+");
		Button dezoomButton=new Button("-");
		zoomButton.setOnAction(e->{
			try {
				modele.homotetie(1.1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		dezoomButton.setOnAction(e->{
			try {
				modele.homotetie(0.9);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		Button zPlusButton=new Button("+z");
		Button zMoinsButton=new Button("-z");
		zPlusButton.setOnAction(e->{
			try {
				modele.turnOnZAxis(5);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		zMoinsButton.setOnAction(e->{
			try {
				modele.turnOnZAxis(-5);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		HBox highButtonBox=new HBox();
		highButtonBox.getChildren().addAll(dezoomButton, yPlusButton, zoomButton);
		HBox lowButtonBox=new HBox();
		lowButtonBox.getChildren().addAll(zPlusButton, yMoinsButton, zMoinsButton);
		xButtonBox.getChildren().addAll(xMoinsButton, xPlusButton);
		res.getChildren().addAll(highButtonBox, xButtonBox, lowButtonBox);
		return res;
		
	}

}