package com.urakozz.week3.ngram;

/**
 * Created by yury on 10/01/16.
 */
public class WordGram {
    private String[] myWords;
//    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }


    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        return myWords.length;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<myWords.length;i++) {
            sb.append(myWords[i]);
            sb.append(" ");
        }

        return sb.toString();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;

        if (this.length() != other.length()) return false;

        for (int i=0;i<this.length();i++)
            if (!this.wordAt(i).equals(other.wordAt(i))) return false;

        return true;

    }

    public WordGram shiftAdd(String word) {

        String[] words = new String[this.length()];

        for (int i=0;i<words.length-1;i++) {
            words[i]=this.wordAt(i+1);
        }
        words[words.length-1]=word;

        return new WordGram(words,0,words.length);
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

}