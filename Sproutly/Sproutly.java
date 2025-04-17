package Sproutly;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import Sproutly.Models.Account;
import Sproutly.Controllers.UserAware;

public class Sproutly extends Application {
    private static Stage stage;
    private static Account user = new Account();

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        openMenu("MainMenuFXML.fxml");
    }

    public static void openMenu(String fxml) throws Exception {
        FXMLLoader loader = new FXMLLoader(Sproutly.class.getResource("/Sproutly/Views/" + fxml));
        Scene scene = new Scene(loader.load());

        Object controller = loader.getController();
        if (controller instanceof UserAware userAware) {
            userAware.setUser(user);
        }

        stage.setScene(scene);
        stage.setTitle("Sproutly");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
