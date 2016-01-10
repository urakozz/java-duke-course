package com.urakozz.week3.interf;

/**
 * Created by yury on 10/01/16.
 */
import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int order;

    public AbstractMarkovModel(int order) {
        myRandom = new Random();
        this.order = order;
    }

    public void setTraining(String s) {
        myText = s.trim();
    }

    public void setRandom(int seed) {
        myRandom.setSeed(seed);

    }
    /**
     * Helper function for matching key and a substring <pos, order);
     * @param key
     * @param pos
     * @return
     */
    private boolean matchKey(String key, int pos) {

        return key.equals(myText.substring(pos, pos + order));

    }

    /**
     *Get the letter following key starting on pos:
     * substring(pos+order, pos+order+1)
     * @param pos
     * @return
     */
    private String getFollowingLetter(int pos) {
        // index of letter following key
        int index = pos+order;
        return myText.substring(index, index+1);
    }

    public ArrayList<String> getFollows(String key) {

        ArrayList<String> follows = new ArrayList<String>();

        for (int i = 0; i < myText.length() - order; i++) {
            // if found key, add letter after the key to the list
            // key length = order
            if (matchKey(key, i))
                follows.add(getFollowingLetter(i));
        }

        return follows;

    }

    abstract public String getRandomText(int numChars);

    @Override
    public String toString() {
        return "Markov Model order " + order;
    }

}