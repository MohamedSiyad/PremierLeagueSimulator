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
public class MostWinsComparator implements Comparator <FootballClub>  {
        @Override
    public int compare(FootballClub t1, FootballClub t2){
    if(t1.getWinsAmount()> t2.getWinsAmount())
        return -1;
    else if (t2.getWinsAmount()> t1.getWinsAmount())
        return 1;
    else
        return 0;
}
    
}
