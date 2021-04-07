/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1758050_footballmanager;

import java.util.*;
/**
 *
 * @author msiyad
 */
public class match {
    private Date MatchDate;
    private FootballClub HomeTeam;
    private FootballClub AwayTeam;
    private int HomeTeamScore;
    private int AwayTeamScore;

    public Date getMatchDate() {
        return MatchDate;
    }
    
    public FootballClub getHomeTeam() {
        return HomeTeam;
    }
    
    public FootballClub getAwayTeam() {
        return AwayTeam;
    }
    
    public int getHomeTeamScore() {
        return HomeTeamScore;
    }
    
    public int getAwayTeamScore() {
        return AwayTeamScore;
    }
    
    public void setHomeTeam(FootballClub HomeTeam) {
        this.HomeTeam = HomeTeam;
    }
    
    public void setAwayTeam(FootballClub AwayTeam) {
        this.AwayTeam = AwayTeam;
    }
    
    public void setHomeTeamScore(int HomeTeamScore) {
        this.HomeTeamScore = HomeTeamScore;
    }
    
    public void setAwayTeamScore(int AwayTeamScore) {
        this.AwayTeamScore = AwayTeamScore;
    }
    
    public void setMatchDate(Date MatchDate){
        this.MatchDate = MatchDate;
    }
    
}
