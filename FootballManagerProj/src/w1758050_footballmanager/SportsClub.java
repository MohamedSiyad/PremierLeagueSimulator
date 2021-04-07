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
public class SportsClub {
    private String name; //this will be the name of the club
    private String statistics; //wins losses points goals scored and conceded
    
    @Override
    public boolean equals(Object o) {
        return this.name.equals(((SportsClub)o).name);
    }
    
    
    public String getName() {
        return name;
    }
    
    
    public String getStatistics() {
        return statistics;
    }
    
    
    public void setName(String set) {
        this.name = set;
    } 
    
    public void setStatistics(String set) {
        this.statistics = set;
    }   
    
    
}
