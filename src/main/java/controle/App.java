package controle;


import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import controle.FileProperty;
import controle.NameFilePropertyComparator;
import controle.NbFaceFilePropertyComparator;
import controle.NbPointFilePropertyComparator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import modele.AffichageMode;
import modele.FaceComparatorX;
import modele.FaceComparatorY;
import modele.FaceComparatorZ;
import modele.Lecture;
import modele.Modele;
import view.SliceView;
import view.View3D;


/**
 * JavaFX App
 */
public class App extends Application {

	protected Modele modele;
	protected Comparator<FileProperty> filePropertyComparator;
	protected String fileNamePattern;
	protected List<FileProperty> filePropertyList;
     @Override
    public void start(Stage primaryStage) throws Exception {
    	primaryStage.setTitle("Projet Modelisation");
        HBox root = new HBox();
        HBox haut = new HBox();
        HBox bas = new HBox();
        VBox affichage = new VBox();
        int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
        int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();
        primaryStage.setScene(new Scene(root,screenWidth,screenHeight));
        primaryStage.show();
        Lecture lecture=new Lecture();
        filePropertyComparator=new NameFilePropertyComparator();
        filePropertyList=new ArrayList<>();
        fileNamePattern="";
        modele = lecture.creation_modele("./exemples/vache.ply");
        System.out.println(("ok"));
        View3D xView=new View3D(300, 300, new FaceComparatorX(), modele);
        View3D yView=new View3D(300, 300, new FaceComparatorY(), modele);
        View3D zView=new View3D(300, 300, new FaceComparatorZ(), modele);
        SliceView sliceView=new SliceView(300, 300, modele, 0);
        modele.attach(zView);
        modele.attach(xView);
        modele.attach(yView);
        modele.attach(sliceView);

      
        try {


        haut.getChildren().addAll(zView,yView);
        bas.getChildren().addAll(xView,sliceView);
        affichage.getChildren().addAll(haut,bas);
        affichage.setPrefSize(screenWidth*2/3, screenHeight);
        //root.getChildren().addAll(zView, yView, xView, sliceView);
        root.getChildren().addAll(affichage);
    	
        ListView<HBox> listeModele= listeModele();
        TextField searchBar=new TextField();
		searchBar.textProperty().addListener((obs, oldText, newText) -> {
			fileNamePattern=newText;
			updateListeModel(listeModele);			
		});
        Button loadingButton=new Button("Charger modèle");
        loadingButton.setMinSize(200, 40);
        loadingButton.setOnAction(e->{
        	try {
        		Label nameLabel=(Label) listeModele.getSelectionModel().getSelectedItem().getChildren().get(0);
				Modele tmp = lecture.creation_modele(searchFilePath(nameLabel.getText()));
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
        	filePropertyComparator=new NameFilePropertyComparator();
        	updateListeModel(listeModele);
        	nameSortButton.setDisable(true);
        	pointSortButton.setDisable(false);
        	faceSortButton.setDisable(false);
        });
        nameSortButton.setDisable(true);
        pointSortButton.setOnAction(e->{
        	filePropertyComparator=new NbPointFilePropertyComparator();
        	updateListeModel(listeModele);
        	nameSortButton.setDisable(false);
        	pointSortButton.setDisable(true);
        	faceSortButton.setDisable(false);
        });
        faceSortButton.setOnAction(e->{
        	filePropertyComparator=new NbFaceFilePropertyComparator();
        	updateListeModel(listeModele);
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
        Slider zSliceSlider=new Slider(-100, 100, 0.1);
        zSliceSlider.setMaxSize(20, 200);
        zSliceSlider.setValue(0);
        zSliceSlider.setOrientation(Orientation.VERTICAL);
        zSliceSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
        sliceView.update(modele, newValue);
         });
        root.getChildren().addAll(buttons(),zSliceSlider, fileBox);
        
        //root.getChildren().addAll(buttonBox( modele), afficheMoveButton(), zSliceSlider,affichageModeBox(), fileBox);

        
       
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
		res.setSpacing(20);
		res.setAlignment(Pos.TOP_CENTER);
		res.getChildren().addAll(afficheMoveButton(),afficherTransformButton(),affichageModeBox());
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
	      conteneurButton.setSpacing(10);
		
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


	/*
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
		filePropertyList.clear();
		ListView<HBox> res=new ListView<>();
		File path = new File("exemples"+File.separator);
		String[] filelist = path.list();
		for (String string : filelist) {
			FileProperty tmp=new FileProperty(string);
			filePropertyList.add(tmp);
			//res.getItems().add(createListViewFileName(tmp));
		}
		updateListeModel(res);
		return res;
	}
	
	public HBox affichageModeBox() {
		Button filDeFerButton =new Button("Fil de fer");
		filDeFerButton.setPrefSize(40,35);
		Button faceButton=new Button("Faces");
		faceButton.setPrefSize(40,35);
		Button completButton=new Button("Complet");
		completButton.setPrefSize(40,35);
		filDeFerButton.setOnAction(e->{
			modele.setAffichageMode(AffichageMode.FIL_DE_FER);
		});
		faceButton.setOnAction(e->{
			modele.setAffichageMode(AffichageMode.FACE);
		});
		completButton.setOnAction(e->{
			modele.setAffichageMode(AffichageMode.COMPLET);
		});
		HBox res=new HBox();
		res.setSpacing(10);
		res.getChildren().addAll(filDeFerButton, faceButton, completButton);
		return res;
		
	}
	
	public HBox createListViewFileName(FileProperty fileProperty) {
		Label nameLabel=new Label(fileProperty.getName());
		nameLabel.setMinSize(90, 30);
		nameLabel.setStyle("-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;"+"-fx-padding: 5px;");
		String nbPoint=""+fileProperty.getNbPoint();
		Label pointLabel=new Label(nbPoint);
		pointLabel.setStyle("-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;"+"-fx-padding: 5px;");
		pointLabel.setMinSize(60, 30);
		String nbFace=""+fileProperty.getNbFace();
		Label faceLabel=new Label(nbFace);
		faceLabel.setStyle("-fx-border-style: solid inside;"
		        + "-fx-border-width: 2;"+"-fx-padding: 5px;");
		faceLabel.setMinSize(60, 30);
		HBox res=new HBox();
		res.getChildren().addAll(nameLabel,pointLabel,faceLabel);
		//return res;
		return res;
	}

	protected String searchFilePath(String name) {
		for (FileProperty fileProperty : filePropertyList) {
			if(fileProperty.getName().equals(name)) {
				return fileProperty.getPath();
			}
		}
		return null;
	}
	
	protected void updateListeModel(ListView<HBox> listeModele) {
		listeModele.getItems().clear();
		List<FileProperty> tmp=new ArrayList<>();
		for (FileProperty fileProperty : filePropertyList) {
			if(fileProperty.getName().contains(fileNamePattern)) {
				tmp.add(fileProperty);
			}
		}
		tmp.sort(filePropertyComparator);
		for (FileProperty fileProperty : tmp) {
			listeModele.getItems().add(createListViewFileName(fileProperty));
		}
	}
}