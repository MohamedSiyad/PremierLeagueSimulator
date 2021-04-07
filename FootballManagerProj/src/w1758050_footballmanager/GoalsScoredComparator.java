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
public class GoalsScoredComparator implements Comparator <FootballClub> {
    @Override
    public int compare(FootballClub t1, FootballClub t2){
    if(t1.getGoalsScored()> t2.getGoalsScored())
        return -1;
    else if (t2.getGoalsScored()> t1.getGoalsScored())
        return 1;
    else
        return 0;
}
}

