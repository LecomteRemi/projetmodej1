package view;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import controle.Repere;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modele.AffichageMode;
import modele.Face;
import modele.FaceComparatorX;
import modele.FaceComparatorY;
import modele.FaceComparatorZ;
import modele.FaceSorter;
import modele.Lecture;
import modele.Modele;
import modele.Point;
import utilitaire.Observer;
import utilitaire.Subject;
import view.View;


/**
 * JavaFX App
 */
public class App extends Application /*implements Observer*/{

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
	//Canvas canvas = new Canvas(300, 250);
	
    @Override
    public void start(Stage primaryStage) {
    	primaryStage.setTitle("Projet Modelisation");
        HBox root = new HBox();
        //GraphicsContext gc = canvas.getGraphicsContext2D();
       modele = Lecture.creation_modele("./exemples/fracttree.ply");
       System.out.println(("ok"));
     // modele.attach(this);
      listePoint = modele.getListPoints();
      listeface = modele.getListeFaces();
      View xView=new View(300, 300, new FaceComparatorX(), modele);
      View yView=new View(300, 300, new FaceComparatorY(), modele);
      View zView=new View(300, 300, new FaceComparatorZ(), modele);
      modele.attach(zView);
      modele.attach(xView);
      modele.attach(yView);

        
        
        //FaceSorter faceSorter = FaceSorter.faceSorterZ();
       // faceSorter.sort(listeface);

      
        try {
		
        try {
			//DrawModele(modele, canvas);
		} catch (Exception e1) {
			
        }
        
        root.getChildren().addAll(zView, yView, xView);
    	
			
   
        root.getChildren().addAll(buttonBox( modele), translationButtonPane(modele),affichageModeBox(), listeModele());
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
       
        } catch (Exception e) {
        	System.out.println("\n\n-------------------"+e.toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    
    
  
	
	/*protected void DrawModele(Modele modele, Canvas canvas) {
		List<Face> faceList=modele.getListeFaces();
		this.faceSorter.sort(faceList);
		GraphicsContext gc= canvas.getGraphicsContext2D();
		gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    	
		
		//faceSorter.sort(listeface); 
		for (Face face : modele.getListeFaces()) {
			double[] x=new double[3];
			double[] y=new double[3];
			for(int i=0; i<face.getPoints().size(); i++) {
				x[i]=face.getPoints().get(i).getX()*20+100;
				y[i]=face.getPoints().get(i).getY()*20+100;

			}
			gc.strokePolygon(x, y, face.getPoints().size());
			gc.setFill(Color.LIME);
			gc.fillPolygon(x, y, face.getPoints().size());
		}
		
	}*/




	public static void main(String[] args) {
        launch();
    }



/*	@Override
	public void update(Subject subj) {
		DrawModele(modele, canvas);
		
	}*/



	/*@Override
	public void update(Subject subj, Object data) {

		DrawModele(modele, canvas);
		
	}*/
	
	public VBox buttonBox( Modele modele) {
		VBox res=new VBox();
		Button yPlusButton=new Button("/\\");
		yPlusButton.setPrefSize(35, 35);
		yPlusButton.setOnAction(e->{
			try {
				modele.turnOnXAxis(-5);
			} catch (Exception e1) {}
		});

		Button xPlusButton=new Button(">");
		xPlusButton.setPrefSize(35, 35);
		xPlusButton.setOnAction(e->{
			try {
				modele.turnOnYAxis(-5);
			} catch (Exception e1) {}
		});

		Button yMoinsButton=new Button("\\/");
		yMoinsButton.setPrefSize(35, 35);
		yMoinsButton.setOnAction(e->{
			try {
				modele.turnOnXAxis(5);
			} catch (Exception e1) {}
		});

		Button xMoinsButton=new Button("<");
		xMoinsButton.setPrefSize(35, 35);
		xMoinsButton.setOnAction(e->{
			try {
				modele.turnOnYAxis(5);
			} catch (Exception e1) {}
		});
		HBox xButtonBox=new HBox();
		
		Button zoomButton =new Button("+");
		zoomButton.setPrefSize(35, 35);
		Button dezoomButton=new Button("-");
		dezoomButton.setPrefSize(35, 35);
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
		Button zPlusButton=new Button("z");
		zPlusButton.setPrefSize(35, 35);
		Button zMoinsButton=new Button("-z");
		zMoinsButton.setPrefSize(35, 35);
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
		lowButtonBox.getChildren().addAll(zMoinsButton, yMoinsButton, zPlusButton);
		xButtonBox.getChildren().addAll(xMoinsButton, xPlusButton);
		res.getChildren().addAll(highButtonBox, xButtonBox, lowButtonBox);
		return res;
		
	}
	
	public BorderPane translationButtonPane(Modele modele) {
		BorderPane res=new BorderPane();
		Button upTranslationButton=new Button("/|\\");
		Button downTranslationButton=new Button("\\|/");
		Button leftTranslationButton=new Button("<-");
		Button rightTranslationButton=new Button("->");
		Button barycenterButton=new Button("o");
		upTranslationButton.setPrefSize(35, 35);
		downTranslationButton.setPrefSize(35, 35);
		leftTranslationButton.setPrefSize(35, 35);
		rightTranslationButton.setPrefSize(35, 35);
		barycenterButton.setPrefSize(35, 35);
		upTranslationButton.setOnAction(e->{
			try {
				modele.translation(0, 1, 0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		downTranslationButton.setOnAction(e->{
			try {
				modele.translation(0, -1, 0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		leftTranslationButton.setOnAction(e->{
			try {
				modele.translation(-1, 0, 0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		rightTranslationButton.setOnAction(e->{
			try {
				modele.translation(1, 0, 0);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		barycenterButton.setOnAction(e->{
			modele.toBarycenter();
		});
		res.setBottom(downTranslationButton);
		res.setTop(upTranslationButton);
		res.setLeft(leftTranslationButton);
		res.setRight(rightTranslationButton);
		res.setCenter(barycenterButton);
		return res;
	}
	
	public ListView<String> listeModele(){
		ListView<String> res=new ListView<>();
		File path = new File("exemples"+File.separator);
		String[] filelist = path.list();
		for (String string : filelist) {
			
			res.getItems().add(string);
		}
		return res;
	}
	
	public VBox affichageModeBox() {
		Button filDeFerButton =new Button("Fil de fer");
		Button faceButton=new Button("Faces");
		Button completButton=new Button("Complet");
		filDeFerButton.setOnAction(e->{
			modele.setAffichageMode(AffichageMode.FIL_DE_FER);
		});
		faceButton.setOnAction(e->{
			modele.setAffichageMode(AffichageMode.FACE);
		});
		completButton.setOnAction(e->{
			modele.setAffichageMode(AffichageMode.COMPLET);
		});
		VBox res=new VBox();
		res.getChildren().addAll(filDeFerButton, faceButton, completButton);
		return res;
		
	}

}