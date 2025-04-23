package Sproutly.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Sproutly.Sproutly;
import Sproutly.Models.Account;

public class MainMenuController implements UserAware {
    private Account user;

    @FXML private Button mainMenuButton;
    
    @FXML private ImageView mainMenuImageView;

    @FXML void openLoginMenu(ActionEvent event) throws Exception {
        Sproutly.openMenu("LoginMenuFXML.fxml");
    }

    @FXML void initialize() {
        mainMenuImageView.setImage(new Image("Sproutly\\Images\\SproutlyLogo.jpg"));
    }

    @Override
    public void setUser(Account user) {
        this.user = user;
    }
}
