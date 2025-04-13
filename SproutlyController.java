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

public class SproutlyController {
   
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
   private TextField loginUsernameFiield;
   
   // Create Account Menu
   @FXML
   private Button createAccountButton;
   @FXML
   private TextField createAccountPasswordButton;
   @FXML
   private TextField createAccountUsernameField;
   @FXML
   private Hyperlink loginLink;
   
   // Reason Menu
   @FXML
   private Button BillsButton;
   @FXML
   private Button CarButton;
   @FXML
   private Button EmergenciesButton;
   @FXML
   private Button HomeButton;
   @FXML
   private Button OtherButton;
   @FXML
   private Button RetirementButton;
   @FXML
   private Button SchoolButton;
   @FXML
   private Button TripButton;
   
   // Goal Amount Menu
   @FXML
   private TextField AmountField;
   @FXML
   private Button backButton;
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
   private Button nextButton;
   
   // Progress Menu
   @FXML
   private Label goalField;
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
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("ProgressMenuFXML.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
   }
   
   @FXML
   void OpenReasonMenu(ActionEvent event) throws Exception {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("ReasonMenuFXML.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
   }
   
   @FXML
   void openGoalAmountMenu(ActionEvent event) throws Exception {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("GoalAmountMenuFXML.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
   }
   
   @FXML
   void OpenLoginMenu(ActionEvent event) throws Exception {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("LoginMenuFXML.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
   }

   @FXML
   void OpenCreateAccountMenu(ActionEvent event) throws Exception {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("CreateAccountMenuFXML.fxml"));
      Parent parent = loader.load();
      Scene scene = new Scene(parent);
      Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
      window.setScene(scene);
      window.show();
   }
   
   @FXML
   void otherGoal(ActionEvent event) {

   }
   
   @FXML
   void setGoal(ActionEvent event) {

   }
   
   @FXML
   void login(ActionEvent event) {
      
      OpenProgressMenu(event);
   }
   
   @FXML
   void backspace(ActionEvent event) {

   }
      
   @FXML
   void createAccount(ActionEvent event) {
   
      OpenReasonMenu(event);
   }
}
