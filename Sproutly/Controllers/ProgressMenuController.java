package Sproutly.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Sproutly.Sproutly;
import Sproutly.Models.Account;

/**
 * Displays the user's progress toward their savings goal using a plant-growth theme.
 */

public class ProgressMenuController implements UserAware {
   private Account user;

   @FXML private Label goalLabel;
   
   @FXML private Label percentField;
   
   @FXML private ProgressBar progressBar;
   
   @FXML private ImageView progressMenuImageView;
   
   @FXML private Button waterButton;

   @FXML
   void openGoalAmountMenu(ActionEvent event) throws Exception {
      Sproutly.openMenu("GoalAmountMenuFXML.fxml");
   }
   
   @FXML
   void openAccountMenu(ActionEvent event) throws Exception {
      Sproutly.openMenu("AccountMenuFXML.fxml");
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
      
      String image = "";
      if (percent >= 1.00){
         image = "100.jpg";
      }else if (percent >= 0.75){
         image = "75.jpg";
      }else if (percent >= 0.50){
         image = "50.jpg";
      }else if (percent >= 0.25){
         image = "25.jpg";
      }else if (percent > 0.0){
         image = "1.jpg";
      }else{
         image = "0.jpg";
      }
      progressMenuImageView.setImage(new Image("Sproutly\\Images\\Grow" + image));
   }
}
