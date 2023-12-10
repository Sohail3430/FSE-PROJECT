/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.xyz;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author shahe
 */
public class TeamsController {
    
      @FXML
      private Button pakistan_btn;
      @FXML
      private Button india_btn;
      @FXML
      private Button england_btn;
      @FXML
      private Button australia_btn;
      @FXML
      private Button srilanka_btn;
      @FXML
      private Button southafrica_btn;
      @FXML
      private Button zimbabwe_btn;
      @FXML
      private Button newzealand_btn;
      @FXML
      private Button bangladesh_btn;
      @FXML
      private Button westindies_btn;
      @FXML
      private Button ireland_btn;
      @FXML
      private Button afghanistan_btn;
      
      
      
    
      public static String team_addplayer;
      private Stage stage;
      private Scene scene;
      private Parent root;

   @FXML
   private void teamSelect(ActionEvent event) throws IOException {
        
        
        if(((Button)event.getSource()) == pakistan_btn){
            team_addplayer = "pakistan";
        }
        else if (((Button)event.getSource()) == india_btn){
            team_addplayer = "india";
        }
        else if (((Button)event.getSource()) == england_btn){
            team_addplayer = "england";
        }
        else if (((Button)event.getSource()) == australia_btn){
            team_addplayer = "australia";
        }
        else if (((Button)event.getSource()) == afghanistan_btn){
            team_addplayer = "afghanistan";
        }
        else if (((Button)event.getSource()) == srilanka_btn){
            team_addplayer = "sriLanka";
        }
        else if (((Button)event.getSource()) == southafrica_btn){
            team_addplayer = "southAfrica";
        }
        else if (((Button)event.getSource()) == zimbabwe_btn){
            team_addplayer = "zimbabwe";
        }
        else if (((Button)event.getSource()) == newzealand_btn){
            team_addplayer = "newZealand";
        }
        else if (((Button)event.getSource()) == bangladesh_btn){
            team_addplayer = "bangladesh";
        }
        else if (((Button)event.getSource()) == westindies_btn){
            team_addplayer = "westIndies";
        }
        else if (((Button)event.getSource()) == ireland_btn){
            team_addplayer = "ireland";
        }
        
        root = FXMLLoader.load(getClass().getResource("AddPlayer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
   }
    
}
