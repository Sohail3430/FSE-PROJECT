package com.mycompany.xyz;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class PrimaryController {
    
    
   private Stage stage;
   private Scene scene;
   private Parent root;
   
   public static MyTeam meriteam;
	
	PreparedStatement pst;
	ResultSet rs;
	Connection con;
        
    public PrimaryController(){
        meriteam = new MyTeam();
               String name;
		int age;
		String type;
		int totalRuns;
		double battingAvg;
		int noOfMatches;
		double batStrike;
		int batBest;
		int halfCen;
		int cen;
		int noOfWickets;
		int runsConceded;
		double bowlingAverage;
		double bowlingStrike;
		int bowlingBest;
		int noOf5;
		double economy;
		
		String opponentT;
		boolean winn;
		
		try {
			// here we will add the 12 teams in the array

			
			meriteam.AddTeam(1, "pakistan");
			meriteam.AddTeam(2, "india");
			meriteam.AddTeam(3, "england");
			meriteam.AddTeam(4, "australia");
			meriteam.AddTeam(5, "newZealand");
			meriteam.AddTeam(6, "southAfrica");
			meriteam.AddTeam(7, "westIndies");
			meriteam.AddTeam(8, "afghanistan");
			meriteam.AddTeam(9, "sriLanka");
			meriteam.AddTeam(10, "zimbabwe");
			meriteam.AddTeam(11, "ireland");
			meriteam.AddTeam(12, "bangladesh");
			
			
			
        	//String ghi = "PROJECT";
        	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); //Loading Driver
        	
        	String url = "jdbc:ucanaccess://TEAMS.accdb"; //Establishing Connection
        	con = DriverManager.getConnection(url);
            
                // the code below is used to FETCH the data from the access database
			// the fetched data is saved in the LINKEDLIST
			
        	pst = con.prepareStatement("select * from pakistan");
        	rs = pst.executeQuery();
        	
        	
        	while(rs.next()) {
        		
        		name = rs.getString("Name");
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("Battingaverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingstrike");
        	    batBest = rs.getInt("battingbestscore");
        	    halfCen = rs.getInt("halfcenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberofwicketstaken");
        	    runsConceded = rs.getInt("runsconceded");
        	    bowlingAverage = rs.getDouble("bowlingaverage");
        	    bowlingStrike = rs.getDouble("bowlingstrikerate");
        	    bowlingBest = rs.getInt("bowlingbest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	  
        	   
        	    meriteam.AddPlayer(type, "pakistan", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	    
        	}
        	
        	
        	
        	 pst = con.prepareStatement("select * from india");
        	 rs = pst.executeQuery();
        	
        	while(rs.next()) {
        		
        		
        		name = rs.getString("Name");
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("BattingAverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingStrike");
        	    batBest = rs.getInt("battingBestScore");
        	    halfCen = rs.getInt("halfCenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberOfWicketsTaken");
        	    runsConceded = rs.getInt("runsConceded");
        	    bowlingAverage = rs.getDouble("bowlingAverage");
        	    bowlingStrike = rs.getDouble("bowlingStrikeRate");
        	    bowlingBest = rs.getInt("bowlingBest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	    
        	    
        	   
        	    meriteam.AddPlayer(type, "india", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	}
        	
        	
        	 pst = con.prepareStatement("select * from england");
        	 rs = pst.executeQuery();
        	
        	while(rs.next()) {
        	
        		
        		
        		name = rs.getString("Name");
        		
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("BattingAverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingStrike");
        	    batBest = rs.getInt("battingBestScore");
        	    halfCen = rs.getInt("halfCenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberOfWicketsTaken");
        	    runsConceded = rs.getInt("runsConceded");
        	    bowlingAverage = rs.getDouble("bowlingAverage");
        	    bowlingStrike = rs.getDouble("bowlingStrikeRate");
        	    bowlingBest = rs.getInt("bowlingBest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	    
        	   
        	    meriteam.AddPlayer(type, "england", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	    
        	}
        	
        	
        	 pst = con.prepareStatement("select * from australia");
        	 rs = pst.executeQuery();
        	
        	while(rs.next()) {
        		
        		
        		
        		name = rs.getString("Name");
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("BattingAverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingStrike");
        	    batBest = rs.getInt("battingBestScore");
        	    halfCen = rs.getInt("halfCenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberOfWicketsTaken");
        	    runsConceded = rs.getInt("runsConceded");
        	    bowlingAverage = rs.getDouble("bowlingAverage");
        	    bowlingStrike = rs.getDouble("bowlingStrikeRate");
        	    bowlingBest = rs.getInt("bowlingBest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	    
        	   
        	    meriteam.AddPlayer(type, "australia", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	}
        	
        	
        	 pst = con.prepareStatement("select * from newZealand");
        	 rs = pst.executeQuery();
        	
        	while(rs.next()) {
        		
        		
        		name = rs.getString("Name");
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("BattingAverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingStrike");
        	    batBest = rs.getInt("battingBestScore");
        	    halfCen = rs.getInt("halfCenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberOfWicketsTaken");
        	    runsConceded = rs.getInt("runsConceded");
        	    bowlingAverage = rs.getDouble("bowlingAverage");
        	    bowlingStrike = rs.getDouble("bowlingStrikeRate");
        	    bowlingBest = rs.getInt("bowlingBest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	    
        	    
        	   meriteam.AddPlayer(type, "newZealand", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	
        	}
        	
        	
        	 pst = con.prepareStatement("select * from westIndies");
        	 rs = pst.executeQuery();
        	
        	while(rs.next()) {
        		
        		name = rs.getString("Name");
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("BattingAverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingStrike");
        	    batBest = rs.getInt("battingBestScore");
        	    halfCen = rs.getInt("halfCenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberOfWicketsTaken");
        	    runsConceded = rs.getInt("runsConceded");
        	    bowlingAverage = rs.getDouble("bowlingAverage");
        	    bowlingStrike = rs.getDouble("bowlingStrikeRate");
        	    bowlingBest = rs.getInt("bowlingBest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	    
        	    
        	meriteam.AddPlayer(type, "westIndies", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	
        	}
        	
        	 pst = con.prepareStatement("select * from sriLanka");
        	 rs = pst.executeQuery();
        	
        	while(rs.next()) {
        		
        		name = rs.getString("Name");
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("BattingAverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingStrike");
        	    batBest = rs.getInt("battingBestScore");
        	    halfCen = rs.getInt("halfCenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberOfWicketsTaken");
        	    runsConceded = rs.getInt("runsConceded");
        	    bowlingAverage = rs.getDouble("bowlingAverage");
        	    bowlingStrike = rs.getDouble("bowlingStrikeRate");
        	    bowlingBest = rs.getInt("bowlingBest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	    
        	    
        	meriteam.AddPlayer(type, "sriLanka", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	
        	}
        	
        	 pst = con.prepareStatement("select * from zimbabwe");
        	 rs = pst.executeQuery();
        	
        	while(rs.next()) {
        		name = rs.getString("Name");
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("BattingAverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingStrike");
        	    batBest = rs.getInt("battingBestScore");
        	    halfCen = rs.getInt("halfCenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberOfWicketsTaken");
        	    runsConceded = rs.getInt("runsConceded");
        	    bowlingAverage = rs.getDouble("bowlingAverage");
        	    bowlingStrike = rs.getDouble("bowlingStrikeRate");
        	    bowlingBest = rs.getInt("bowlingBest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	    
        	    
        	meriteam.AddPlayer(type, "zimbabwe", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	
        	}
        	
        	 pst = con.prepareStatement("select * from bangladesh");
        	 rs = pst.executeQuery();
        	
        	while(rs.next()) {
        		name = rs.getString("Name");
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("BattingAverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingStrike");
        	    batBest = rs.getInt("battingBestScore");
        	    halfCen = rs.getInt("halfCenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberOfWicketsTaken");
        	    runsConceded = rs.getInt("runsConceded");
        	    bowlingAverage = rs.getDouble("bowlingAverage");
        	    bowlingStrike = rs.getDouble("bowlingStrikeRate");
        	    bowlingBest = rs.getInt("bowlingBest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	    
        	    
        	meriteam.AddPlayer(type, "bangladesh", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	
        	}
        	
        	
        	 pst = con.prepareStatement("select * from ireland");
        	 rs = pst.executeQuery();
        	
        	while(rs.next()) {
        	
        		name = rs.getString("Name");
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("BattingAverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingStrike");
        	    batBest = rs.getInt("battingBestScore");
        	    halfCen = rs.getInt("halfCenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberOfWicketsTaken");
        	    runsConceded = rs.getInt("runsConceded");
        	    bowlingAverage = rs.getDouble("bowlingAverage");
        	    bowlingStrike = rs.getDouble("bowlingStrikeRate");
        	    bowlingBest = rs.getInt("bowlingBest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	    
        	    
        	meriteam.AddPlayer(type, "ireland", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	
        	}
        	
        	 pst = con.prepareStatement("select * from southAfrica");
        	 rs = pst.executeQuery();
        	
        	while(rs.next()) {
        		name = rs.getString("Name");
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("BattingAverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingStrike");
        	    batBest = rs.getInt("battingBestScore");
        	    halfCen = rs.getInt("halfCenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberOfWicketsTaken");
        	    runsConceded = rs.getInt("runsConceded");
        	    bowlingAverage = rs.getDouble("bowlingAverage");
        	    bowlingStrike = rs.getDouble("bowlingStrikeRate");
        	    bowlingBest = rs.getInt("bowlingBest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	    
        	    
        	meriteam.AddPlayer(type, "southAfrica", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	
        	}
        	
        	 pst = con.prepareStatement("select * from afghanistan");
        	 rs = pst.executeQuery();
        	
        	while(rs.next()) {
        		name = rs.getString("Name");
        	    age = rs.getInt("Age");
        	    type = rs.getString("Category");
        	    totalRuns = rs.getInt("TotalRunsScored");
        	    battingAvg = rs.getDouble("BattingAverage");
        	    noOfMatches = rs.getInt("NoofMatches");
        	    batStrike = rs.getDouble("battingStrike");
        	    batBest = rs.getInt("battingBestScore");
        	    halfCen = rs.getInt("halfCenturies");
        	    cen = rs.getInt("centuries");
        	    noOfWickets = rs.getInt("numberOfWicketsTaken");
        	    runsConceded = rs.getInt("runsConceded");
        	    bowlingAverage = rs.getDouble("bowlingAverage");
        	    bowlingStrike = rs.getDouble("bowlingStrikeRate");
        	    bowlingBest = rs.getInt("bowlingBest");
        	    noOf5 = rs.getInt("numberof5wickets");
        	    economy = rs.getDouble("Economy");
        	    
        	    
        	meriteam.AddPlayer(type, "afghanistan", name, age, noOfMatches, totalRuns, battingAvg, batBest, batStrike, halfCen, cen, noOfWickets, bowlingAverage, 0, runsConceded, bowlingBest, noOf5, economy, bowlingStrike);
        	
        	}
           
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");//Loading Driver
        	
        	String url1 = "jdbc:ucanaccess://teamWins.accdb";//Establishing Connection
        	con = DriverManager.getConnection(url1);
           
        	
        	pst = con.prepareStatement("select * from pakistan");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		if (winn == true) {
        			meriteam.G[meriteam.getTeamIndex("pakistan")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("pakistan")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("pakistan")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("pakistan")].matchesLost+=1;
        		}
        		
        		meriteam.G[meriteam.getTeamIndex("pakistan")].teamhistory.insert(opponentT, winn);
        	}
        	
        	pst = con.prepareStatement("select * from india");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		if (winn == true) {
        			meriteam.G[meriteam.getTeamIndex("india")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("india")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("india")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("india")].matchesLost+=1;
        		}
        		
        		meriteam.G[meriteam.getTeamIndex("india")].teamhistory.insert(opponentT, winn);
        	}
        	
        	pst = con.prepareStatement("select * from england");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		if (winn == true) {
        			meriteam.G[meriteam.getTeamIndex("england")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("england")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("england")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("england")].matchesLost+=1;
        		}
        		
        		meriteam.G[meriteam.getTeamIndex("england")].teamhistory.insert(opponentT, winn);
        	}
        	
        	pst = con.prepareStatement("select * from australia");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		if (winn == true) {
        			meriteam.G[meriteam.getTeamIndex("australia")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("australia")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("australia")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("australia")].matchesLost+=1;
        		}
        		
        		meriteam.G[meriteam.getTeamIndex("australia")].teamhistory.insert(opponentT, winn);
        	}
        	
        	pst = con.prepareStatement("select * from newZealand");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		if (winn == true) {
        			meriteam.G[meriteam.getTeamIndex("newZealand")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("newZealand")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("newZealand")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("newZealand")].matchesLost+=1;
        		}
        		
        		meriteam.G[meriteam.getTeamIndex("newZealand")].teamhistory.insert(opponentT, winn);
        	}
        	
        	pst = con.prepareStatement("select * from sriLanka");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		if (winn == true) {
        			meriteam.G[meriteam.getTeamIndex("sriLanka")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("sriLanka")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("sriLanka")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("sriLanka")].matchesLost+=1;
        		}
        		
        		meriteam.G[meriteam.getTeamIndex("sriLanka")].teamhistory.insert(opponentT, winn);
        	}
        	
        	pst = con.prepareStatement("select * from afghanistan");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		if (winn == true) {
        			meriteam.G[meriteam.getTeamIndex("afghanistan")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("afghanistan")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("afghanistan")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("afghanistan")].matchesLost+=1;
        		}
        		
        		meriteam.G[meriteam.getTeamIndex("afghanistan")].teamhistory.insert(opponentT, winn);
        	}
        	
        	pst = con.prepareStatement("select * from zimbabwe");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		if (winn == true) {
        			meriteam.G[meriteam.getTeamIndex("zimbabwe")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("zimbabwe")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("zimbabwe")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("zimbabwe")].matchesLost+=1;
        		}
        		
        		meriteam.G[meriteam.getTeamIndex("zimbabwe")].teamhistory.insert(opponentT, winn);
        	}
        	
        	pst = con.prepareStatement("select * from bangladesh");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		if (winn == true) {
        		        meriteam.G[meriteam.getTeamIndex("bangladesh")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("bangladesh")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("bangladesh")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("bangladesh")].matchesLost+=1;
        		}
        		
        		meriteam.G[meriteam.getTeamIndex("bangladesh")].teamhistory.insert(opponentT, winn);
        	}
        	
        	pst = con.prepareStatement("select * from ireland");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		
        		if (winn == true) {
        			meriteam.G[meriteam.getTeamIndex("ireland")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("ireland")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("ireland")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("ireland")].matchesLost+=1;
        		}
        		
        		
        		meriteam.G[meriteam.getTeamIndex("ireland")].teamhistory.insert(opponentT, winn);
        	}
        	
        	pst = con.prepareStatement("select * from westIndies");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		if (winn == true) {
        			meriteam.G[meriteam.getTeamIndex("westIndies")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("westIndies")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("westIndies")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("westIndies")].matchesLost+=1;
        		}
        		
        		meriteam.G[meriteam.getTeamIndex("westIndies")].teamhistory.insert(opponentT, winn);
        	}
        	
        	pst = con.prepareStatement("select * from southAfrica");
        	rs = pst.executeQuery();
        	
        	while (rs.next()) {
        		opponentT = rs.getString("opponent");
        		winn = rs.getBoolean("wins");
        		
        		if (winn == true) {
        			meriteam.G[meriteam.getTeamIndex("southAfrica")].points+=50;
        			meriteam.G[meriteam.getTeamIndex("southAfrica")].matchesWon+=1;
        		}
        		else {
        			meriteam.G[meriteam.getTeamIndex("southAfrica")].points+=10;
        			meriteam.G[meriteam.getTeamIndex("southAfrica")].matchesLost+=1;
        		}
        		
        		meriteam.G[meriteam.getTeamIndex("southAfrica")].teamhistory.insert(opponentT, winn);
        	}
        }
		
        catch(Exception e){
        	
        	System.out.println("error "+ e);
        	
        }
    }
   

    @FXML
    private void teamScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Teams.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void addMatchScreen(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("addmatch1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void match_prediction(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("matchPrediction.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    private void team_rankings(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("teamRanking.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
}
