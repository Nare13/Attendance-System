package com.ufaar;

import java.sql.Date;

public class Teacher {
    private int teacherid;
    private String name;
    private String surname;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Teacher() {
    }

    public Teacher(int teacherid, String name, String surname) {
        this.teacherid = teacherid;
        this.name = name;
        this.surname = surname;

    }
    public Teacher( String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public int getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(int teacherid) {
        this.teacherid = teacherid;
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

    @Override
    public String toString() {
        return teacherid + " " + name + " " + surname  + "\n";
    }
}
