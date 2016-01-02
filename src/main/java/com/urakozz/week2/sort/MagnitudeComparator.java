package com.urakozz.week2.sort;
/**
 * Write a description of class MagnitudeComparator here.
 *
 */

import com.urakozz.week1.QuakeEntry;

import java.util.*;

public class MagnitudeComparator implements Comparator<QuakeEntry>
{

    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        return Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
    }
}
