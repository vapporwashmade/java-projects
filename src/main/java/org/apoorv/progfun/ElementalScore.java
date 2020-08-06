package org.apoorv.progfun;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class ElementalScore {
    public static final Hashtable<String, Integer> symbols = new Hashtable<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner reader = new Scanner(new File("/home/apoorv/java-projects/elements.txt"));
        for (int i = 0; i < 118; i++) {
            String[] nextLine = reader.nextLine().split(",");
            symbols.put(nextLine[1].toLowerCase(), Integer.parseInt(nextLine[2]));
        }
        reader = new Scanner(new File("/home/apoorv/Desktop/words.txt"));
        int highest = 0;
        String highestWord = "";
        while (reader.hasNextLine()) {
            String word = reader.nextLine();
            ArrayList<Integer> scores = score(word);
            for (int i = 0; i < scores.size(); i++) {
                if (scores.get(i) > highest) {
                    highest = scores.get(i);
                    highestWord = word;
                }
            }
        }
        System.out.println("English word with highest elemental score: " + highestWord + ", with score: " + highest);
    }

    public static ArrayList<Integer> score(String str) {
        ArrayList<Integer> scores = new ArrayList<>();
        // base case
        if (str.length() <= 0) {
            scores.add(0);
            return scores;
        }
        // recursive case
        if (symbols.containsKey(str.substring(0, 1).toLowerCase())) {
            ArrayList<Integer> previous = score(str.substring(1));
            for (int i = 0; i < previous.size(); i++) {
                scores.add(previous.get(i) + symbols.get(str.substring(0, 1).toLowerCase()));
            }
        }
        if (str.length() >= 2 && symbols.containsKey(str.substring(0, 2).toLowerCase())) {
            ArrayList<Integer> previous = score(str.substring(2));
            for (int i = 0; i < previous.size(); i++) {
                scores.add(previous.get(i) + symbols.get(str.substring(0, 2).toLowerCase()));
            }
        }
        return scores;
    }
}
