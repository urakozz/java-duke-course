package com.urakozz.week2.sort;

import java.util.ArrayList;

/**
 * Created by yury on 01/01/16.
 */
public class SelectionSort {


    private ArrayList<Integer> out;

    public static void main(String[] args) {
        System.out.println("hi");

        ArrayList<Integer> in = new ArrayList<Integer>(4);
        in.add(-3);
        in.add(-7);
        in.add(11);
        System.out.println(in);
        SelectionSort ss = new SelectionSort(in);
        System.out.println(in);
        System.out.println(ss.out);
        System.out.println(ss.toString());
    }

    public SelectionSort(ArrayList<Integer> in) {
        // ArrayList is proposed by professor, but it dos not looks like a best choice
        out = new ArrayList<Integer>();

        for(int i = 0; i < in.size(); i++){
            Integer min = i;
            for (Integer j = i + 1; j < in.size(); j++) {
                if (in.get(j) < in.get(min)) {
                    min = j;
                }
            }
            swap(in, i, min);
            out.add(in.get(i));
        }
    }

    private void swap(ArrayList<Integer> a, int i, int j){
        Integer swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Integer i : out) {
            s.append(i);
        }
        return s.toString();
    }
}
