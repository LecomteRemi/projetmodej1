package controle;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import controle.SortingMode;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
        primaryStage.setScene(new Scene(root,1400,500));
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
       // root.getChildren().addAll(buttonBox( modele), translationButtonPane(modele),affichageModeBox(), fileBox);
        root.getChildren().addAll(buttons(),affichageModeBox(), fileBox);

        
       
        } catch (Exception e) {
        	System.out.println("\n\n-------------------"+e.toString());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
  




	public static void main(String[] args) {
        launch();
    }
	
	public VBox buttons() {
		VBox res = new VBox();
		res.getChildren().addAll(afficheMoveButton(),afficherTransformButton());
		return res;
		
	}

	public VBox afficheMoveButton() {
		  BorderPane root = new BorderPane();
		  root.setMaxSize(200, 200);
	      root.setPadding(new Insets(15, 20, 10, 10));
	      /*
	      HBox conteneurPrincipale = new HBox();
	      conteneurPrincipale.setSpacing(10);
	      conteneurPrincipale.setPadding(new Insets(15,20, 10,10));
	      */
	      VBox conteneurButton = new VBox();
		
	      // TOP
	      Button upTranslationButton=new Button("up");
	      upTranslationButton.setPrefSize(35, 35);
	      upTranslationButton.setOnAction(e->{
				try {
					modele.translation(0, 1, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	      upTranslationButton.setPadding(new Insets(10, 10, 10, 10));
	      root.setTop(upTranslationButton);
	      BorderPane.setAlignment(upTranslationButton, Pos.TOP_CENTER);
	      BorderPane.setMargin(upTranslationButton, new Insets(10, 10, 10, 10));
	     

	      // LEFT
	      Button leftTranslationButton=new Button("left");
	      leftTranslationButton.setPrefSize(35, 35);
	      leftTranslationButton.setPadding(new Insets(5, 5, 5, 5));
	      leftTranslationButton.setOnAction(e->{
				try {
					modele.translation(-1, 0, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	      root.setLeft(leftTranslationButton);
	      BorderPane.setAlignment(leftTranslationButton, Pos.CENTER_LEFT);
	      BorderPane.setMargin(leftTranslationButton, new Insets(10, 10, 10, 10));
	     
	      // CENTER
	      Button barycenterButton=new Button("o");
	      barycenterButton.setPrefSize(35, 35);
	      barycenterButton.setPadding(new Insets(5, 5, 5, 5));
	      barycenterButton.setOnAction(e->{
				modele.toBarycenter();
			});
	      root.setCenter(barycenterButton);
	      BorderPane.setAlignment(barycenterButton, Pos.CENTER);
	      
	      // RIGHT
	     
	      Button rightTranslationButton=new Button("right");
	      rightTranslationButton.setPrefSize(35, 35);
	      rightTranslationButton.setPadding(new Insets(5, 5, 5, 5));
	      rightTranslationButton.setOnAction(e->{
				try {
					modele.translation(1, 0, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	      root.setRight(rightTranslationButton);
	      BorderPane.setAlignment(rightTranslationButton, Pos.CENTER_RIGHT);
	      BorderPane.setMargin(rightTranslationButton, new Insets(10, 10, 10, 10));

	      // BOTTOM
	      Button downTranslationButton=new Button("down");
	      downTranslationButton.setPrefSize(35, 35);
	      downTranslationButton.setPadding(new Insets(5, 5, 5, 5));
	      downTranslationButton.setOnAction(e->{
				try {
					modele.translation(0, -1, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
	      root.setBottom(downTranslationButton);
	      BorderPane.setAlignment(downTranslationButton, Pos.BOTTOM_CENTER);
	      BorderPane.setMargin(downTranslationButton, new Insets(10, 10, 10, 10));
	      
	      conteneurButton.getChildren().addAll(root);
	      //conteneurPrincipale.getChildren().addAll(conteneurButton);
	    

		return conteneurButton ;
	}
	
	
	public VBox afficherTransformButton() {
	
	      VBox conteneurButton = new VBox();
	      conteneurButton.setAlignment(Pos.CENTER);
	      VBox conteneurButtons = new VBox();
	      conteneurButtons.setAlignment(Pos.CENTER);
	      
	      // translation selon x
	      Button xPlusButton=new Button("+x");
		  xPlusButton.setPrefSize(35, 35);
		  xPlusButton.setOnAction(e->{
				try {
					modele.turnOnYAxis(-5);
				} catch (Exception e1) {}
			});
	     
	      Button xMoinsButton=new Button("-x");
	      xMoinsButton.setPrefSize(35, 35);
	      xMoinsButton.setOnAction(e->{
	    	  try {
					modele.turnOnYAxis(5);
				} catch (Exception e1) {}
			});
	   
	      Label rx = new Label("rotation x ");
	      HBox rotationX = new HBox(xPlusButton,rx,xMoinsButton);
	      rotationX.setSpacing(10);
	      conteneurButton.getChildren().add(rotationX);

	      
	      // transformation selon l'axe y
	      
	      Button yPlusButton=new Button("+y");
	      yPlusButton.setPrefSize(35, 35);
	     // yPlusButton.setPadding(new Insets(10, 10, 10, 10));
	      yPlusButton.setOnAction(e->{
				try {
					modele.turnOnYAxis(5);
				} catch (Exception e1) {}
			});
	      //BorderPane.setAlignment(yPlusButton, Pos.CENTER);
	      //BorderPane.setMargin(yPlusButton, new Insets(10, 10, 10, 10));
	     
	      Button yMoinsButton=new Button("-y");
	      yMoinsButton.setPrefSize(35, 35);
	      //yMoinsButton.setPadding(new Insets(10, 10, 10, 10));
	      yMoinsButton.setOnAction(e->{
	    	  try {
					modele.turnOnYAxis(5);
				} catch (Exception e1) {}
			});
	      //BorderPane.setAlignment(yMoinsButton, Pos.CENTER);
	      //BorderPane.setMargin(yMoinsButton, new Insets(10, 10, 10, 10));
	      Label ry = new Label("rotation y ");
	      HBox rotationy = new HBox(yPlusButton,ry,yMoinsButton);
	      rotationy.setSpacing(10);
	      conteneurButton.getChildren().add(rotationy);
	      
	      
	      // rotation selon z
	      
	      Button zPlusButton=new Button("+z");
	      zPlusButton.setPrefSize(35, 35);
	      //zPlusButton.setPadding(new Insets(10, 10, 10, 10));
	      zPlusButton.setOnAction(e->{
				try {
					modele.turnOnZAxis(5);
				} catch (Exception e1) {}
			});
	      //BorderPane.setAlignment(yPlusButton, Pos.CENTER);
	      //BorderPane.setMargin(yPlusButton, new Insets(10, 10, 10, 10));
	     
	      Button zMoinsButton=new Button("-z");
	      zMoinsButton.setPrefSize(35, 35);
	      //zMoinsButton.setPadding(new Insets(10, 10, 10, 10));
	      zMoinsButton.setOnAction(e->{
	    	  try {
					modele.turnOnZAxis(5);
				} catch (Exception e1) {}
			});
	      //BorderPane.setAlignment(yMoinsButton, Pos.CENTER);
	      //BorderPane.setMargin(yMoinsButton, new Insets(10, 10, 10, 10));
	      Label rz = new Label("rotation z");
	      HBox rotationz = new HBox(zPlusButton,rz,zMoinsButton);
	      rotationz.setSpacing(10);
	      conteneurButton.getChildren().add(rotationz);
	      
	      // zoome
	      Button zoomButton=new Button("+");
	      zoomButton.setPrefSize(35, 35);
	      //zoomButton.setPadding(new Insets(10, 10, 10, 10));
	      zoomButton.setOnAction(e->{
				try {
					modele.turnOnYAxis(5);
				} catch (Exception e1) {}
			});
	     // BorderPane.setAlignment(zoomButton, Pos.CENTER);
	      //BorderPane.setMargin(zoomButton, new Insets(10, 10, 10, 10));
	     
	      Button dezoomButton=new Button("-");
	      dezoomButton.setPrefSize(35, 35);
	      //dezoomButton.setPadding(new Insets(10, 10, 10, 10));
	      dezoomButton.setOnAction(e->{
	    	  try {
					modele.turnOnYAxis(5);
				} catch (Exception e1) {}
			});
	      //BorderPane.setAlignment(dezoomButton, Pos.CENTER);
	      //BorderPane.setMargin(dezoomButton, new Insets(10, 10, 10, 10));
	      Label rzm = new Label(" Zoom     ");
	      HBox dezoom = new HBox(zoomButton,rzm,dezoomButton);
	      dezoom.setSpacing(10);
	      conteneurButton.getChildren().add(dezoom);
	      conteneurButton.setSpacing(10);
	      conteneurButtons.getChildren().addAll(conteneurButton);
		return conteneurButtons;
		
	}


	
	public VBox buttonBox( Modele modele) {
		VBox res=new VBox();
		Button yPlusButton=new Button("1");
		yPlusButton.setPrefSize(35, 35);
		yPlusButton.setOnAction(e->{
			try {
				modele.turnOnXAxis(-5);
			} catch (Exception e1) {}
		});

		Button xPlusButton=new Button("2");
		xPlusButton.setPrefSize(35, 35);
		xPlusButton.setOnAction(e->{
			try {
				modele.turnOnYAxis(-5);
			} catch (Exception e1) {}
		});

		Button yMoinsButton=new Button("3");
		yMoinsButton.setPrefSize(35, 35);
		yMoinsButton.setOnAction(e->{
			try {
				modele.turnOnXAxis(5);
			} catch (Exception e1) {}
		});

		Button xMoinsButton=new Button("4");
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
	/*
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
	*/
	
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