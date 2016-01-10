package com.urakozz.week3.ngram;

import com.urakozz.week3.FileResource;

/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class MarkovRunner {
    public void runModel(IMarkovModel markov, String text, int size){ 
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int size, int seed){ 
        markov.setTraining(text); 
        markov.setRandom(seed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runMarkov() { 
        FileResource fr = new FileResource("data/week3/confucius.txt");
        String st = fr.asString(); 
        st = st.replace('\n', ' '); 
        EfficientMarkovWord markovWord = new EfficientMarkovWord(2);
        markovWord.setRandom(65);
        markovWord.setTraining(st);
//        runModel(markovWord, st, 200);
    }

    public void runMarkov2() {
        FileResource fr = new FileResource("data/week3/confucius.txt");
        String st = fr.asString();
        st = st.replace('\n', ' ');
        MarkovWordTwo markovWord = new MarkovWordTwo();
        markovWord.setRandom(832);
        runModel(markovWord, st, 200);
        // agreement violates the law of the state applicable to this agreement,
        // ministers, and there was order below heaven. king wu[80] said,
        // 376
    }

    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    }

    public static void main(String[] args) {


        new MarkovRunner().runMarkov();
    }

}
