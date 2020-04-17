
package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) throws IllegalArgumentException {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JDub's Awesome Resto");

        Parent root = FXMLLoader.load(getClass().getResource("CreateMenuItem.fxml"));
        Scene scene = new Scene (root);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
