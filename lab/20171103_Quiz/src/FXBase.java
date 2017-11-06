/**
 * Created by mwipfler on 11/3/17.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.jfr.events.ExceptionThrownEvent;

public class FXBase extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("BaseFMXL.fxml"));
            Scene mainScene = new Scene(root);

            primaryStage.setTitle("SWD Quiz!");
            primaryStage.setScene(mainScene);
            primaryStage.show();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
