package com.urakozz.week3.ngram;

/**
 * Created by yury on 10/01/16.
 */

import java.util.Random;

public abstract class AMarkovWord implements IMarkovModel {
    protected String[] myText;
    protected Random myRandom;
    protected int order;


    public AMarkovWord(int order) {

        myRandom = new Random();
        this.order = order;
    }

    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    public void setTraining(String text) {
        myText = text.split("\\s+");
    }

    protected void append(StringBuilder sb, String word) {
        sb.append(word);
        sb.append(" ");
    }

    public abstract String getRandomText(int numChars);


}