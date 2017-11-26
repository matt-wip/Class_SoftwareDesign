import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TipCalculator extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        try{
            Parent root = FXMLLoader.load(getClass().getResource("TipCalculator.fxml"));
            Scene mainScene = new Scene(root);

            primaryStage.setTitle("Tip Calculator");
            primaryStage.setScene(mainScene);
            primaryStage.show();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
