package com.main;

import data.Admin;
import data.Student;
import data.User;
import books.HistoryBook;
import books.StoryBook;
import books.TextBook;
import exception.custom.illegalAdminAccess;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static boolean exit = false;

    public static void main(String[] args) {
        Main main = new Main();

        addTempBooks();
        addTempStudent();

        while (!exit) {
            main.menu();
        }
    }

    Admin admin = new Admin();
    Student student = new Student();

    public void menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("==== Library System ====");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose option (1-3): ");
        int option;

        try {
            option = input.nextInt();
            switch (option) {
                case 1:
                    inputNim();
                    break;
                case 2:
                    System.out.print("Enter your username (admin): ");
                    String username = input.next();
                    System.out.print("Enter your password (admin): ");
                    String password = input.next();
                    try {
                        if (Admin.isAdmin(username, password)) {
                            System.out.println("Successfully login as Admin.");
                            Admin.isAdmin = true;
                            admin.menu();
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    break;
                case 3:
                    exit = true;
                    System.out.println("Thank you. Exiting program.");
                    break;
                default:
                    System.out.println("Invalid options.");
                    break;
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid options.");
        }
    }

    public void inputNim() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your NIM (input 99 untuk back): ");
        String nim = input.next();
        student.getNim(nim);
    }

    public static void addTempStudent(){
        Admin.StudentList.add(new Student("radan", "Teknik", "202210370311208", "Informatika"));
        Admin.StudentList.add(new Student("katak salto", "FEB", "201910330211809", "Bisnis"));
        Admin.StudentList.add(new Student("ini nama", "FIKES", "202010370321210", "Kedokteran Mesin"));
    }

    public static void addTempBooks() {
        User.bookList.add(new HistoryBook("388c-e681-9152", "title", "author", 4));
        User.bookList.add(new StoryBook("ed90-be30-5cdb", "title", "author", 0));
        User.bookList.add(new TextBook("d95e-0c4a-9523", "title", "author", 1));
    }
}