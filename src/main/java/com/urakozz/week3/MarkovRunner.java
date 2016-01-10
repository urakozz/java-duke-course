package com.urakozz.week3;

import com.urakozz.week3.interf.EfficientMarkovModel;

/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */


public class MarkovRunner {
	public MarkovRunner(){

	}
    public void runMarkovZero(String filename) {
		FileResource fr = new FileResource(filename);
		String st = fr.asString();
		st = st.replace('\n', ' ');
//		st = "this is a test yes a test";
		MarkovZero markov = new MarkovZero();
		markov.setRandom(1024);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(100);
			printOut(text);
		}
	}
    public void runMarkovModel(String filename) {
		FileResource fr = new FileResource(filename);
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovModel markov = new MarkovModel(7);
		markov.setRandom(953);
		markov.setTraining(st);
		for(int k=0; k < 3; k++){
			String text = markov.getRandomText(100);
			printOut(text);
		}
	}
    public void runMarkovEff(String filename) {
		FileResource fr = new FileResource(filename);
		String st = fr.asString();
		st = st.replace('\n', ' ');
		EfficientMarkovModel markov = new EfficientMarkovModel(6);
		markov.setRandom(792);
		markov.setTraining(st);
//		for(int k=0; k < 3; k++){
//			String text = markov.getRandomText(100);
//			printOut(text);
//		}
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
		//2. eeuefmespwhsfoyu, s giowhersa eell; bma s.7shni:.at.ttdr.w aknf
		//5.  y O wirs bloay Ger. fo. tifthy The, A My; st- ie d, s. bloulate,
		//6. man in a green, for that haste, for a foot in her from Tybalt!
		//7. e uncle Capulet's orchard. Enter an officer, and light- more
		//9. 70162
		//10. 1549
//		new MarkovRunner().runMarkovModel("data/week3/romeo.txt");
		new MarkovRunner().runMarkovEff("data/week3/confucius.txt");
	}
	
}
