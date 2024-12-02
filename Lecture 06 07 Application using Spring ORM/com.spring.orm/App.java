package com.spring.orm;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

        Scanner sc = new Scanner(System.in);

        boolean go = true;

        System.out.println("++++++++++++++++Welcome to the Student Management System++++++++++++++++");

        while (go) {
            System.out.println();
            System.out.println("PRESS 1 to add new student");
            System.out.println("PRESS 2 to display all the students");
            System.out.println("PRESS 3 to get detail of single student");
            System.out.println("PRESS 4 to delete student");
            System.out.println("PRESS 5 to update student");
            System.out.println("PRESS 6 to exit");
            System.out.println();

            try {
                System.out.print("Enter the choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline

                switch (choice) {
                    case 1: // Inserting the new student
                        System.out.print("Enter the student id: ");
                        int studentId = sc.nextInt();
                        sc.nextLine(); // Consume the leftover newline
                        System.out.print("Enter the student name: ");
                        String studentName = sc.nextLine();
                        System.out.print("Enter the student city: ");
                        String studentCity = sc.nextLine();

                        Student student = new Student(studentId, studentName, studentCity);

                        int r = studentDao.insert(student);

                        if (r != 0)
                            System.out.println("Insertion successful");
                        else
                            System.out.println("Insertion failed.");

                        break;

                    case 2: // Display all the students
                        List<Student> allStudents = studentDao.getAllStudents();

                        System.out.println("+----------+----------------+--------------------+");
                        System.out.println("|    Id    |      Name      |         City       +");
                        System.out.println("+----------+----------------+--------------------+");
                        
                        for (Student s : allStudents) {
                            System.out.printf("| %-6d | %-14s | %-18s |\n",s.getStudentId(),s.getStudentName(),s.getStudentCity());
                        }
                        
                        System.out.println("+----------+----------------+--------------------+");

                        break;

                    case 3: // Get detail of a single student
                        System.out.print("Enter the student Id: ");
                        int studentId1 = sc.nextInt();
                        sc.nextLine(); // Consume the leftover newline

                        Student student2 = studentDao.getStudent(studentId1);

                        System.out.println(student2);
                        break;

                    case 4: // Deleting the student
                        System.out.print("Enter the student Id: ");
                        int studentId2 = sc.nextInt();
                        sc.nextLine(); // Consume the leftover newline

                        studentDao.deleteStudent(studentId2);
                        System.out.println("Student deleted successfully!!!");
                        break;

                    case 5: // Updating the student
                        System.out.print("Enter the student id: ");
                        int studentId3 = sc.nextInt();
                        sc.nextLine(); // Consume the leftover newline
                        System.out.print("Enter the student name: ");
                        String studentName3 = sc.nextLine();
                        System.out.print("Enter the student city: ");
                        String studentCity3 = sc.nextLine();

                        Student student3 = new Student(studentId3, studentName3, studentCity3);

                        studentDao.updateStudent(student3);
                        
                        System.out.println("Data updated successfully!!!");
                        break;

                    case 6: // Exit
                        go = false;
                        System.out.println("++++++++++++++++Thanks for using the system!!!++++++++++++++++");
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, try again!");
                sc.nextLine(); // Clear the input buffer in case of invalid input
            }
        }

        sc.close();
    }
}
