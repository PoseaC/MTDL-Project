/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package internships.management.system.Controllers;

import internships.management.system.Database;
import internships.management.system.InternshipsManagementSystem;
import java.sql.ResultSet;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author catal
 */
public class InternshipsCompanyFXMLController {
    @FXML private GridPane grid;
    
    @FXML
    public void initialize(){
        try{
            ResultSet internships = Database.instance.getInternshipsByCompany(InternshipsManagementSystem.activeUser.getUsername());
            int rowIndex = 1;
            while(internships.next()){
                grid.add(new Text(internships.getString("name")), 0, rowIndex);
                grid.add(new Text(internships.getString("description")), 1, rowIndex);
                grid.add(new Text(internships.getDouble("salary") + " RON"), 2, rowIndex);
                grid.add(new Text(internships.getString("domain")), 3, rowIndex);
                Button btn = new Button("See Applicants");
                btn.setFont(Font.font("Sitka Small", 20));
                btn.setId(internships.getString("id"));
                btn.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        try {
                            CandidatesInternshipFXMLController.internshipID = Integer.parseInt(btn.getId());
                            Stage stage = (Stage) grid.getScene().getWindow();
                            Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/CandidatesInternship.fxml"));
                            Scene scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        } catch (Exception ex) {
                            System.out.println("invalid button id");
                        }
                    }
                });
                grid.add(btn, 3, rowIndex);
                RowConstraints row = new RowConstraints(40);
                grid.getRowConstraints().add(row);
                rowIndex++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML 
    private void MainMenu() throws Exception{
        Stage stage = (Stage) grid.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/MainMenuCompany.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
