package Sproutly.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.sql.*;
import javax.swing.*;
import Sproutly.Sproutly;
import Sproutly.Models.Account;

/**
 * Provides account options like viewing current progress, changing goals, or deleting the account.
 */

public class AccountMenuController implements UserAware {
   private Account user;

   @FXML private ResourceBundle resources;
   @FXML private URL location;
   @FXML private Button changeCurrent;
   @FXML private Label goalCurrentLabel, goalLabel, goalTargetLabel, usernameLabel;

   @FXML
   void deleteAccount(ActionEvent event) throws Exception {
      String sql = "DELETE FROM users WHERE username = '" + user.getUsername() + "';";
      Connection connection = DriverManager.getConnection("jdbc:sqlite:Sproutly\\DataBase\\SproutlyData.db");
      PreparedStatement ps = connection.prepareStatement(sql);
      int affected = ps.executeUpdate();
      if (affected > 0) {
         System.out.println("Deleted user");
      }else{
         System.out.println("Issue deleting user");
      }
      ps.close();
      connection.close();
      System.exit(0);
   }

   @FXML
   void openGoalAmountMenu(ActionEvent event) throws Exception {
      user.setIsNew(true);
      Sproutly.openMenu("GoalAmountMenuFXML.fxml");
   }
   
   @FXML
   void update(ActionEvent event) throws Exception {
      user.setIsNew(true);
      user.setUpdate(true);
      Sproutly.openMenu("GoalAmountMenuFXML.fxml");
   }
   
   @FXML
   void openReasonMenu(ActionEvent event) throws Exception {
      user.setIsNew(true);
      user.setGoalTarget(0);
      user.setGoalCurrent(0);
      Sproutly.openMenu("ReasonMenuFXML.fxml");
   }
   
   @FXML
   void openProgressMenu(ActionEvent event) throws Exception {
      Sproutly.openMenu("ProgressMenuFXML.fxml");
   }
   
   public void setUser(Account user) {
      this.user = user;
      goalCurrentLabel.setText(String.format("$%,d", user.getGoalCurrent()));
      goalLabel.setText(user.getGoal());
      goalTargetLabel.setText(String.format("$%,d", user.getGoalTarget()));
      usernameLabel.setText(user.getUsername());
   }
}
