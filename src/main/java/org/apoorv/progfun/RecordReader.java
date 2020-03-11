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
            BufferedReader reader = new BufferedReader(new FileReader("/home/apoorv/java-projects/students.csv"));
            reader.readLine();
            String line = reader.readLine(); // we assume that the first line is NOT null
            List<Student> students = new ArrayList<>(100);
            while (line != null) {
                Student s = fromLine(line);
                students.add(s); // should return true
                line = reader.readLine();
            }
            reportStudents(students, 'm');
            getByAge(students, 15);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student fromLine(String line) {
        String[] values = line.split(", ");
        return new Student(values[0], values[1], Integer.parseInt(values[2]), values[3].charAt(0));
    }

    public static void reportStudents(List<Student> students, char gender) {
        for (Student s : students) {
            // filter
            if (s.getGender() == gender) {
                System.out.println(s.getId() + ", " + s.getName() + ", " + s.getAge());
            }
        }
    }

    public static void getByAge(List<Student> students, int age) {
        for (Student s : students) {
            if (s.getAge() == age) {
                System.out.println(s.getId() + ", " + s.getName() + ", " + s.getGender());
            }
        }
    }
}
