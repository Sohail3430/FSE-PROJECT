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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author shahe
 */
public class MatchPredictionController implements Initializable {
    
    private Stage stage;
   private Scene scene;
   private Parent root;
    
    @FXML
    private ComboBox team1;
    @FXML
    private ComboBox team2;
    @FXML
    private TextField team1_name;
    @FXML
    private TextField team2_name;
    @FXML
    private TextField win_percentage_team1;
    @FXML
    private TextField win_percentage_team2;
    
    @FXML
    private void get_Prediction(){
        
        if (team1.getValue().toString().equals(team2.getValue().toString()) == false) {
            if (team1.getValue().toString() != null && team2.getValue().toString() != null) {
                double perc = PrimaryController.meriteam.matchPrediction(team1.getValue().toString(), team2.getValue().toString());
                double perc2 = 100 - perc;
                win_percentage_team1.setText(String.valueOf(perc));
                win_percentage_team2.setText(String.valueOf(perc2));

                team1_name.setText((String) team1.getValue());
                team2_name.setText((String) team2.getValue());
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("Please Select two different teams");
                    alert.show();
        }
    }
    
    @FXML
    private void home_btn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        team1.getItems().addAll(
        "pakistan","india","england","australia","sriLanka","newZealand","westIndies","zimbabwe","afghanistan","bangladesh","southAfrica","ireland"
        );
        
        team2.getItems().addAll(
        "pakistan","india","england","australia","sriLanka","newZealand","westIndies","zimbabwe","afghanistan","bangladesh","southAfrica","ireland"
        );
    
    }
    
}
