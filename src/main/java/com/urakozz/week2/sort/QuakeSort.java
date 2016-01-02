package com.urakozz.week2.sort;

import com.urakozz.week1.EarthQuakeParser;
import com.urakozz.week1.QuakeEntry;

import java.util.ArrayList;

/**
 * Created by yury on 01/01/16.
 */
public class QuakeSort {
    public Integer getSmallestMagnitude(ArrayList<QuakeEntry> in, int from) {
        int minIdx = from;
        for (int i = from + 1; i < in.size(); i++) {
            if (in.get(i).getMagnitude() < in.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
        for (int i = 0; i < in.size(); i++) {
            int minIdx = getSmallestMagnitude(in, i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qMin = in.get(minIdx);
//            System.out.println(qMin.toString());
            in.set(i, qMin);
            in.set(minIdx, qi);
        }
//        System.out.println("done");

    }

    public int sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in) {
        int i;
        for (i= 0; i < in.size(); i++) {
            int minIdx = getSmallestMagnitude(in, i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qMin = in.get(minIdx);
            in.set(i, qMin);
            in.set(minIdx, qi);
            if(isSortedMag(in)){
                break;
            }
        }
        return i+1;

    }

    private boolean isSortedMag(ArrayList<QuakeEntry> in) {
        double min = in.get(0).getMagnitude();

        for (QuakeEntry qe : in) {
            if (qe.getMagnitude() >= min) {
                min = qe.getMagnitude();
            } else {
                return false;
            }
        }
        return true;

    }

    public Integer getLargestDepth(ArrayList<QuakeEntry> in, int from) {
        int minIdx = from;
        for (int i = from + 1; i < in.size(); i++) {
            if (in.get(i).getDepth() > in.get(minIdx).getDepth()) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    public void sortByDepth(ArrayList<QuakeEntry> in, int limit) {
        for (int i = 0; i < in.size(); i++) {
            if(i+1 == limit){
                break;
            }
            int minIdx = getLargestDepth(in, i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qMin = in.get(minIdx);
//            System.out.println(qMin.toString());
            in.set(i, qMin);
            in.set(minIdx, qi);
        }
//        System.out.println("done");
    }

    public void sortByDepth(ArrayList<QuakeEntry> in) {
        sortByDepth(in, Integer.MAX_VALUE);

    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for (QuakeEntry qe : list) {
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                    qe.getLocation().getLatitude(),
                    qe.getLocation().getLongitude(),
                    qe.getMagnitude(),
                    qe.getInfo());
        }

    }

    public static void main(String[] args) {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataWeekDec6sample2.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";

        ArrayList<QuakeEntry> list = parser.read(source);
        QuakeSort qs = new QuakeSort();
//        qs.sortByDepth(list, 70);
        int iter = qs.sortByMagnitudeWithCheck(list);
        for (QuakeEntry qe : list) {
            System.out.println(qe);

        }
        System.out.println(iter);
    }


}
