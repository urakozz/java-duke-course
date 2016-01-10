package com.urakozz.week3.ngram;

/**
 * Created by yury on 10/01/16.
 */
import java.util.ArrayList;
import java.util.HashMap;

public class EfficientMarkovWord extends AMarkovWord {

    private HashMap<WordGram, ArrayList<String>> map;

    public EfficientMarkovWord(int order) {
        super(order);
        map = new HashMap<WordGram, ArrayList<String>>();
    }

//    private int indexOf(String[] words, WordGram target, int start) {
//
//    	for (int i=start;i<words.length-order;i++) {
//    		WordGram wg = new WordGram(words,i,order);
//    		if (wg.equals(target)) return i;
//    	}
//
//    	return -1;
//    }

    private void buildMap() {

        for (int i=0; i<myText.length-order;i++) {
            WordGram wg = new WordGram(myText,i,order);
            String next = myText[i+order];
            if (map.containsKey(wg)) {
                map.get(wg).add(next);
            }
            else {
                ArrayList<String> list = new ArrayList<String>();
                list.add(next);
                map.put(wg, list);
            }
        }

    }

    @Override
    public void setTraining(String text) {
        super.setTraining(text);
        buildMap();
        printHashMapInfo();
    }

    private ArrayList<String> getFollows(WordGram kGram) {
        return map.get(kGram);
    }

    @Override
    public String getRandomText(int numChars) {

        StringBuilder sb = new StringBuilder();

        int index = myRandom.nextInt(myText.length-order);
        WordGram key = new WordGram(myText,index,order);

        sb.append(key.toString());

        for (int i=0;i<numChars-order;i++) {
            ArrayList<String> follows = getFollows(key);
            if (follows == null || follows.size()==0) break;
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            append(sb, next);
            key = key.shiftAdd(next);
        }

        return sb.toString().trim();
    }

    public void printHashMapInfo() {

        int maxSetSize = -1;

        for (WordGram wg : map.keySet()) {
            maxSetSize = Math.max(maxSetSize, map.get(wg).size());
//            System.out.println(wg+"\t: "+map.get(wg));
        }

        System.out.println("Number of keys:\t"+map.keySet().size());
        System.out.println("Max Set Size:\t"+maxSetSize);

        System.out.println("Keys with Max Size:");

//        for (WordGram wg : map.keySet()) {
//            if (map.get(wg).size()==maxSetSize)
//                System.out.println(wg);
//        }

    }

}