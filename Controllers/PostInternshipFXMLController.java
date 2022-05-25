/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package internships.management.system.Controllers;

import internships.management.system.Company;
import internships.management.system.Database;
import internships.management.system.Domain;
import internships.management.system.Internship;
import internships.management.system.InternshipsManagementSystem;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author catal
 */
public class PostInternshipFXMLController {
    @FXML private TextField name;
    @FXML private TextField salary;
    @FXML private TextArea description;
    @FXML private ToggleGroup domain;
    @FXML private Text warning;
    
    @FXML 
    private void PostInternship() throws Exception{
        RadioButton btn = (RadioButton)domain.getSelectedToggle();
        
        if (name.getText().isEmpty() || salary.getText().isEmpty() || description.getText().isEmpty()){
            warning.setText("All fields must be completed");
            return;
        }
        try {
            double d = Double.parseDouble(salary.getText());
        } catch (NumberFormatException nfe) {
            warning.setText("Salary must be a number");
            return;
        }
        
        Internship internship = new Internship(name.getText(), description.getText(), Double.parseDouble(salary.getText()), Domain.valueOf(btn.getText()), (Company)InternshipsManagementSystem.activeUser);
        
        Database.instance.insertInternship(internship);
        name.setText("");
        salary.setText("");
        description.setText("");
        warning.setText("Internship Published");
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
