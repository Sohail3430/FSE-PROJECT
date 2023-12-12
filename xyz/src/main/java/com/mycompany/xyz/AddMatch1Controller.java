/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xyz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;


public class AddMatch1Controller implements Initializable {
    
    
    @FXML
    private ComboBox winning_team;
    @FXML
    private ComboBox losing_team;
    
    public static String team1;
    public static String team2;
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    
    @FXML
    private void add_match(ActionEvent event) throws IOException{
        
        
        team1 = winning_team.getValue().toString();
        team2 = losing_team.getValue().toString();
        
        if ((team1 != null && team2 != null) && (team1.equals(team2) == false)) {

            PrimaryController.meriteam.G[PrimaryController.meriteam.getTeamIndex(team1)].points += 100;
            PrimaryController.meriteam.G[PrimaryController.meriteam.getTeamIndex(team2)].points += 20;

            root = FXMLLoader.load(getClass().getResource("addmatch2.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("Please select two DIFFERENT teams");
                    alert.show();

        }
    }
    
    
   
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        winning_team.getItems().addAll(
        "pakistan","india","england","australia","sriLanka","newZealand","westIndies","zimbabwe","afghanistan","bangladesh","southAfrica","ireland"
        );
        
        losing_team.getItems().addAll(
        "pakistan","india","england","australia","sriLanka","newZealand","westIndies","zimbabwe","afghanistan","bangladesh","southAfrica","ireland"
        );
    
    }
    
}

