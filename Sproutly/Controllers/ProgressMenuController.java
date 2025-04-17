package Sproutly.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import Sproutly.Sproutly;
import Sproutly.Models.Account;

public class ProgressMenuController implements UserAware {
    private Account user;

    @FXML private Label goalLabel;
    @FXML private Label percentField;
    @FXML private ProgressBar progressBar;
    @FXML private ImageView treeImage;
    @FXML private Button waterButton;

    @FXML
    void openGoalAmountMenu(ActionEvent event) throws Exception {
        Sproutly.openMenu("GoalAmountMenuFXML.fxml");
    }

    @Override
    public void setUser(Account user) {
        this.user = user;
        user.setIsNew(false);
        goalLabel.setText(user.getGoal());
        int current = user.getGoalCurrent();
        int target = user.getGoalTarget();
        double percent = target > 0 ? (double) current / target : 0;
        percentField.setText(String.format("$%,d / $%,d (%.2f%%)",user.getGoalCurrent(), user.getGoalTarget(), percent * 100));
        progressBar.setProgress(percent);
    }
}
