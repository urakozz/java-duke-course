package com.urakozz.week3;

/**
 * Created by yury on 10/01/16.
 */

import java.util.ArrayList;
import java.util.Random;

public class MarkovModel {
    private String myText;
    private Random myRandom;

    private int nOrder;


    public MarkovModel() {
        this(2);
    }
    public MarkovModel(int n) {
        myRandom = new Random();
        nOrder = n;
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String s) {
        myText = s.trim();
    }

    public ArrayList<String> getFollows(String key) {

        ArrayList<String> follows = new ArrayList<String>();
        int kl = key.length();

        for (int i = 0; i<myText.length()-kl; i++) {

            if (key.equals(myText.substring(i, i+kl)))
                follows.add(myText.substring(i+kl,i+kl+1));
        }

        return follows;

    }

    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - nOrder);
        String key = myText.substring(index, index + nOrder);
        sb.append(key);

        for (int k = 0; k < numChars - key.length(); k++) {
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
            String followsRandom = follows.get(myRandom.nextInt(follows.size()));
            sb.append(followsRandom);
            key = key.substring(1) + followsRandom;
        }

        return sb.toString();
    }
}
