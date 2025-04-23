package Sproutly.Models;

import java.sql.*;

public class Account{
   private String username;
   private String password;
   private String goal;
   private int goalTarget;
   private int goalCurrent;
   private boolean isNew;
   private boolean update;
   
   public Account(){
      username = "";
      password = "";
      goal = "";
      goalTarget = 0;
      goalCurrent = 0;
      isNew = true;
      update = false;
   }
   
   public void setAccount() throws Exception{
      String sql = "SELECT password, goal, goalTarget, goalCurrent FROM users WHERE username = '" + username + "'";
      Connection connection = DriverManager.getConnection("jdbc:sqlite:Sproutly\\DataBase\\SproutlyData.db");
      PreparedStatement ps = connection.prepareStatement(sql);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
         password = rs.getString("password");
         goal = rs.getString("goal");
         goalTarget = rs.getInt("goalTarget");
         goalCurrent = rs.getInt("goalCurrent");
         isNew = false;
      }
      ps.close();
      connection.close();
   }
   
   public void setUpdate(boolean update){
      this.update = update;
   }
   public boolean getUpdate(){
      return update;
   }
   
   public void setUsername(String username){
      this.username = username;
   }
   public String getUsername(){
      return username;
   }
   
   public void setPassword(String password){
      this.password = password;
   }
   public String getPassword(){
      return password;
   }
   
   public void setGoal(String goal){
      this.goal = goal;
   }
   public String getGoal(){
      return goal;
   }
   
   public void setGoalTarget(int goalTarget){
      this.goalTarget = goalTarget;
   }
   public int getGoalTarget(){
      return goalTarget;
   }
   
   public void setGoalCurrent(int goalCurrent){
      this.goalCurrent = goalCurrent;
   }
   public int getGoalCurrent(){
      return goalCurrent;
   }
   
   public void setIsNew(boolean isNew){
      this.isNew = isNew;
   }
   public boolean getIsNew(){
      return isNew;
   }
}