/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package internships.management.system.Controllers;

import internships.management.system.Database;
import internships.management.system.InternshipsManagementSystem;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author catal
 */
public class ProfileCompanyFXMLController {
    @FXML private TextField name;
    @FXML private TextField mail;
    @FXML private TextArea description;
    @FXML private Text warning;
    
    @FXML
    public void initialize(){
        try {
            name.setText(InternshipsManagementSystem.activeUser.getUsername());
            mail.setText(InternshipsManagementSystem.activeUser.getMail());
            description.setText(InternshipsManagementSystem.activeUser.getDescription());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML 
    private void UpdateProfile() throws Exception{
        if(name.getText().isEmpty() || mail.getText().isEmpty()){
            warning.setText("Username and mail are mandatory");
            return;
        }
        ResultSet activeUser = Database.instance.checkUser(InternshipsManagementSystem.activeUser.getUsername());
        activeUser.next();
        
        InternshipsManagementSystem.activeUser.setDescription(description.getText());
        InternshipsManagementSystem.activeUser.setMail(mail.getText());
        InternshipsManagementSystem.activeUser.setUsername(name.getText());
        
        Database.instance.updateUser(activeUser.getInt("id"), InternshipsManagementSystem.activeUser);
        warning.setText("Profile updated");
    }
    
    @FXML 
    private void MainMenu() throws Exception{
        Stage stage = (Stage) name.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/MainMenuCompany.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
