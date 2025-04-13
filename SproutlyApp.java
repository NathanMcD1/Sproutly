import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

public class SproutlyApp extends Application{
   public void start(Stage stage) throws Exception{
      Parent root = FXMLLoader.load(getClass().getResource("MainMenuFXML.fxml"));
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
   }
}