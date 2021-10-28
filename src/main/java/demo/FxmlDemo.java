
package demo;

import java.io.IOException;
/*
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.canvas.*;
*/

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.ArcType;
import javafx.scene.canvas.*;
import javafx.scene.control.Slider;

public class FxmlDemo extends Application {
	
	// java --module-path 'path-to-javafx-binaries/lib' --add-modules javafx.controls,javafx.fxml -jar .\projetmode.jar
	public void start(Stage stage) throws IOException {
		/*
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/simpleFxmlDemo.fxml"));
            Parent root = loader.load();
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("ProjetModeJ1");
            stage.setResizable(false);
            stage.show();
            
			AnchorPane root = new AnchorPane();
		       
		        root.setSpacing(10);
		        root.setPadding(new Insets(15,20, 10,10));
		       
		        Book book1 = new Book(1L, "J01", "Java IO Tutorial");
		        Book book2 = new Book(2L, "J02", "Java Enums Tutorial");
		        Book book3 = new Book(2L, "C01", "C# Tutorial for Beginners");

		        // To Creating a Observable List
		        ObservableList<Book> books = FXCollections.observableArrayList(book1, book2, book3);

		        // Create a ListView
		        ListView<Book> listView = new ListView<Book>(books);

		        // To set multiple selection model
		        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

		        // Select item at index = 1,2
		        listView.getSelectionModel().selectIndices(1, 2);

		        // Focus
		        listView.getFocusModel().focus(1);

		        //StackPane root = new StackPane();
		        root.getChildren().add(listView);
		        
		        // Button up
		        Button button1 = new Button("/\\");
		        button1.setPrefSize(20, 20);
		        root.getChildren().add(button1);
		        //AnchorPane.setTopAnchor(button1, 100.0);
		        AnchorPane.setBottomAnchor(button1, 125.0);
		        //AnchorPane.setLeftAnchor(button1, 100.0);
		        AnchorPane.setRightAnchor(button1, 100.0);
		       
		       
		        // Button bas
		        Button button2 = new Button("\\/");
		        button2.setPrefSize(20, 20);
		        root.getChildren().add(button2);
		        AnchorPane.setBottomAnchor(button2, 75.0);
		        AnchorPane.setRightAnchor(button2, 100.0);
		        
		        // Button de droite
		        Button button3 = new Button(">");
		        button3.setPrefSize(20, 20);
		        root.getChildren().add(button3);
		        AnchorPane.setBottomAnchor(button3, 100.0);
		        AnchorPane.setRightAnchor(button3, 73.0);
		       
		       
		        // Button de gauche
		        Button button4 = new Button("<");
		        button4.setPrefSize(20, 20);
		        root.getChildren().add(button4);
		        AnchorPane.setBottomAnchor(button4, 100.0);
		        AnchorPane.setRightAnchor(button4, 125.0);
		        
		        //slider
		        Slider slider = new Slider(0, 180, 0);
		        slider.setOrientation(Orientation.VERTICAL);
		        root.getChildren().add(slider);
		        AnchorPane.setTopAnchor(slider, 100.0);
		        AnchorPane.setRightAnchor(slider, 125.0);
		       
		        Canvas canvas = new Canvas(250,250);
		        GraphicsContext gc = canvas.getGraphicsContext2D();
		        //drawShapes(gc);
		        canvas.setStyle("-fx-background-color: red");
		        root.getChildren().add(canvas);
		        //AnchorPane.setTopAnchor(canvas, 100.0);
		        //AnchorPane.setRightAnchor(canvas, 100.0);
		        
		        // TextField
		        TextField textField = new TextField("Text Field");
		        textField.setPrefWidth(110);
		         
		       
		        root.getChildren().add(textField);
		       
		        // CheckBox
		        CheckBox checkBox = new CheckBox("Check Box");
		         
		        root.getChildren().add(checkBox);
		       
		        // RadioButton
		        RadioButton radioButton = new RadioButton("Radio Button");
		        root.getChildren().add(radioButton);
		       
		        Scene scene = new Scene(root, 1280, 800);

		        stage.setTitle("ProjetModeJ1");
		        stage.setScene(scene);
		        stage.setResizable(false);
		        stage.show();
		        */
				Pane root = new Pane();
		
		        StackPane holder = new StackPane();
		        Canvas canvas = new Canvas(400,  300);
		        canvas.setLayoutX(100);
		        canvas.setLayoutY(400);
		        //slider
		        Slider slider = new Slider(0, 180, 0);
		        slider.setOrientation(Orientation.VERTICAL);
		        slider.setLayoutX(100);
		        slider.setLayoutY(100);
		       
		
		        holder.getChildren().add(canvas);
		        root.getChildren().add(holder);
		        root.getChildren().add(slider);
		
		        holder.setStyle("-fx-background-color: red");
		        Scene scene = new Scene(root, 1280, 800);
		        stage.setScene(scene);
		        stage.show();
		    }
/*
	private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GREEN);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.strokeLine(40, 10, 10, 40);
        gc.fillOval(10, 60, 30, 30);
        gc.strokeOval(60, 60, 30, 30);
        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
        gc.fillPolygon(new double[]{10, 40, 10, 40},
                       new double[]{210, 210, 240, 240}, 4);
        gc.strokePolygon(new double[]{60, 90, 60, 90},
                         new double[]{210, 210, 240, 240}, 4);
        gc.strokePolyline(new double[]{110, 140, 110, 140},
                          new double[]{210, 210, 240, 240}, 4);
    }
    */
	
    public static void main(String[] args) {
            Application.launch(args);
    }
}