package com.ufaar;



import java.sql.Date;

public class Student {
    private static int studentid;
    private String name;
    private String surname;
    private String numclass;
    private int english_abs;
    private int history_abs;
    private int math_abs;
    private int arm_abs;
    private int french_abs;
    private int sport_abs;



    public Student() {
    }

    public Student(int studentid, String name, String surname, String numclass, int english_abs, int history_abs, int math_abs, int arm_abs, int french_abs, int sport_abs) {
        this.studentid = studentid;
        this.name = name;
        this.surname = surname;
        this.numclass=numclass;
        this.english_abs=english_abs;
        this.history_abs=history_abs;
        this.math_abs=math_abs;
        this.arm_abs=arm_abs;
        this.french_abs=french_abs;
        this.sport_abs=sport_abs;



    }
    public Student( String name, String surname){
        this.name = name;
        this.surname = surname;
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

    public String getNumclass() {
        return numclass;
    }

    public void setNumclass(String numclass) {
        this.numclass = numclass;
    }



    public int getEnglish_abs() {
        return english_abs;
    }

    public void setEnglish_abs(int english_abs) {
        this.english_abs = english_abs;
    }

    public int getHistory_abs() {
        return history_abs;
    }

    public void setHistory_abs(int history_abs) {
        this.history_abs = history_abs;
    }

    public int getMath_abs() {
        return math_abs;
    }

    public void setMath_abs(int math_abs) {
        this.math_abs = math_abs;
    }

    public int getArm_abs() {
        return arm_abs;
    }

    public void setArm_abs(int arm_abs) {
        this.arm_abs = arm_abs;
    }

    public int getFrench_abs() {
        return french_abs;
    }

    public void setFrench_abs(int french_abs) {
        this.french_abs = french_abs;
    }

    public int getSport_abs() {
        return sport_abs;
    }

    public void setSport_abs(int sport_abs) {
        this.sport_abs = sport_abs;
    }

    @Override
    public String toString() {
        return studentid + " " + name + " " + surname  + numclass + " " + english_abs + " " + history_abs + " " + math_abs + " " + arm_abs + " " + french_abs  + sport_abs + " " +"\n";
    }
}
