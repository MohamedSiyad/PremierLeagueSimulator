/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1758050_footballmanager;
/**
 *
 * @author msiyad
 */
public class FootballClub extends SportsClub { //extends because the superclass is sports club
    private int matchesPlayed;
    private int winsAmount;
    private int drawsAmount;
    private int lossAmount;
    private int numberOfPoints;
    private int goalsScoredAmount;
    private int goalsConcededAmount;
    

    public int getMatchesPlayed(){
        return matchesPlayed;
    }
    
    public int getWinsAmount(){
        return winsAmount;
    }
    
    public int getDrawsAmount(){
        return drawsAmount;
    }
    
    public int getLossAmount(){
        return lossAmount;
    }
    
    public int getNumberOfPoints(){
        return numberOfPoints;
    }
    
    public int getGoalsScored(){
        return goalsScoredAmount;
    }
    
    public int getGoalsConceded(){
        return goalsConcededAmount;
    }
    
    public void setMatchesPlayed(int x){
        matchesPlayed=x;
    }
    
    public void setWinsAmount(int x){
        winsAmount=x;
    }
    
    public void setDrawsAmount(int x){
        drawsAmount=x;
    }
    
    public void setLossAmount(int x){
        lossAmount=x;
    }
    
    public void setNumberOfPoints(int x){
        numberOfPoints=x;
    }
    
    public void setGoalsScored(int x){
        goalsScoredAmount=x;
    }
    
    public void setGoalsConceded(int x){
        goalsConcededAmount=x;
    }
    
}
