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
public class UsersFXMLController {
    @FXML private GridPane grid;
    
    @FXML
    public void initialize(){
        ShowUsers();
    }
    
    public void ShowUsers(){
        grid.getChildren().remove(4, grid.getChildren().size());
        try{
            ResultSet users = Database.instance.getUsers();
            int rowIndex = 1;
            while(users.next()){
                grid.add(new Text(users.getString("user_type")), 0, rowIndex);
                grid.add(new Text(users.getString("name")), 1, rowIndex);
                grid.add(new Text(users.getString("mail")), 2, rowIndex);
                Button btn = new Button("Delete");
                btn.setFont(Font.font("Sitka Small", 20));
                btn.setId(users.getString("name"));
                btn.setOnAction(new EventHandler() {
                    @Override
                    public void handle(Event event) {
                        try {
                            Database.instance.deleteUser(btn.getId());
                            ShowUsers();
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
        Parent root = FXMLLoader.load(getClass().getResource("/internships/management/system/FXML/MainMenuDean.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
