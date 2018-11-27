package com.company;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.ArrayList;

public class DataBase implements Serializable {
    private static int nTeachers = 0;
    private static ArrayList<User> users;
    private static ArrayList<Course> courses;
    private static ArrayList<Student> students;

    private static ArrayList<Mark> marks;
    private static ArrayList<Order> orders;
    private static ArrayList<CourseFile> courseFiles;

    private static ArrayList<String> managers = new ArrayList<>();
    private static ArrayList<String> managerUsernames = new ArrayList<>();
    private static ArrayList<String> managerPassword = new ArrayList<>();

    private static ArrayList<ArrayList<Course>> teacherCourses = new ArrayList<>();
    private static ArrayList<String> teachers = new ArrayList<>();
    private static ArrayList<String> teacherUsernames = new ArrayList<>();
    private static ArrayList<String> teacherPasswords = new ArrayList<>();


    private static ArrayList<String> admins = new ArrayList<>();
    private static ArrayList<String> adminUsername = new ArrayList<>();
    private static ArrayList<String> adminPassword = new ArrayList<>();



    public static void addManager(String name, String username, String password){
        managers.add(name);
        managerUsernames.add(username);
        managerPassword.add(password);
    }

    public static void saveAllAdmins() throws IOException {
        FileOutputStream file = new FileOutputStream("admintPW.txt");
        ObjectOutputStream in = new ObjectOutputStream(file);
        for(int i = 0; i < admins.size(); i++) {
            LoginPassword lp = new LoginPassword(adminUsername.get(i), adminPassword.get(i));
            in.writeObject(lp);
        }
        in.close();
        file.close();
    }







    public static void addAdmin(String name, String username, String password){
        admins.add(name);
        adminUsername.add(username);
        adminPassword.add(password);
    }
    public static void saveAllAdmins() throws IOException {
        FileOutputStream file = new FileOutputStream("admintPW.txt");
        ObjectOutputStream in = new ObjectOutputStream(file);
        for(int i = 0; i < admins.size(); i++) {
            LoginPassword lp = new LoginPassword(adminUsername.get(i), adminPassword.get(i));
            in.writeObject(lp);
        }
        in.close();
        file.close();
    }
    public static void deleteAdmin(String name){
        for(int i = 0; i < admins.size(); i++) {
            admins.get(i).equals(name);
            admins.remove(name);
            adminUsername.remove(adminUsername.get(i));
            adminPassword.remove(adminPassword.get(i));

        }
    }

    public static String getAdmin(String username, String password){
        for(int i = 0; i < admins.size(); i++){
            if(adminUsername.get(i).equals(username) && adminPassword.get(i).equals(password)){
                return admins.get(i);
            }
        }
        return null;
    }
    public static boolean containsUsernameAdmin(String username){
        if (adminUsername.contains(username)){
            return true;
        }
        else
            return false;
    }








    public static int getnTeachers(){
        return nTeachers;

    }

    public static void addCourseToTeachers(Course course, int number){
        teacherCourses.get(number).add(course);
    }

    public static void addTeacher(String name, String email, String phonenumber, String username, String password){
        teachers.add(name + " " + email + " " + phonenumber);
        teacherUsernames.add(username);
        teacherPasswords.add(password);

        String path = "C:"+File.separator+"project";
        String fname= path+File.separator+"teacher" + nTeachers + ".txt";
        nTeachers++;
        File f = new File(path);
        File f1 = new File(fname);

        f.mkdirs() ;
        try {
            f1.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean containsUsernameTeacher(String username){
        if(teacherUsernames.contains(username)){
            return true;
        }
        else
            return false;
    }

    public static String getTeacher(String username, String password) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teacherUsernames.get(i).equals(username) && teacherPasswords.get(i).equals(password)) {
                return teachers.get(i);
            }
        }
        return null;
    }
}