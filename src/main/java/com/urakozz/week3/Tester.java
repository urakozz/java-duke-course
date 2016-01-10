package com.urakozz.week3;

import com.urakozz.week3.interf.EfficientMarkovModel;

import java.util.ArrayList;

/**
 * Created by yury on 10/01/16.
 */
public class Tester {

    private void testGetFollowsWithFile() {
        FileResource fr = new FileResource("data/week3/confucius.txt");
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovModel markov = new MarkovModel();
        markov.setRandom(88);
        markov.setTraining(st);
        ArrayList<String> list = markov.getFollows("he");
        System.out.println(list.size());
    }

    public static void main(String[] args) {
        new Tester().testGetFollowsWithFile();
        // 3 10453
        // 4 3715
//        EfficientMarkovModel em = new EfficientMarkovModel(5);
//        em.setRandom(615);
//        em.setTraining(new FileResource("data/week3/romeo.txt").asString());
    }
}
