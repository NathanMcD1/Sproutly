package Sproutly.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import Sproutly.Sproutly;
import Sproutly.Models.Account;

public class CreateAccountMenuController implements UserAware {
    private Account user;

    @FXML private TextField createAccountUsernameField;
    @FXML private TextField createAccountPasswordField;
    @FXML private Button createAccountButton;
    @FXML private Hyperlink loginLink;

    @FXML
    void createAccount(ActionEvent event) throws Exception {
        user.setUsername(createAccountUsernameField.getText());
        user.setPassword(createAccountPasswordField.getText());
        Sproutly.openMenu("ReasonMenuFXML.fxml");
    }

    @FXML
    void openLoginMenu(ActionEvent event) throws Exception {
        Sproutly.openMenu("LoginMenuFXML.fxml");
    }

    @Override
    public void setUser(Account user) {
        this.user = user;
    }
}
