public class SproutlyModel{
   private String username;
   private String password;
   private String goal;
   private int goalTarget;
   private int goalCurrent;
   
   public SproutlyModel(){
      username = "";
      password = "1234";
      goal = "";
      goalTarget = 0;
      goalCurrent = 0;
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
   public String getPassword(String username){
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
}