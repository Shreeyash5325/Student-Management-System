package com.sms.main;

import java.util.Scanner;
import com.sms.model.Student;
import com.sms.util.FileHandler;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1.Add\n2.View\n3.Search\n4.Update\n5.Delete\n6.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Marks: ");
                    double marks = sc.nextDouble();

                    FileHandler.addStudent(new Student(id, name, marks));
                    break;

                case 2:
                    FileHandler.viewAll();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    FileHandler.search(sc.nextInt());
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    System.out.print("New Name: ");
                    String uname = sc.nextLine();

                    System.out.print("New Marks: ");
                    double umarks = sc.nextDouble();

                    FileHandler.update(uid, uname, umarks);
                    break;

                case 5:
                    System.out.print("Enter ID: ");
                    FileHandler.delete(sc.nextInt());
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}