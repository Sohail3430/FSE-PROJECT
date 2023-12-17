/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.xyz;


// PlayersNode class which is the node of the PLAYERS LinkedList
// it has player object and a pointer to next node

class playersNode {

    player player;
    playersNode next;
  

    public playersNode(player p) {
        player = p;
    }
}




// teamHistoryNode is the  node of the HistoryLinkedList where history of matches is stored

class TeamHistoryNode{
	
	String opponent;
	boolean win;
	
	TeamHistoryNode next;
	
	public TeamHistoryNode(String against, boolean W) {
		opponent = against;
		win = W;
	}
}



// TeamHistoryList is the LinkedList Class where we have created some basic methods to add and print the contents of the LinkedList

class TeamHistoryList {
	TeamHistoryNode head;
	 
	public void insert (String opponent, boolean W) {
	
	   TeamHistoryNode temp = new TeamHistoryNode(opponent,W);
 
       
         if(head == null)
         {
           head = temp;
         }
         
         else
         {
             while(temp.next != null)
             temp = temp.next;
             
             temp.next = temp;
         }
	
    }
	
	public String toString()
    {
        String str = "";
        TeamHistoryNode temp = head;
        while (temp != null)
        {
            str += "opponent : " + temp.opponent + ", Win : " + temp.win;
            temp = temp.next;
        }
        return str;
    }

}



// This is the player Class which has all the details of a player 

class player {

    String type;
    String team;
    String name;
    int age;
    int matches;

    int batRuns;
    double batAverage;
    int batBest;
    double batStrike;
    int halfCentury;
    int century;

    int noOfWickets;
    double bowlAverage;
    int noOfBalls;
    int runs;
    int bowlBest;
    int noOf5Wickets;
    double economy;
    double bowlStrike;

    public player(String type, String team, String name, int age, int matches, int batRuns, double batAverage, int batBest, double batStrike, int halfCentury, int century, int noOfWickets, double bowlAverage, int noOfBalls, int runs, int bowlBest, int noOf5Wickets, double economy, double bowlStrike) {
        this.type = type;
        this.team = team;
        this.name = name;
        this.age = age;
        this.matches = matches;
        this.batRuns = batRuns;
        this.batAverage = batAverage;
        this.batBest = batBest;
        this.batStrike = batStrike;
        this.halfCentury = halfCentury;
        this.century = century;

        this.noOfWickets = noOfWickets;
        this.bowlAverage = bowlAverage;
        this.noOfBalls = noOfBalls;
        this.runs = runs;
        this.bowlBest = bowlBest;
        this.noOf5Wickets = noOf5Wickets;
        this.economy = economy;
        this.bowlStrike = bowlStrike;

    }
}



class playersList {

    playersNode head;
    //historyList H = new historyList();

    public void insert(String type, String team, String name, int age, int matches, int batRuns, double batAverage, int batBest, double batStrike, int halfCentury, int century, int noOfWickets, double bowlAverage, int noOfBalls, int runs, int bowlBest, int noOf5Wickets, double economy, double bowlStrike) {
        player p = new player(type, team, name, age, matches, batRuns, batAverage, batBest, batStrike, halfCentury, century, noOfWickets, bowlAverage, noOfBalls, runs, bowlBest, noOf5Wickets, economy, bowlStrike);
        playersNode n = new playersNode(p);
        playersNode temp = head, prev = head;

        if (head == null) {
            head = n;
        } 
        else if (n.player.type.equals("batsman") || n.player.type.equals("allrounder")) {
            while (temp.next != null && temp.player.batAverage > batAverage) {
            	
                prev = temp;
                temp = temp.next;
            }
            if (temp == head && batAverage >= temp.player.batAverage) {
                n.next = head;
                head = n;
            } else if (temp.next == null && batAverage < temp.player.batAverage) {
                temp.next = n;
            } else {
                n.next = temp;
                prev.next = n;
            }
        } else if (n.player.type.equals("bowler")) {
        	
            while (temp.next != null && temp.player.bowlAverage < bowlAverage) {
            	
                prev = temp;
                temp = temp.next;
            }
           
            if (temp == head && bowlAverage <= temp.player.bowlAverage) {
                n.next = temp;
                head = n;
            } else if (temp.next == null && bowlAverage > temp.player.bowlAverage) {
                temp.next = n;
            } else {
                n.next = temp;
                prev.next = n;
            }
        }
    }
    
    
   

    public String toString() {
        String str = "";
        playersNode temp = head;
        int count = 0;
        while (temp != null && count < 6) {
            str += temp.player.name + ", " + temp.player.batAverage + "\n";
            count++;
            temp = temp.next;
        }
        return str;
    }
    
    
    public playersNode Find(String name)
    {
        playersNode temp = head;
        while(temp != null)
        {
            if (temp.player.name.equals(name))
                return temp;
            temp = temp.next;
        }
        System.out.println("Player Not Found!");
        return null;
    }
}



// this is the team class which is the array in our case
// the fields mentioned here are the data present on each element of the array.
	
class team {

    String name;
    int rank;
    int points;
    double rating;
    int matchesWon;
    int matchesLost;

    playersList batsman = new playersList();
    playersList bowler = new playersList();
    playersList allRounder = new playersList();
    
    TeamHistoryList teamhistory = new TeamHistoryList();

    public team(String name, int rank, int points, double r, int matchesWon, int matchesLost) {
        this.name = name;
        this.rank = rank;
        this.points = points;
        this.rating = r;
        this.matchesWon = matchesWon;
        this.matchesLost = matchesLost;
    }

    public void addPlayer(String type, String team, String name, int age, int matches, int batRuns, double batAverage, int batBest, double batStrike, int halfCentury, int century, int noOfWickets, double bowlAverage, int noOfBalls, int runs, int bowlBest, int noOf5Wickets, double economy, double bowlStrike) {
        if (type.equals("batsman")) {
            batsman.insert(type, team, name, age, matches, batRuns, batAverage, batBest, batStrike, halfCentury, century, noOfWickets, bowlAverage, noOfBalls, runs, bowlBest, noOf5Wickets, economy, bowlStrike);
        } else if (type.equals("bowler")) {
            bowler.insert(type, team, name, age, matches, batRuns, batAverage, batBest, batStrike, halfCentury, century, noOfWickets, bowlAverage, noOfBalls, runs, bowlBest, noOf5Wickets, economy, bowlStrike);
        } else if (type.equals("allrounder")) {
            allRounder.insert(type, team, name, age, matches, batRuns, batAverage, batBest, batStrike, halfCentury, century, noOfWickets, bowlAverage, noOfBalls, runs, bowlBest, noOf5Wickets, economy, bowlStrike);
        } else {
            System.out.println("Error! Wrong type given as input!");
        }
    }
}




// this is the main class of the project which holds all the methods of this project	

class MyTeam
{

 team[] G;
 
 int count;
 
 //historyList x = new historyList();

 
 // here we created an array of size 12 which is the number of teams in our database.

public MyTeam() {
	
	 G = new team[12];
     
	 count=0;

}

// this method is used to add a team by first checking whether it already exists or not.
	
public void AddTeam(int rank, String name) {          //constant
	
    if (count < G.length && duplicateCheck(name) == true) {
        System.out.println("Duplicate Detected! Team not Added");
    } else if (count < G.length && duplicateCheck(name) == false) {
        count++;
        G[rank - 1] = new team (name, rank,0,0,0,0);
    } else {
        System.out.println("Teams Full");
    }
}


// this method is used to sort the teams in the array based on their points.
	
public void Sortcountry() {              // n^2
	
	team temp;
	for (int i = 0; i < 12; i++) 
    {
        for (int j = i + 1 ; j < 12; j++) { 
            if (G[i].points < G[j].points) 
            {
                temp = G[i];
                G[i] = G[j];
                G[j] = temp;
            }
        }
    }
}

// this method is used to add a player in the linkedList by first checking the team to which it is assigned to.	

public void AddPlayer(String type, String team, String name, int age, int matches, int batRuns, double batAverage, int batBest, double batStrike, int halfCentury, int century, int noOfWickets, double bowlAverage, int noOfBalls, int runs, int bowlBest, int noOf5Wickets, double economy, double bowlStrike) {
    int i = getTeamIndex(team);             // n
    

    if (G[i].name.equals(team)) {
        G[i].addPlayer(type, team, name, age, matches, batRuns, batAverage, batBest, batStrike, halfCentury, century, noOfWickets, bowlAverage, noOfBalls, runs, bowlBest, noOf5Wickets, economy, bowlStrike);
    } else {
        System.out.println("Team not Found");
    }
}


	
public boolean duplicateCheck(String name) {    //n
    for (int i = 0; i < count; i++) {
        if (G[i].name.equals(name)) {
            return true;
        }
    }
    return false;
}

	
// this method is used to get the index of the array on which a specific team is present
	
public int getTeamIndex(String team) {      //n
    int i;
    for (i = 0; i < count; i++) {
        if (G[i].name.equals(team)) {
            break;
        }
    }
    return i;
}

// this method is used to find a player in the LinkedList and we have 2 parameters here which is the team and the player
	// it returns a playersNode

public playersNode findplayer (String team, String name) {     //n
	
	int i = getTeamIndex(team);
	
	playersNode temp = G[i].batsman.head;
	
	while(temp.next!=null) {
		System.out.println(temp.player.name);
		if(temp.player.name.equals(name)) {
			return temp;
		}
		temp = temp.next;
	}
	
	temp = G[i].bowler.head;
	
	while(temp.next!=null) {
		if(temp.player.name.equals(name)) {
			return temp;
		}
		temp = temp.next;
	}

	
	temp = G[i].allRounder.head;
	
	while(temp.next!=null) {
		if(temp.player.name.equals(name)) {
			return temp;
		}
		temp = temp.next;
	}
	if(temp.player.name.equals(name)) {
		return temp;
	}
	
	return null;
	
}






public playersNode find(String team,String type,String name)   //n

{
	
	int i = getTeamIndex(team);
	
	if(type.equals("batsman")) {
    playersNode temp = G[i].batsman.head;
    while(temp != null)
    {
        if (temp.player.name.equals(name))
            return temp;
        temp = temp.next;
    }
	}
	else if (type.contentEquals("bowler")){
		playersNode temp = G[i].bowler.head;
		while(temp!=null) {
			if (temp.player.name.equals(name))
	            return temp;
	        temp = temp.next;
		}
	}
	else if (type.equals("allrounder")) {
		playersNode temp = G[i].allRounder.head;
		while(temp!=null) {
			if (temp.player.name.equals(name))
	            return temp;
	        temp = temp.next;
		}
	}
	else
    System.out.println("Player Not Found!");
    return null;
}


// this method is part of the match prediction feature
	// here we will compare the top three batsmen of a team and calculate a score based on their average
	// this score will be used later in the project in the matchprediction method


public double batsmanAnalysis(String team) {  //n
	
	double b1 = 0;
	double b2 = 0;
	double b3 = 0;
	
	double sumB1=0;
	int i;
	
	i = getTeamIndex(team);
	

      playersNode temp = G[i].batsman.head;
      
      b1 = temp.player.batAverage;
      b2 = temp.next.player.batAverage;
      b3 = temp.next.next.player.batAverage;
      
	System.out.println("batsman    " +b1 + " "+ b2+ " "+b3);
      
	sumB1= (b1+b2+b3)/3;
	
	return sumB1;
	
	
	
}

// this method compares the bowling Average of teams and calculate a score based on that
	
public double bowlerAnalysis(String country) {   //n

	double a1=1000;
	double a2=1000;
	double a3=1000;
	
	int i;
	i = getTeamIndex(country);
	      playersNode temp1 = G[i].bowler.head;
	            
	      a1 = temp1.player.bowlAverage;
	      a2 = temp1.next.player.bowlAverage;
	      a3 = temp1.next.next.player.bowlAverage;
		
	
	System.out.println("bowler  "+a1+" "+a2+" "+a3);
	double sum = (a1+a2+a3)/3;
	
	return sum;
	
}

// this method is a simple score calculated for the match prediction for the home away factor

public double homeAway(String team) {  //constant
	
	double team1=0;
	
	
	team1= (0.6)*100;
	
	
	return team1;
	
}

	// this method returns the ranking of the team

public double ranking(String team) {    //n
	
	int r=0;
	for(int i=0;i<10;i++) {
		if(G[i].name.equals(team)) {
			r = G[i].rank;
			break;
		}
	}

	return r;
}



// this is the matchprediction method
	// here we will compare the statistics of both teams with each other 
	// and calculate a percentage based on that.

public double matchPrediction(String country1, String country2) { //n
	
        int i,k;
        
        i = getTeamIndex(country1);
        
        k = getTeamIndex(country2);
	
			
			
					double rank1 = ranking(country1);
					double rank2 = ranking(country2);
					
					double bowler1 = bowlerAnalysis(country1);
					double batsman1 = batsmanAnalysis(country1);
					
					double bowler2 = bowlerAnalysis(country2);
					double batsman2 = batsmanAnalysis(country2);
					
					double score1 = homeAway(country1);  
					double score2 = 100 - score1;  
					
					
				    
				    
				    double bat1=0;
				    double bat2=0;
				    double bowl1 = 0;
				    double bowl2 = 0;
					
					if (rank1 > rank2) {                //rank difference
						score1 = score1 + (int) (rank1 - rank2)*5/3;
						score2 = score2 + (int) (rank1 - rank2)*5;
					}
					else {
						score2 = score2 +(int) (rank2 - rank1)*5/3;
						score1 = score1 +  (int) (rank2 - rank1)*5;
					}
					 
						
						 if (batsman1 > batsman2) {            //saves the difference between the sum of batting average of 2 team
						     bat1 = batsman1 - batsman2;
						     score1 = score1 + (bat1*60);
						     score2 = score2 + (bat1*20);
						 }
						 
						 else {
						    	bat2 = batsman2 - batsman1;
						    	score1 = score1 + (bat2*20);
							     score2 = score2 + (bat2*60);
						 }
				
						 
						 if (bowler1 > bowler2) { 
				
							 bowl1 = bowler1 - bowler2;
							 score1 = score1 + (bowl1*20);
						     score2 = score2 + (bowl1*60);
						 }
						 else {
							
							 
							 bowl2 = bowler2 - bowler1;
							
							 score1 = score1 + (bowl2*60);
						     score2 = score2 + (bowl2*20);
						 }
					
						           double perc = ((score1)/(score1+score2))*100;
						           
						 
						         
						           
						           System.out.println(perc);
						           
						      return perc;     
						          
						           
					    }
			
    
    }



















