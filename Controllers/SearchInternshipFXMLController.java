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
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author catal
 */
public class SearchInternshipFXMLController {
    @FXML private GridPane grid;
    @FXML private TextField searchBar;
    @FXML private Text warning;
    
    @FXML
    private void Search(){
        grid.getChildren().remove(5, grid.getChildren().size());
        try{
            ResultSet internships = Database.instance.getInternshipsByName(searchBar.getText());
            int rowIndex = 1;
            while(internships.next()){
                grid.add(new Text(internships.getString("name")), 0, rowIndex);
                grid.add(new Text(internships.getString("description")), 1, rowIndex);
                grid.add(new Text(internships.getDouble("salary") + " RON"), 2, rowIndex);
                grid.add(new Text(internships.getString("domain")), 3, rowIndex);
                Button btn = new Button("Apply");
                btn.setFont(Font.font("Sitka Small", 20));
                btn.setId(internships.getInt("id") + "");
                btn.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        try {
                            ResultSet application = Database.instance.checkApplication(InternshipsManagementSystem.activeUser.getUsername(), Integer.parseInt(btn.getId()));
                            if(application.next()){
                                warning.setText("You already applied to this internship");
                            } else {
                                Database.instance.addApplication(InternshipsManagementSystem.activeUser.getUsername(), Integer.parseInt(btn.getId()));
                                warning.setText("Application submitted");
                            }
                        } catch (Exception ex) {
                            System.out.println("invalid button id");
                        }
                    }
                });
                ResultSet publisher = Database.instance.getInternshipPublisher(internships.getInt("publisher_id"));
                publisher.next();
                grid.add(new Text(publisher.getString("name")), 4, rowIndex);
                grid.add(btn, 5, rowIndex);
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
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/MainMenuStudent.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
