import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.*;

public class SproutlyController {
   //Model
   private SproutlyModel model = new SproutlyModel();
   
   // Main Menu
   @FXML
   private Button mainMenuButton;
   
   // Login Menu
   @FXML
   private Hyperlink createAccountLink;
   @FXML
   private Button loginButton;
   @FXML
   private TextField loginPasswordField;
   @FXML
   private TextField loginUsernameField;
   
   // Create Account Menu
   @FXML
   private Button createAccountButton;
   @FXML
   private TextField createAccountPasswordField;
   @FXML
   private TextField createAccountUsernameField;
   @FXML
   private Hyperlink loginLink;
   
   // Reason Menu
   @FXML
   private Button billsButton;
   @FXML
   private Button carButton;
   @FXML
   private Button emergenciesButton;
   @FXML
   private Button homeButton;
   @FXML
   private Button otherButton;
   @FXML
   private Button retirementButton;
   @FXML
   private Button schoolButton;
   @FXML
   private Button tripButton;
   
   // Goal Amount Menu
   @FXML
   private TextField amountField;
   @FXML
   private Button backButton;
   @FXML
   private Button backspaceButton;
   @FXML
   private Button button0;
   @FXML
   private Button button1;
   @FXML
   private Button button2;
   @FXML
   private Button button3;
   @FXML
   private Button button4;
   @FXML
   private Button button5;
   @FXML
   private Button button6;
   @FXML
   private Button button7;
   @FXML
   private Button button8;
   @FXML
   private Button button9;
   @FXML
   private Button enterButton;
   
   // Progress Menu
   @FXML
   private Label goalLabel;
   @FXML
   private Label percentField;
   @FXML
   private ProgressBar progressBar;
   @FXML
   private ImageView treeImage;
   @FXML
   private Button waterButton;
   
   // Methods
   @FXML
   void openProgressMenu(ActionEvent event) throws Exception {
      SproutlyModel tempModel = this.model;
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("ProgressMenuFXML.fxml"));
      Parent parent = loader.load();
      SproutlyController progressCtrl = loader.getController();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
      progressCtrl.setModel(tempModel);
      progressCtrl.goalLabel.setText(this.model.getGoal());
   }
   
   @FXML
   void openReasonMenu(ActionEvent event) throws Exception {
      openMenu("ReasonMenuFXML.fxml", event);
   }
   
   @FXML
   void openGoalAmountMenu(ActionEvent event) throws Exception {
      openMenu("GoalAmountMenuFXML.fxml", event);
   }
   
   @FXML
   void openLoginMenu(ActionEvent event) throws Exception {
      openMenu("LoginMenuFXML.fxml", event);
   }

   @FXML
   void openCreateAccountMenu(ActionEvent event) throws Exception{
      openMenu("CreateAccountMenuFXML.fxml", event);
   }
   
   @FXML
   void openMenu(String fxml, ActionEvent event) throws Exception{
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource(fxml));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
   }
   
   @FXML
   void otherGoal(ActionEvent event) throws Exception{
      model.setGoal(JOptionPane.showInputDialog(null,"Input your desired goal:"));
      openGoalAmountMenu(event);
   }
   
   @FXML
   void setGoal(ActionEvent event) throws Exception{
      model.setGoal(((Button)event.getSource()).getText());
      openGoalAmountMenu(event);
   }
   
   @FXML
   void updateAmountField(ActionEvent event){
      amountField.setText(amountField.getText() + ((Button)event.getSource()).getText());
   }
   
   @FXML
   void backspace(ActionEvent event) {
      amountField.setText(amountField.getText().substring(0,amountField.getText().length()-1));
   }
   
   @FXML
   void login(ActionEvent event) throws Exception{
      model.setUsername(loginUsernameField.getText());
      if(loginPasswordField.getText().equals(model.getPassword(model.getUsername()))){
         openProgressMenu(event);
      }else{
         loginPasswordField.setText("INCORRECT PASSWORD");
      }
   }
   
   @FXML
   void createAccount(ActionEvent event) throws Exception{
      model.setUsername(createAccountUsernameField.getText());
      model.setPassword(createAccountPasswordField.getText());
      openReasonMenu(event);
   }
   
   @FXML
   void setModel(SproutlyModel model){
      this.model = model;
   }
}
