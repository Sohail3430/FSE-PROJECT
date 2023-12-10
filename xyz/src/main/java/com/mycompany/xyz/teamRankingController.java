/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xyz;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author shahe
 */
public class teamRankingController {
    
     private Stage stage;
   private Scene scene;
   private Parent root;
    
    @FXML
    private TextField rank_1;
    @FXML
    private TextField rank_2;
    @FXML
    private TextField rank_3;
    @FXML
    private TextField rank_4;
    @FXML
    private TextField rank_5;
    @FXML
    private TextField rank_6;
    @FXML
    private TextField rank_7;
    @FXML
    private TextField rank_8;
    @FXML
    private TextField rank_9;
    @FXML
    private TextField rank_10;
    @FXML
    private TextField rank_11;
    @FXML
    private TextField rank_12;
    
    @FXML
    private TextField p1;
    @FXML
    private TextField p2;
    @FXML
    private TextField p3;
    @FXML
    private TextField p4;
    @FXML
    private TextField p5;
    @FXML
    private TextField p6;
    @FXML
    private TextField p7;
    @FXML
    private TextField p8;
    @FXML
    private TextField p9;
    @FXML
    private TextField p10;
    @FXML
    private TextField p11;
    @FXML
    private TextField p12;
    
    
    
    
    @FXML
    private void get_ranking(){
        
        PrimaryController.meriteam.Sortcountry();
        rank_1.setText(PrimaryController.meriteam.G[0].name);
        rank_2.setText(PrimaryController.meriteam.G[1].name);
        rank_3.setText(PrimaryController.meriteam.G[2].name);
        rank_4.setText(PrimaryController.meriteam.G[3].name);
        rank_5.setText(PrimaryController.meriteam.G[4].name);
        rank_6.setText(PrimaryController.meriteam.G[5].name);
        rank_7.setText(PrimaryController.meriteam.G[6].name);
        rank_8.setText(PrimaryController.meriteam.G[7].name);
        rank_9.setText(PrimaryController.meriteam.G[8].name);
        rank_10.setText(PrimaryController.meriteam.G[9].name);
        rank_11.setText(PrimaryController.meriteam.G[10].name);
        rank_12.setText(PrimaryController.meriteam.G[11].name);
        
        p1.setText(String.valueOf(PrimaryController.meriteam.G[0].points));
        p2.setText(String.valueOf(PrimaryController.meriteam.G[1].points));
        p3.setText(String.valueOf(PrimaryController.meriteam.G[2].points));
        p4.setText(String.valueOf(PrimaryController.meriteam.G[3].points));
        p5.setText(String.valueOf(PrimaryController.meriteam.G[4].points));
        p6.setText(String.valueOf(PrimaryController.meriteam.G[5].points));
        p7.setText(String.valueOf(PrimaryController.meriteam.G[6].points));
        p8.setText(String.valueOf(PrimaryController.meriteam.G[7].points));
        p9.setText(String.valueOf(PrimaryController.meriteam.G[8].points));
        p10.setText(String.valueOf(PrimaryController.meriteam.G[9].points));
        p11.setText(String.valueOf(PrimaryController.meriteam.G[10].points));
        p12.setText(String.valueOf(PrimaryController.meriteam.G[11].points));
        
        
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
