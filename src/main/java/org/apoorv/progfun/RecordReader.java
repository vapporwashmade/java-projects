package org.apoorv.progfun;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecordReader {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("/tmp/students.csv"));
            reader.readLine();
            String line = reader.readLine(); // we assume that the first line is NOT null
            line = reader.readLine();
            List<Student> students = new ArrayList<>(100);
            while (line != null) {
                Student s = fromLine(line);
                students.add(s); // should return true
                System.out.println(s);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Student fromLine(String line) {
        String[] values = line.split(", ");
//        System.out.println(Arrays.toString(values));
        return new Student(values[0], values[1], Integer.parseInt(values[2]), values[3].charAt(0));

    }
}
