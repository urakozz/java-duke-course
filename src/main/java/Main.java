import com.urakozz.week1.EarthQuakeParser;
import com.urakozz.week1.Location;
import com.urakozz.week1.QuakeEntry;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by yury on 25/12/15.
 */
public class Main
{
    public static void main(String[] args)
    {

        week1();
    }

    private static void week1(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";

        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, Collections.reverseOrder());

        int i = 0;

        Location l = new Location(55.7308, 9.1153);

        for(QuakeEntry qe: list) {
            if (qe.getLocation().distanceTo(l) <= 3000000 && qe.getInfo().contains("e") && qe.getMagnitude() >0 && qe.getMagnitude() < 5){
                i++;
                System.out.println(qe.toString());
            }
        }
        System.out.println(i);
    }
}