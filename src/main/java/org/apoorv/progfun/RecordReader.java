package org.apoorv.progfun;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class RecordReader {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/home/apoorv/java-projects/students.csv"));
            reader.readLine();
            String line = reader.readLine();
            int length = reader.lines().toArray().length;
            Student[] students = new Student[length];
            for (int i = 0; i < length; i++) {
                String[] values = line.split(", ");
                System.out.println(Arrays.toString(values));
                students[i] = new Student(values[0], values[1], Integer.parseInt(values[2]), values[3].charAt(0));
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
