import com.urakozz.week1.EarthQuakeParser;
import com.urakozz.week1.Location;
import com.urakozz.week1.QuakeEntry;
import com.urakozz.week2.sort.DifferentSorters;
import com.urakozz.week2.sort.QuakeSort;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by yury on 25/12/15.
 */
public class Main {
    public static void main(String[] args) {

        week2();
    }

    private static void week1() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";

        ArrayList<QuakeEntry> list = parser.read(source);
        Collections.sort(list, Collections.reverseOrder());

        int i = 0;

        Location l = new Location(55.7308, 9.1153);

        for (QuakeEntry qe : list) {
            if (qe.getLocation().distanceTo(l) <= 3000000 && qe.getInfo().contains("e") && qe.getMagnitude() > 0 && qe.getMagnitude() < 5) {
                i++;
                System.out.println(qe.toString());
            }
        }
        System.out.println(i);
    }

    private static void week2() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/earthQuakeDataDec6sample2.atom";

        ArrayList<QuakeEntry> list = parser.read(source);
//        QuakeSort qs = new QuakeSort();
//        qs.sortByDepth(list, 50);
//        for (QuakeEntry qe : list) {
//            System.out.println(qe.toString());
//
//        }
//        QuakeSort qs = new QuakeSort();
//        int iter = qs.sortByMagnitudeWithCheck(list);
//        System.out.println(iter);

        DifferentSorters ds = new DifferentSorters();
        ds.sortByLastWordInTitleThenByMagnitude();
    }
}