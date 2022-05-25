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
import javafx.stage.Stage;

/**
 *
 * @author catal
 */
public class LogInFXMLController {
    @FXML private TextField username;
    @FXML private PasswordField password;
    @FXML private Text warning;
    
    @FXML 
    private void LogIn() throws Exception{
        ResultSet user = Database.instance.checkUser(username.getText());
        if(user.next()){
            if (user.getString("pass").equals(password.getText())){
               Stage stage = (Stage) username.getScene().getWindow();
               Parent root;

               switch(user.getString("user_type")){
                   case "Dean":
                       InternshipsManagementSystem.activeUser = new Dean(user.getString("name"), user.getString("pass"), user.getString("mail"));
                       root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/MainMenuDean.fxml"));
                       break;
                   case "Company":
                       InternshipsManagementSystem.activeUser = new Company(user.getString("name"), user.getString("pass"), user.getString("mail"), 
                               user.getString("description"));
                       root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/MainMenuCompany.fxml"));
                       break;
                   case "Student":
                       InternshipsManagementSystem.activeUser = new Student(user.getString("name"), user.getString("pass"), user.getString("mail"), 
                               user.getString("description"), user.getString("specialization"), user.getString("group"));
                       root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/MainMenuStudent.fxml"));
                       break;
                   default:
                       InternshipsManagementSystem.activeUser = new Professor(user.getString("name"), user.getString("pass"), user.getString("mail"));
                       root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/MainMenuProfessor.fxml"));
                       break;
               }

               Scene scene = new Scene(root);
               stage.setScene(scene);
               stage.show();
            }
            else
                warning.setText("Password incorrect");
        } else
                warning.setText("No user with this username");
    }
    
    @FXML
    private void RecoverPassword() throws Exception{
        Stage stage = (Stage) username.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/RecoverPassword.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
