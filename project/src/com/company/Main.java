package com.company;

import sun.plugin2.liveconnect.JavaClass;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Admin admin = new Admin("Mike Douglas");
        admin.addUser(admin);
        while (true) {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Welcome to IntraNet v1.0.");
            System.out.println("Type 'help' to get list of commands");

            String c = br.readLine();

            if (c.equals("login")) {
                System.out.println("Are you an Admin-1, Teacher-2, Manager-3, Student-4, Executor-5 ?");
                String code = br.readLine();
                User us;
                if (Integer.parseInt(code) == 1) {
                    System.out.println("Enter login:");
                    String login = br.readLine();
                    System.out.println("Enter password:");
                    String password = br.readLine();
                    while (true) {
                        try {
                            FileInputStream file = new FileInputStream("admintPW.txt");
                            ObjectInputStream in = new ObjectInputStream(file);
                            LoginPassword s1 = (LoginPassword) in.readObject();
                            LoginPassword s2 = new LoginPassword(login, password);
                            System.out.println(s1);
                            if (s1.equals(s2)) {

                                System.out.println("The user is found.");
                            }
                            Admin a = new Admin(DataBase.getAdmin(login, password));
                            while(a.adminRun())
                            in.close();
                            file.close();
                        } catch (Exception e) {
                            break;
                        }
                    }
                } else if (Integer.parseInt(code) == 2) {
                    System.out.println("Enter login:");
                    String login = br.readLine();
                    System.out.println("Enter password:");
                    String password = br.readLine();
                    while (true) {
                        try {
                            FileInputStream file = new FileInputStream("teachertPW.txt");
                            ObjectInputStream in = new ObjectInputStream(file);
                            LoginPassword s1 = (LoginPassword) in.readObject();
                            LoginPassword s2 = new LoginPassword(login, password);
                            System.out.println(s1);
                            if (s1.equals(s2)) {
                                System.out.println("The user is found.");
                            }
                            String[] sarr = DataBase.getTeacher(login, password).split(" ");
                            Teacher t = new Teacher(sarr[0], sarr[1], sarr[2]);
                            t.teacherRun();
                            in.close();
                            file.close();
                        } catch (Exception e) {
                            break;
                        }
                    }
                } else if (Integer.parseInt(code) == 3) {

                } else if (Integer.parseInt(code) == 4) {

                } else if (Integer.parseInt(code) == 5) {

                }
            }

        }
    }
}






