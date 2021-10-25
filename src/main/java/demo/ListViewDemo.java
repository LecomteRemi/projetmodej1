package demo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ListViewDemo extends Application {

  @Override
  public void start(Stage stage) {

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

      StackPane root = new StackPane();
      root.getChildren().add(listView);

      stage.setTitle("ListView (o7planning.org)");

      Scene scene = new Scene(root, 350, 200);
      stage.setScene(scene);
      stage.show();
  }

  public static void main(String[] args) {
      launch(args);
  }
}