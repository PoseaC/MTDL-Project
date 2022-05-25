/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package internships.management.system.Controllers;

import internships.management.system.Company;
import internships.management.system.Database;
import internships.management.system.Dean;
import internships.management.system.Professor;
import internships.management.system.Student;
import internships.management.system.User;
import internships.management.system.UserType;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author catal
 */
public class CreateUserFXMLController {
    @FXML private TextField username;
    @FXML private TextField mail;
    @FXML private TextField password;
    @FXML private ToggleGroup type;
    @FXML private Text warning;
    
    @FXML 
    private void CreateUser() throws Exception{
        RadioButton btn = (RadioButton)type.getSelectedToggle();
        
        if (username.getText().isEmpty() || password.getText().isEmpty() || mail.getText().isEmpty()){
            warning.setText("All fields must be completed");
            return;
        }
        
        User newUser;
        switch(btn.getText()){
            case "Student":
                newUser = new Student(username.getText(), password.getText(), mail.getText());
                break;
            case "Company":
                newUser = new Company(username.getText(), password.getText(), mail.getText());
                break;
            case "Professor":
                newUser = new Professor(username.getText(), password.getText(), mail.getText());
                break;
            default:
                newUser = new Dean(username.getText(), password.getText(), mail.getText());
                break;
        }
        
        ResultSet query = Database.instance.checkUser(newUser.getUsername());
        if(query.next())
            warning.setText("User already exists");
        else{
            Database.instance.insertUser(newUser);
            username.setText("");
            password.setText("");
            mail.setText("");
            warning.setText("User added");
        }
    }
    
    @FXML 
    private void MainMenu() throws Exception{
        Stage stage = (Stage) username.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/MainMenuDean.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
