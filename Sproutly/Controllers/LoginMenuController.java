package Sproutly.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import Sproutly.Sproutly;
import Sproutly.Models.Account;

/**
 * Handles user login functionality and navigation to progress menu or the create account menu.
 */

public class LoginMenuController implements UserAware {
    private Account user;

    @FXML private TextField loginUsernameField;
    @FXML private PasswordField loginPasswordField;
    @FXML private Button loginButton;
    @FXML private Hyperlink createAccountLink;

    @FXML
    void login(ActionEvent event) throws Exception {
        user.setUsername(loginUsernameField.getText());
        user.setAccount();
        if (loginPasswordField.getText().equals(user.getPassword()) && !user.getIsNew()) {
            Sproutly.openMenu("ProgressMenuFXML.fxml");
        } else {
            loginPasswordField.setText("");
        }
    }

    @FXML
    void openCreateAccountMenu(ActionEvent event) throws Exception {
        Sproutly.openMenu("CreateAccountMenuFXML.fxml");
    }

    @Override
    public void setUser(Account user) {
        this.user = user;
    }
}
