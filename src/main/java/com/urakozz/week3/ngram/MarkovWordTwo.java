package com.urakozz.week3.ngram;

/**
 * Created by yury on 10/01/16.
 */
import java.util.ArrayList;

public class MarkovWordTwo extends AMarkovWord {

    public MarkovWordTwo() {
        super(2);

    }

    /**
     * Return first location of target1, where target 2 is following.
     * @param words
     * @param target1
     * @param target2
     * @param start
     * @return
     */
    private int indexOf(String[] words,
                        String target1, String target2, int start) {

        for (int i=start; i<words.length-order;i++) {

            if (words[i].equals(target1) && words[i+1].equals(target2))
                return i;
        }

        return -1;
    }

    private ArrayList<String> getFollows(String key1, String key2) {

        ArrayList<String> follows = new ArrayList<String>();

        int index = indexOf(myText, key1,key2, 0);

        while (index!=-1) {
            follows.add(myText[index+order]);
            index = indexOf(myText, key1,key2, index+1);
        }

        return follows;
    }

    public void testIndexOf() {
        String[] words = "this is just a test yes this is a simple tes".split("\\s+");
        System.out.println("this is:\t"+indexOf(words, "this", "is", 0));
        System.out.println("is just:\t"+indexOf(words, "is", "just", 0));
        System.out.println("this is:\t"+indexOf(words, "this", "is", 1));
    }

    public void testGetFollows() {
        String[] words = myText;
        for (int i=0;i<words.length-2;i++) {
            System.out.println(words[i]+" "+words[i+1]+":\t"+getFollows(words[i], words[i+1]));
        }
    }


    @Override
    public String getRandomText(int numWords){
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length-order);
        String key1 = myText[index];
        String key2 = myText[index+1];
        append(sb, key1);
        append(sb, key2);

        for(int k=0; k < numWords-order; k++){
            ArrayList<String> follows = getFollows(key1, key2);
            if (follows.size() == 0) {
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            append(sb, next);

            key1 = key2;
            key2 = next;
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        MarkovWordTwo markov = new MarkovWordTwo();
        markov.setTraining("this is just a test yes this is a simple test");
//		markov.testIndexOf();
        markov.testGetFollows();
    }

}
