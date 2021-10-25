
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
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
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
            */
			AnchorPane root = new AnchorPane();
		       /*
		        root.setSpacing(10);
		        root.setPadding(new Insets(15,20, 10,10));
		       */
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
		        button1.setPrefSize(10, 10);
		        root.getChildren().add(button1);
		       
		       
		        // Button bas
		        Button button2 = new Button("\\/");
		        button2.setPrefSize(10, 10);
		        root.getChildren().add(button2);
		        
		        // Button de droite
		        Button button3 = new Button(">");
		        button3.setPrefSize(10, 10);
		        root.getChildren().add(button3);
		       
		       
		        // Button de gauche
		        Button button4 = new Button("<");
		        button4.setPrefSize(10, 10);
		        root.getChildren().add(button4);
		        
		        //slider
		        Slider slider = new Slider(0, 180, 0);
		        slider.setOrientation(Orientation.VERTICAL);
		        root.getChildren().add(slider);
		       
		        Canvas canvas = new Canvas(250,250);
		        root.getChildren().add(canvas);
		        
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
		       
		        Scene scene = new Scene(root, 640, 400);

		        stage.setTitle("ProjetModeJ1");
		        stage.setScene(scene);
		        stage.setResizable(false);
		        stage.show();
		    }

    public static void main(String[] args) {
            Application.launch(args);
    }
}