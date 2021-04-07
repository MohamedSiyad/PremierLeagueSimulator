/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w1758050_footballmanager;

import java.util.Comparator;

/**
 *
 * @author msiyad
 */
public class TableComparator implements Comparator <FootballClub> {
    
    @Override
    public int compare(FootballClub t1, FootballClub t2){
    if(t1.getNumberOfPoints()> t2.getNumberOfPoints())
        return -1;
    else if (t2.getNumberOfPoints()> t1.getNumberOfPoints())
        return 1;
    else {
        int goalDifferenceT1 = t1.getGoalsScored()-t1.getGoalsConceded();
        int goalDifferenceT2 = t2.getGoalsScored()-t2.getGoalsConceded();
        if(goalDifferenceT1> goalDifferenceT2)
            return -1;
        else if(goalDifferenceT2 < goalDifferenceT2)
            return 1;
        else
            return 0;
    }

} 
}
