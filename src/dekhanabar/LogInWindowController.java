/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dekhanabar;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LogInWindowController {

    @FXML
    private Label StatusId;

    @FXML
    private JFXPasswordField PasswordId;

    @FXML
    private JFXTextField UsernameId;
    
    private boolean LoggedIn = false;
    private Scanner me; 
    
    @FXML
    void loginButtonPressed(ActionEvent event) throws IOException {
        
        me = new Scanner(new File("UsernameAndPassword.txt"));
        
        while(me.hasNext()){
            String Username = me.next();
            String Password = me.next();
//            System.out.println(Username + "and" + Password);
 //           String[] UserNameAndPasswordArray = UsernameAndPassword.split(" ");
//            System.out.println(UserNameAndPasswordArray[0] + UserNameAndPasswordArray[1]);
            
            if(UsernameId.getText().equals(Username) && PasswordId.getText().equals(Password)){
//            if(UsernameId.getText().equals("") && PasswordId.getText().equals("")){
                LoggedIn = true;
                Parent MainWindowParent = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
                Scene MainWindowScene = new Scene(MainWindowParent);
             //   System.out.println(UserNameAndPasswordArray[0] + " " + UserNameAndPasswordArray[1]);
                Stage MainWindowStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                MainWindowStage.setTitle("Dekhan");
                MainWindowStage.setScene(MainWindowScene);
                MainWindowStage.show(); 
                break;
            }
        }
        
        if(LoggedIn == false){
            StatusId.setText("Wrong Username or Password.");
        }
    }
    
    @FXML
    void SingUpButtonPressed(ActionEvent event) throws IOException {
        Parent SignUpWindowParent = FXMLLoader.load(getClass().getResource("SignupWindow.fxml"));
        Scene SignUpWindowScene = new Scene(SignUpWindowParent);
        Stage SignUpWindowStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        SignUpWindowStage.setTitle("Sign up(Dekhan)");
        SignUpWindowStage.setScene(SignUpWindowScene);
        SignUpWindowStage.show();
    }

}
