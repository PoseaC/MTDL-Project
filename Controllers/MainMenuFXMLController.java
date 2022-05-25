/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package internships.management.system.Controllers;

import internships.management.system.InternshipsManagementSystem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author catal
 */
public class MainMenuFXMLController {
    @FXML private Text Title;
    
    @FXML 
    private void Profile() throws Exception{
        Stage stage = (Stage) Title.getScene().getWindow();
        Parent root;
        switch(InternshipsManagementSystem.activeUser.getType()){
            case Student:
                root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/ProfileStudent.fxml"));
                break;
            case Company:
                root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/ProfileCompany.fxml"));
                break;
            default:
                System.out.println(InternshipsManagementSystem.activeUser.getUsername() + " doesn't have a profile");
                return;
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML 
    private void Sign() throws Exception{
        Stage stage = (Stage) Title.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/SignConvention.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML 
    private void Users() throws Exception{
        Stage stage = (Stage) Title.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/Users.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML 
    private void CreateUser() throws Exception{
        Stage stage = (Stage) Title.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/CreateUser.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML 
    private void LogOut() throws Exception{
        Stage stage = (Stage) Title.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/LogIn.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML 
    private void InternshipsCompany() throws Exception{
        Stage stage = (Stage) Title.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/InternshipsCompany.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML 
    private void InternshipsStudent() throws Exception{
        Stage stage = (Stage) Title.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/InternshipsStudent.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML 
    private void PostInternship() throws Exception{
        Stage stage = (Stage) Title.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/PostInternship.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML 
    private void SearchInternship() throws Exception{
        Stage stage = (Stage) Title.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/SearchInternship.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
