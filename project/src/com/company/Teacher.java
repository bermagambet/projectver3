package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Teacher extends User{
    private int thisNTeacher;
    private String username;
    private String password;
    private String name;
    private String email;
    private LoginPassword lpp;
    private String phoneNumber;
    private ArrayList<Course> courses;
    private ArrayList<String> messages;
    public Teacher(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void register() throws IOException { //This line is used as the setUsername()/setPassword() method, but more flexible
        Scanner sc = new Scanner(System.in);
        Random rng = new Random();
        int length = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] f_s_name = name.split(" ");
        this.username = f_s_name[0] + "_" + f_s_name[1].substring(0, 1);
        if(DataBase.containsUsernameTeacher(this.username)){
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

    public boolean teacherRun(){
        Scanner sc = new Scanner(System.in);
        while(true){
            String s = sc.nextLine();
            if(s.equals("add course")){
                System.out.println("Which course do you want to add? Type it's title");
                String s1 = sc.nextLine();
                DataBase.addCourseToTeachers(, this.thisNTeacher);
            }



        }



    }


    public void receiveMessage(){
        this.messages.add(super.getMessage());
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getTeacherName(){
        return this.name;
    }

    public void setTeacherName(String name){
        this.name = name;
        Scanner sc = new Scanner(System.in);
        String[] f_s_name = name.split(" ");
        this.username = f_s_name[0] + "_" + f_s_name[1].substring(0, 1);
        System.out.println("Please, enter your new password:");
        String s1 = sc.nextLine();
        this.password = s1;    }

    public void addCourse(Course course){
        this.courses.add(course);
    }
    public void viewCourses(){
        System.out.println("The courses of the Teacher " + this.name + " are:");
        for(int i = 0; i < courses.size(); i++){
            System.out.println(courses.get(i).toString());
        }
    }
    public void addCourseFiles(CourseFile cf){
        System.out.println("Please, enter the name of Course to add Course Files:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseFiles().equals(s))
            courses.get(i).addCourseFile(cf);
        }
    }
    public void deleteCourseFiles(CourseFile cf){
        System.out.println("Please, enter the name of Course to remove Course Files:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseTitle().equals(s)){
             courses.get(i).getCourseFiles().remove(cf);
            }
        }
    }
    public void putMark(Mark m){
        System.out.println("Please, enter the name of Course to add Mark:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseTitle().equals(s)){
                courses.get(i).getMarks().add(m);
            }
        }
    }
    public void viewStudents(){
        System.out.println("Please, enter the name of Course to view Students:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        for(int i = 0; i < courses.size(); i++){
            if(courses.get(i).getCourseTitle().equals(s)){
                for(int j = 0; j < courses.get(i).getStudents().size(); j++ ){
                    System.out.println(courses.get(i).getStudents().get(j).toString());
                }
            }
        }
    }
    public void sendOrder(String s){
        Order order = new Order(s);
        super.setOrderPrim(order);
    }
    @Override
    public String toString(){
        return this.name + " " + this.email + " " + this.phoneNumber;
    }
    @Override
    public boolean equals(Object obj){
        if (obj instanceof Teacher){
            Teacher tch = (Teacher) obj;
            if(this.name.equals(tch.name)){
                return true;
            }
            else
                 return false;
        }
        else return false;
    }
}
