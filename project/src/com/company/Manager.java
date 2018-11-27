package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Manager extends User {
    private String username;
    private String password;
    private String name;
    public Manager(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
        Scanner sc = new Scanner(System.in);
        String[] f_s_name = name.split(" ");
        this.username = f_s_name[0] + "_" + f_s_name[1].substring(0, 1);
        System.out.println("Please, enter your new password:");
        String s1 = sc.nextLine();
        this.password = s1;    }
    @Override
    public void register(){
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();
        int length = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] f_s_name = name.split(" ");
        this.username = f_s_name[0] + "_" + f_s_name[1].substring(0, 1);
        if(DataBase.containsUsernameAdmin(this.username)){
            this.username = f_s_name[0] + "_" + f_s_name[1].substring(0, 1) + 1;
        }
        char[] text1 = new char[length];
        for (int i = 0; i < length; i++)
        {
            text1[i] = characters.charAt(rng.nextInt(characters.length()));
        }
        String s1 = text1.toString();
        this.password = s1;
        System.out.println("The new generic password is " +  s1);
        LoginPassword lp1 = new LoginPassword(this.username, this.password);
        this.lpp = lp1;
        DataBase.addTeacher(this.name, this.email, this.phoneNumber, this.username, this.password);
        this.thisNTeacher = DataBase.getnTeachers();
    }
    public void openCourse(Course course, boolean bol, int year, String specaility){
        course.setAccesability(bol, year, specaility);
    }
    public void viewInfo(){
        ArrayList<Teacher> tch = super.getTeacher1();
        ArrayList<Student> students = super.getStudent1();
        for(int i = 0; i < tch.size(); i++){
            System.out.println(tch.get(i).toString());
        }
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i).toString());
        }
    }
    public void sendMessage(String s){
        super.setMessage(s);
    }
    @Override
    public String toString(){
        return this.name;
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Manager){
            Manager tch = (Manager) obj;
            if(this.name.equals(tch.name)){
                return true;
            }
            else
                return false;
        }
        else return false;
    }

}
