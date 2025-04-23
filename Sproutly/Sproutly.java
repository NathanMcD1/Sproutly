package Sproutly;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
    
   @Override
    public void stop() throws Exception {
      super.stop();
      if(user.getGoalTarget() != 0){
         Connection connection = DriverManager.getConnection("jdbc:sqlite:Sproutly\\DataBase\\SproutlyData.db");
         Statement statement = connection.createStatement();
         String sql = String.format("INSERT INTO users(username, password, goal, goalTarget, goalCurrent) " +
                                    "VALUES('%s', '%s', '%s', %d, %d) " +
                                    "ON CONFLICT(username) DO UPDATE SET " +
                                    "password = excluded.password, " +
                                    "goal = excluded.goal, " +
                                    "goalTarget = excluded.goalTarget, " +
                                    "goalCurrent = excluded.goalCurrent;",
         user.getUsername(), user.getPassword(), user.getGoal(), user.getGoalTarget(), user.getGoalCurrent());
         statement.executeUpdate(sql);
         System.out.println("Updated!");
         statement.close();
         connection.close();
      }
   }
}
