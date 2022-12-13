package com.ufaar;

import java.sql.ResultSet;
import java.sql.Statement;

public class StudentClass {
    private static int studentid;
    private String name;
    private String surname;
    private String classnum;
    private String  classid;


    private Statement statement = null;
    private ResultSet resultSet = null;
    //private int columnCount;


    Student student = new Student();
    Classes class1 = new Classes();

    public StudentClass() {
    }

    public StudentClass(Student student, Classes class1) {
        this.student = student;
        this.class1 = class1;
    }


    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Classes getClass1() {
        return class1;
    }

    public void setClass1(Classes class1) {
        this.class1 = class1;
    }
    public static int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getClassnum() {
        return classnum;
    }

    public void setClassid(int classid)
    {

        this.classid=String.valueOf(classid);
    }
    public String getClassid()
    {

        return classid;
    }


    public void setClassnum(String classnum) {
        this.classnum = classnum;
    }
    @Override
    public String toString() {
        return "StudentClass{" +
                "student=" + student +
                ", class1=" + class1 +
                '}';
    }
}
