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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author catal
 */
public class CandidatesInternshipFXMLController {
    
    public static int internshipID = 1;
    @FXML private GridPane grid;
    
    @FXML
    public void initialize(){
        try{
            ResultSet candidates = Database.instance.getInternshipCandidates(internshipID);
            int rowIndex = 1;
            while(candidates.next()){
                grid.add(new Text(candidates.getString("name")), 0, rowIndex);
                grid.add(new Text(candidates.getString("specialization")), 1, rowIndex);
                grid.add(new Text(candidates.getString("group")), 2, rowIndex);
                grid.add(new Text(candidates.getString("description")), 3, rowIndex);
                RowConstraints row = new RowConstraints(40);
                grid.getRowConstraints().add(row);
                rowIndex++;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @FXML 
    private void Back() throws Exception{
        Stage stage = (Stage) grid.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/InternshipsCompany.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
