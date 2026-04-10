package com.sms.util;

import java.io.*;
import java.util.ArrayList;
import com.sms.model.Student;

public class FileHandler {

    private static final String FILE_NAME = "students.dat";

    public static ArrayList<Student> readAll() {
        ArrayList<Student> list = new ArrayList<>();

        try {
            ObjectInputStream ois =
                new ObjectInputStream(new FileInputStream(FILE_NAME));

            list = (ArrayList<Student>) ois.readObject();
            ois.close();

        } catch (Exception e) {
        }

        return list;
    }

    public static void writeAll(ArrayList<Student> list) {
        try {
            ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream(FILE_NAME));

            oos.writeObject(list);
            oos.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void addStudent(Student s) {
        ArrayList<Student> list = readAll();

        for (Student st : list) {
            if (st.getId() == s.getId()) {
                System.out.println("Duplicate ID!");
                return;
            }
        }

        list.add(s);
        writeAll(list);
        System.out.println("Student added!");
    }

    public static void viewAll() {
        ArrayList<Student> list = readAll();

        if (list.isEmpty()) {
            System.out.println("No data!");
            return;
        }

        for (Student s : list) {
            System.out.println(s);
        }
    }

    public static void search(int id) {
        ArrayList<Student> list = readAll();

        for (Student s : list) {
            if (s.getId() == id) {
                System.out.println(s);
                return;
            }
        }

        System.out.println("Not found!");
    }

    public static void update(int id, String name, double marks) {
        ArrayList<Student> list = readAll();
        boolean found = false;

        for (Student s : list) {
            if (s.getId() == id) {
                s.setName(name);
                s.setMarks(marks);
                found = true;
            }
        }

        if (found) {
            writeAll(list);
            System.out.println("Updated!");
        } else {
            System.out.println("Not found!");
        }
    }
    public static void delete(int id) {
        ArrayList<Student> list = readAll();
        boolean removed = list.removeIf(s -> s.getId() == id);
        if (removed) {
            writeAll(list);
            System.out.println("Deleted!");
        } else {
            System.out.println("Not found!");
        }
    }
}

