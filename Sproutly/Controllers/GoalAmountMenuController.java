package Sproutly.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import Sproutly.Sproutly;
import Sproutly.Models.Account;

public class GoalAmountMenuController implements UserAware {
    private Account user;
      
    @FXML private Label titleLabel;
    @FXML private TextField amountField;
    @FXML private Button backButton, backspaceButton, enterButton;
    @FXML private Button button0, button1, button2, button3, button4,
                        button5, button6, button7, button8, button9;

    @FXML
    void backspace(ActionEvent event) {
        String text = amountField.getText();
        if (!text.isEmpty()) {
            amountField.setText(text.substring(0, text.length() - 1));
        }
    }

    @FXML
    void updateAmountField(ActionEvent event) {
        amountField.setText(amountField.getText() + ((Button) event.getSource()).getText());
    }

    @FXML
    void openProgressMenu(ActionEvent event) throws Exception {
      if(amountField.getText().equals("")){
         amountField.setText("0");
      }
      if(event.getSource() != backButton){
         if(!user.getIsNew()){
               user.setGoalCurrent(user.getGoalCurrent() + Integer.parseInt(amountField.getText()));
         }else{
            if(user.getUpdate()){
               user.setGoalCurrent(Integer.parseInt(amountField.getText()));
               user.setUpdate(false);
            }else{
               user.setGoalTarget(Integer.parseInt(amountField.getText()));
            }
         }
      }
      Sproutly.openMenu("ProgressMenuFXML.fxml");
    }

    @Override
    public void setUser(Account user) {
        if(!user.getIsNew()){
            titleLabel.setText("How Much Did You Save?");
        }else{
            backButton.setVisible(false);
        }
        this.user = user;
    }
}
