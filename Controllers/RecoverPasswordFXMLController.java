/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package internships.management.system.Controllers;

import internships.management.system.Company;
import internships.management.system.Database;
import internships.management.system.Dean;
import internships.management.system.InternshipsManagementSystem;
import internships.management.system.Professor;
import internships.management.system.Student;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;

/**
 *
 * @author catal
 */
public class RecoverPasswordFXMLController {
    @FXML private TextField username;
    @FXML private TextField mail;
    @FXML private Text warning;
    
    @FXML 
    private void Send() throws Exception{
        ResultSet user = Database.instance.recoverPassword(username.getText(), mail.getText());
        if(user.next()){
            warning.setText("Imagine this is an e-mail, your password is: " + user.getString("pass"));
        } else {
            warning.setText("Username and mail do not match");
        }
    }
    
    @FXML
    private void LogIn() throws Exception{
        Stage stage = (Stage) username.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/LogIn.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
