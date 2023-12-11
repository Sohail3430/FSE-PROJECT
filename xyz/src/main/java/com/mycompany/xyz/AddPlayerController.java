/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xyz;

import static com.mycompany.xyz.PrimaryController.meriteam;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class AddPlayerController implements Initializable {
    
    private Stage stage;
   private Scene scene;
   private Parent root;
    
    @FXML
    private TextField player_name;
    
    @FXML
    private ChoiceBox<String> player_type;
    private String[] types = {"batsman","bowler","allrounder"};
    
    
    @FXML
    private TextField player_age;
    
    
    @FXML
    private void add_player(){
        
        meriteam.AddPlayer(player_type.getValue(), TeamsController.team_addplayer, player_name.getText(), Integer.parseInt(player_age.getText()), 220, 2345, 23.2, 56, 89.2, 23, 0, 2, 23.2, 0, 2894, 5, 2, 5.4, 5.6);
		try {
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	        	
	        	String url = "jdbc:ucanaccess://TEAMS.accdb";
	        	Connection con = DriverManager.getConnection(url);
	         
	        
	            
                PreparedStatement pst = con.prepareStatement("insert into "+TeamsController.team_addplayer+ "(Name,Age,Category,NoOfMatches,TotalRunsScored,battingBestScore,battingAverage,battingStrike,Centuries,halfCenturies,runsConceded,numberOfWicketsTaken,bowlingBest,bowlingAverage,Economy,bowlingStrikeRate,numberof5wickets) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	            
	            pst.setString(1, player_name.getText());
	            pst.setInt(2, Integer.parseInt(player_age.getText()));
	            pst.setString(3, player_type.getValue());
                    pst.setInt(4, 0);
	            pst.setInt(5, 0);
                    pst.setInt(6, 0);
	            pst.setDouble(7, 0);
	            pst.setDouble(8, 0);
	            pst.setInt(9, 0);
                    pst.setInt(10, 0);
                    pst.setInt(11, 0);
	            pst.setInt(12, 0);	            
                    pst.setInt(13, 0);
	            pst.setDouble(14, 0);
                    pst.setDouble(15, 0);
	            pst.setDouble(16, 0);
	            pst.setInt(17, 0);
	           
	            
	            pst.executeUpdate();
                    
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("PLAYER ADDED SUCCESSFULLY");
                    alert.show();
                    
                } catch(Exception e){
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("PLAYER ADD FAILED");
                    alert.show();
                }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player_type.getItems().addAll(types);
    
    }
    
    
    @FXML
    private void home_btn(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("primary.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    
}
