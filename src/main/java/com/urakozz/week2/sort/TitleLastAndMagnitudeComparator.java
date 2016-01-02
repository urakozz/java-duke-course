package com.urakozz.week2.sort;

import com.urakozz.week1.QuakeEntry;

import java.util.Comparator;

/**
 * Created by yury on 01/01/16.
 */
public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry o1, QuakeEntry o2) {
        String i1 = o1.getInfo();
        String l1 = i1.substring(i1.lastIndexOf(" ")+1);

        String i2 = o2.getInfo();
        String l2 = i2.substring(i2.lastIndexOf(" ")+1);


        int titleRes = l1.compareTo(l2);
        if (titleRes != 0){
            return titleRes;
        }
        return Double.compare(o1.getMagnitude(), o2.getMagnitude());
    }
}
