package Sproutly.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import Sproutly.Sproutly;
import Sproutly.Models.Account;

public class LoginMenuController implements UserAware {
    private Account user;

    @FXML private TextField loginUsernameField;
    @FXML private TextField loginPasswordField;
    @FXML private Button loginButton;
    @FXML private Hyperlink createAccountLink;

    @FXML
    void login(ActionEvent event) throws Exception {
        user.setUsername(loginUsernameField.getText());

        if (loginPasswordField.getText().equals(user.getPassword(user.getUsername()))) {
            Sproutly.openMenu("ProgressMenuFXML.fxml");
        } else {
            loginPasswordField.setText("INCORRECT PASSWORD");
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
