package Sproutly.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import Sproutly.Sproutly;
import Sproutly.Models.Account;

import javax.swing.*;

public class ReasonMenuController implements UserAware {
    private Account user;

    @FXML private Button billsButton, carButton, emergenciesButton, homeButton,
                   otherButton, retirementButton, schoolButton, tripButton;

    @FXML
    void otherGoal(ActionEvent event) throws Exception {
        user.setGoal(JOptionPane.showInputDialog(null, "Input your desired goal:"));
        Sproutly.openMenu("GoalAmountMenuFXML.fxml");
    }

    @FXML
    void setGoal(ActionEvent event) throws Exception {
        user.setGoal(((Button) event.getSource()).getText());
        Sproutly.openMenu("GoalAmountMenuFXML.fxml");
    }

    @Override
    public void setUser(Account user) {
        this.user = user;
    }
}
