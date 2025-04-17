package Sproutly.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import Sproutly.Sproutly;
import Sproutly.Models.Account;

public class MainMenuController implements UserAware {
    private Account user;

    @FXML private Button mainMenuButton;

    @FXML void openLoginMenu(ActionEvent event) throws Exception {
        Sproutly.openMenu("LoginMenuFXML.fxml");
    }

    @FXML void initialize() {
        assert mainMenuButton != null : "fx:id=\"mainMenuButton\" was not injected: check your FXML file 'MainMenuFXML.fxml'.";
    }

    @Override
    public void setUser(Account user) {
        this.user = user;
        // You can update UI here if needed
    }
}
