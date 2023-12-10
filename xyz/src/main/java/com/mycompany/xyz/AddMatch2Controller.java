/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xyz;

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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author shahe
 */
public class AddMatch2Controller {
    
    private Stage stage;
   private Scene scene;
   private Parent root;
    
    @FXML
    private ListView winning_list;
    @FXML
    private ListView losing_list;
    @FXML
    private TextField runs_scored;
    @FXML
    private TextField balls_taken;
    @FXML
    private TextField wickets_taken;
    @FXML
    private TextField runs_conceded;
    @FXML
    private TextField player_name;
    
    
    @FXML
    private void winning_list_item_selected(){
        
            player_name.setText(winning_list.getSelectionModel().getSelectedItem().toString());
            losing_list.getSelectionModel().clearSelection();
            runs_scored.setEditable(true);
            balls_taken.setEditable(true);
            wickets_taken.setEditable(true);
            runs_conceded.setEditable(true);
  
        
       
    }
    
    @FXML
    private void losing_list_item_selected(){
        
        
            player_name.setText(losing_list.getSelectionModel().getSelectedItem().toString());
            winning_list.getSelectionModel().clearSelection();
            runs_scored.setEditable(true);
            balls_taken.setEditable(true);
            wickets_taken.setEditable(true);
            runs_conceded.setEditable(true);
        
    }
    
    
    @FXML
    private void edit_player() {
        
        int runs_bat = Integer.parseInt(runs_scored.getText());
        int balls_bat = Integer.parseInt(balls_taken.getText());
        int wickets = Integer.parseInt(wickets_taken.getText());
        int runs_ball = Integer.parseInt(runs_conceded.getText());
 

        if ((String) winning_list.getSelectionModel().getSelectedItem()!=null && (String) losing_list.getSelectionModel().getSelectedItem() == null) {
           
           
            playersNode A = PrimaryController.meriteam.findplayer(AddMatch1Controller.team1, winning_list.getSelectionModel().getSelectedItem().toString());

            int best = 0;

            if (A.player.batBest < runs_bat) {
                best = runs_bat;
            } else {
                best = A.player.batBest;
            }

            int i = A.player.batRuns + runs_bat;
            int m = A.player.matches + 1;
            int z = i / m;
            int n = A.player.noOfWickets + wickets;
            int o = A.player.runs + runs_ball;

            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver

                String url = "jdbc:ucanaccess://TEAMS.accdb";//Establishing Connection
                Connection con = DriverManager.getConnection(url);
                System.out.println("Connected Successfully");
                //,No of Matches,batting strike,batting best score,half centuries,centuries,number of wickets taken,runs conceded,bowling average,bowling strike rate,bowling best,number of 5 wickets,Economy
                PreparedStatement pst = con.prepareStatement("Update " + AddMatch1Controller.team1 + " SET TotalRunsScored=?,numberofwicketstaken=?,battingBestScore=?,BattingAverage=?,NoofMatches=?,runsconceded=? WHERE Name=?");

                pst.setInt(1, i);
                pst.setInt(2, n);
                pst.setInt(3, best);
                pst.setInt(4, z);
                pst.setInt(5, m);
                pst.setInt(6, o);

                pst.setString(7, A.player.name);

                pst.executeUpdate();
                
                Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setContentText("PLAYER UPDATED SUCCESSFULLY");
                    alert.show();

            } catch (Exception oj) {
                oj.printStackTrace();
            }
        }
        
        else if ((String) winning_list.getSelectionModel().getSelectedItem()==null && (String) losing_list.getSelectionModel().getSelectedItem() != null) {
            
       
            playersNode B = PrimaryController.meriteam.findplayer(AddMatch1Controller.team2, losing_list.getSelectionModel().getSelectedItem().toString());

            int best = 0;

            if (B.player.batBest < runs_bat) {
                best = runs_bat;
            } else {
                best = B.player.batBest;
            }

            int i = B.player.batRuns + runs_bat;
            int m = B.player.matches + 1;
            int z = i / m;
            int n = B.player.noOfWickets + wickets;
            int o = B.player.runs + runs_ball;

            try {
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver

                String url = "jdbc:ucanaccess://TEAMS.accdb";//Establishing Connection
                Connection con = DriverManager.getConnection(url);
                System.out.println("Connected Successfully");
                //,No of Matches,batting strike,batting best score,half centuries,centuries,number of wickets taken,runs conceded,bowling average,bowling strike rate,bowling best,number of 5 wickets,Economy
                PreparedStatement pst = con.prepareStatement("Update " + AddMatch1Controller.team2 + " SET TotalRunsScored=?,numberofwicketstaken=?,battingBestScore=?,BattingAverage=?,NoofMatches=?,runsconceded=? WHERE Name=?");

                pst.setInt(1, i);
                pst.setInt(2, n);
                pst.setInt(3, best);
                pst.setInt(4, z);
                pst.setInt(5, m);
                pst.setInt(6, o);

                pst.setString(7, B.player.name);

                pst.executeUpdate();

            } catch (Exception oj) {
                oj.printStackTrace();
            }
            
        }
        
    }
    
    
    @FXML
    private void view_players() {
        int team1_index = PrimaryController.meriteam.getTeamIndex(AddMatch1Controller.team1);
        int team2_index = PrimaryController.meriteam.getTeamIndex(AddMatch1Controller.team2);
        
        System.out.println("team1 index "+team1_index);
        System.out.println("team2 index "+team2_index);
        
        playersNode team1_bat = PrimaryController.meriteam.G[team1_index].batsman.head;
        playersNode team2_bat = PrimaryController.meriteam.G[team2_index].batsman.head;
        
        playersNode team1_bowl = PrimaryController.meriteam.G[team1_index].bowler.head;
        playersNode team2_bowl = PrimaryController.meriteam.G[team2_index].bowler.head;
        
        playersNode team1_all = PrimaryController.meriteam.G[team1_index].allRounder.head;
        playersNode team2_all = PrimaryController.meriteam.G[team2_index].allRounder.head;
        
        while(team1_bat != null){
            winning_list.getItems().add(team1_bat.player.name);
            team1_bat = team1_bat.next;
        }
        
        while(team2_bat != null){

            losing_list.getItems().add(team2_bat.player.name);
            team2_bat = team2_bat.next;
        }
        
        while(team1_bowl != null){

            winning_list.getItems().add(team1_bowl.player.name);
            team1_bowl = team1_bowl.next;
        }
        
        while(team2_bowl != null){

            losing_list.getItems().add(team2_bowl.player.name);
            team2_bowl = team2_bowl.next;
        }
        
        while(team1_all != null){

            winning_list.getItems().add(team1_all.player.name);
            team1_all = team1_all.next;
        }
        
        while(team2_all != null){
          
            losing_list.getItems().add(team2_all.player.name);
            team2_all = team2_all.next;
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
}
