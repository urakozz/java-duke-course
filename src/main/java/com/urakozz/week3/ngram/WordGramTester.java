package com.urakozz.week3.ngram;

/**
 * Created by yury on 10/01/16.
 */
import java.util.ArrayList;

public class WordGramTester {
    public void testWordGram(){
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        int size = 4;
        for(int index = 0; index <= words.length - size; index += 1) {
            WordGram wg = new WordGram(words,index,size);
            System.out.println(index+"\t"+wg.length()+"\t"+wg);
        }
    }

    public void testWordGramEquals(){
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        ArrayList<WordGram> list = new ArrayList<WordGram>();
        int size = 4;
        for(int index = 0; index <= words.length - size; index += 1) {
            WordGram wg = new WordGram(words,index,size);
            list.add(wg);
        }
        WordGram first = list.get(0);
        System.out.println("checking "+first);
        for(int k=0; k < list.size(); k++){
            //if (first == list.get(k)) {
            if (first.equals(list.get(k))) {
                System.out.println("matched at "+k+" "+list.get(k));
            }
        }
    }

    public void testShiftAdd() {
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        int size = 4;
        int index = 2;
        WordGram wg = new WordGram(words,index,size);

        System.out.println("Original:\t"+wg);
        System.out.println("Shifted:\t"+wg.shiftAdd("Shift"));

    }

    public static void main(String[] args) {
        WordGramTester t = new WordGramTester();
		t.testWordGram();
//		t.testWordGramEquals();
//        t.testShiftAdd();
    }

}
