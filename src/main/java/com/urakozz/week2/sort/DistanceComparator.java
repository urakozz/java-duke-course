package com.urakozz.week2.sort;
/**
 * Write a description of class DistanceComparator here.
 * 
 */

import com.urakozz.week1.Location;
import com.urakozz.week1.QuakeEntry;

import java.util.*;

public class DistanceComparator implements Comparator<QuakeEntry> {
    Location fromWhere;
    
    public DistanceComparator(Location where) {
        fromWhere = where;
    }
    
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        double dist1 = q1.getLocation().distanceTo(fromWhere);
        double dist2 = q2. getLocation().distanceTo(fromWhere);
        return Double.compare(dist1, dist2);
    }
    
}
 