package com.urakozz.week3.interf;

/**
 * Created by yury on 10/01/16.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class EfficientMarkovModel extends AbstractMarkovModel {

    private HashMap<String, ArrayList<String>> map;

    public EfficientMarkovModel(int order) {
        super(order);
        map = new HashMap<String, ArrayList<String>>();
    }

    /**
     * Get key of order-length starging on index.
     *
     * @param index
     *
     */
    private String getKey(int index) {
        return myText.substring(index, index + order);
    }

    private String getFollowingLetter(int index) {

        return myText.substring(index+order, index+order+1);
    }

    @Override
    public void setTraining(String s) {
        super.setTraining(s);
        buildMap();
        printHashMapInfo();
    }

    /**
     * Scan whole teaching text and build map for all possible keys.
     *
     * @param key
     */
    private void buildMap() {

        for (int i = 0; i < myText.length() - order; i++) {

            String key = getKey(i);
            String follow = getFollowingLetter(i);

            if (map.containsKey(key)) {
                map.get(key).add(follow);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(follow);
                map.put(key, list);
            }
        }

    }

    @Override
    public ArrayList<String> getFollows(String key) {
        return map.get(key);
    }

    public String getRandomText(int numChars) {
        if (myText == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        int index = myRandom.nextInt(myText.length() - order);
        String key = myText.substring(index, index + order);
        sb.append(key);

        for (int k = 0; k < numChars - order; k++) {

            ArrayList<String> follows =getFollows(key);

            if (follows == null) break;

            String followsRandom = follows.get(myRandom.nextInt(follows.size()));

            sb.append(followsRandom);
            key = key.substring(1) + followsRandom;

        }

        return sb.toString();
    }

    public void printHashMapInfo() {
        System.out.printf("Map size:\t%d\nMax size:\t%d\n", mapSize(), longestFollowsSize());
//		for (String key : map.keySet()) {
//			System.out.printf("Key:\t[%s]\tvalues: ", key);
//			System.out.println(map.get(key));
//		}

    }

    public int mapSize() {
        return map.size();
    }

    public int longestFollowsSize() {
        int maxSize = 0;
        for (String key : map.keySet()) {
            maxSize = Math.max(maxSize, map.get(key).size());
        }

        return maxSize;
    }

    @Override
    public String toString() {
        return "Efficient Markov Model order " + order;
    }
}