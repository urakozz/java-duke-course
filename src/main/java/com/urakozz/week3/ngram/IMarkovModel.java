package com.urakozz.week3.ngram;

/**
 * Created by yury on 10/01/16.
 */
public interface IMarkovModel {
    public void setTraining(String text);
    public void setRandom(int seed);
    public String getRandomText(int numChars);

}
