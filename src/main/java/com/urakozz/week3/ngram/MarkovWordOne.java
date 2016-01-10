package com.urakozz.week3.ngram;

import com.urakozz.week3.FileResource;

import java.util.ArrayList;

/**
 * Created by yury on 10/01/16.
 */
public class MarkovWordOne extends AMarkovWord {


    public MarkovWordOne() {
        super(1);
    }
    public MarkovWordOne(int n) {
        super(n);
    }


    private int indexOf(String[] words, String target, int start) {

        for (int i=start; i<words.length; i++) {

            if (words[i].equals(target)) return i;
        }

        return -1;
    }

    private ArrayList<String> getFollows(String key) {

        ArrayList<String> follows = new ArrayList<String>();
        int index = indexOf(myText, key, 0);

        while (index!=-1) {
            follows.add(myText[index+1]);
            index = indexOf(myText, key, index+1);
        }

        return follows;
    }

    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-1);  // random word to start with
        String key = myText[index];
        sb.append(key);
        sb.append(" ");
        for(int k=0; k < numWords-1; k++){
            ArrayList<String> follows = getFollows(key);
            if (follows.size() == 0) {
                break;
            }
//		    System.out.println(key+":\t"+follows);
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            sb.append(" ");
            key = next;
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        MarkovWordOne markov = new MarkovWordOne();
        markov.setRandom(365);
        markov.setTraining(new FileResource("data/week3/romeo.txt").asString());
        String str = markov.getRandomText(20);
        System.out.println(str);
    }


}