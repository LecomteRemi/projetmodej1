package controle;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import controle.SortingMode;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import modele.AffichageMode;
import modele.FaceComparatorX;
import modele.FaceComparatorY;
import modele.FaceComparatorZ;
import modele.Lecture;
import modele.Modele;
import view.View;


/**
 * JavaFX App
 */
public class App extends Application {

	protected Modele modele;
	protected List<String> fileNameList;
	protected SortingMode sortingMode;
    @Override
    public void start(Stage primaryStage) throws Exception {
    	primaryStage.setTitle("Projet Modelisation");
        HBox root = new HBox();
        primaryStage.setScene(new Scene(root,1400,300));
        primaryStage.show();
        Lecture lecture=new Lecture();
        sortingMode=SortingMode.NAME;
        fileNameList=new ArrayList<>();
        modele = lecture.creation_modele("./exemples/vache.ply");
        System.out.println(("ok"));
        View xView=new View(300, 300, new FaceComparatorX(), modele);
        View yView=new View(300, 300, new FaceComparatorY(), modele);
        View zView=new View(300, 300, new FaceComparatorZ(), modele);
        modele.attach(zView);
        modele.attach(xView);
        modele.attach(yView);

      
        try {


        
        root.getChildren().addAll(zView, yView, xView);
    	
		
        ListView<HBox> listeModele= listeModele();
        TextField searchBar=new TextField();
		searchBar.textProperty().addListener((obs, oldText, newText) -> {
			fileNameList.clear();
			listeModele.getItems().clear();
			File path = new File("exemples"+File.separator);
			String[] filelist = path.list();
			for (String string : filelist) {
				if(string.contains(newText)) {
					fileNameList.add(string);
					listeModele.getItems().add(createListViewFileName(string));
				}
			}

			
			
		});
        Button loadingButton=new Button("Charger modèle");
        loadingButton.setMinSize(200, 40);
        loadingButton.setOnAction(e->{
        	try {
				Modele tmp = lecture.creation_modele("./exemples/"+fileNameList.get(listeModele.getSelectionModel().getSelectedIndex()));
				modele.replaceModele(tmp);
			} catch (Exception e1) {
				System.out.println(e.toString());
			}
        });
        Button nameSortButton=new Button("nom");
        Button pointSortButton=new Button("points");
        Button faceSortButton=new Button("faces");
        nameSortButton.setMinSize(100, 30);
        nameSortButton.setOnAction(e->{
        	sortingMode=SortingMode.NAME;
        	nameSortButton.setDisable(true);
        	pointSortButton.setDisable(false);
        	faceSortButton.setDisable(false);
        });
        pointSortButton.setOnAction(e->{
        	sortingMode=SortingMode.POINT;
        	nameSortButton.setDisable(false);
        	pointSortButton.setDisable(true);
        	faceSortButton.setDisable(false);
        });
        faceSortButton.setOnAction(e->{
        	sortingMode=SortingMode.FACE;
        	nameSortButton.setDisable(false);
        	pointSortButton.setDisable(false);
        	faceSortButton.setDisable(true);
        });
        pointSortButton.setMinSize(60, 30);
        faceSortButton.setMinSize(60, 30);
        HBox sortingButtonBox=new HBox();
        sortingButtonBox.getChildren().addAll(nameSortButton,pointSortButton,faceSortButton);
        VBox fileBox=new VBox();
        fileBox.getChildren().addAll(searchBar,sortingButtonBox, listeModele, loadingButton);
        root.getChildren().addAll(buttonBox( modele), translationButtonPane(modele),affichageModeBox(), fileBox);
        
       
        } catch (Exception e) {
        	System.out.println("\n\n-------------------"+e.toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
  




	public static void main(String[] args) {
        launch();
    }



	
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
		res.setMaxSize(105, 105);
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
	
	public ListView<HBox> listeModele(){
		fileNameList.clear();
		ListView<HBox> res=new ListView<>();
		File path = new File("exemples"+File.separator);
		String[] filelist = path.list();
		for (String string : filelist) {
			fileNameList.add(string);
			res.getItems().add(createListViewFileName(string));
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
	
	public HBox createListViewFileName(String fileName) {
		int[] nbPointAndFace=new Lecture().getNbPointAndFace("exemples"+File.separator+fileName);
		String name=fileName.substring(0, fileName.length()-4);
		if(name.length()>40) {
			name=name.substring(0, 37)+"...";
		}
		Label nameLabel=new Label(name);
		nameLabel.setMinSize(90, 30);
		nameLabel.setStyle("-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;"+"-fx-padding: 5px;");
		String nbPoint=""+nbPointAndFace[0];
		Label pointLabel=new Label(""+nbPoint);
		pointLabel.setStyle("-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;"+"-fx-padding: 5px;");
		pointLabel.setMinSize(60, 30);
		String nbFace=""+nbPointAndFace[1];
		Label faceLabel=new Label(""+nbFace);
		faceLabel.setStyle("-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;"+"-fx-padding: 5px;");
		faceLabel.setMinSize(60, 30);
		HBox res=new HBox();
		res.getChildren().addAll(nameLabel,pointLabel,faceLabel);
		//return res;
		return res;
	}

}