package com.ufaar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {
    private List<Teacher> teachers = new ArrayList<>();
    private Statement statement = null;
    private ResultSet resultSet = null;
    private int columnCount;

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }


    public Object[][] getAllData() {
        Object[][] data = null;
        try {
            Statement statement = MyConnection.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from teacher");
            int columnCount = resultSet.getMetaData().getColumnCount();
            int rowCount = getRowCount();
            data = new Object[rowCount][columnCount];
            int i = 0;
            while (resultSet.next()) {
                for (int j = 0; j < columnCount; j++) {
                    data[i][j] = resultSet.getObject(j + 1);
//                    System.out.print(data[i][j] + " ");
                }
//                System.out.println();
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    public int getRowCount() {
        int rowCount = -1;
        try {
            statement = MyConnection.connect().createStatement();
            String countQuery = "select count(name) from teacher";
            ResultSet rowCountResSet = statement.executeQuery(countQuery);
            rowCountResSet.next();
            rowCount = rowCountResSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public String getAllTeachers() {
        String result = "";
        for (Teacher teacher : teachers) {
            result += teacher.toString();

        }
        return result;
    }

    public int getColumnCount() {
        int count;
        try {
            count = resultSet.getMetaData().getColumnCount();
        } catch (SQLException e) {
            count = 0;
            e.printStackTrace();
        }
        return count;
    }

    public void deleteById(int id) {
        try {
            statement = MyConnection.connect().createStatement();
            statement.executeUpdate("delete from teacher where teacherid=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String toQuotedString(String s) {
        return '"' + s + '"';
    }

    public void insertTeacherRow(Teacher teacher) {
        try {
            statement = MyConnection.connect().createStatement();
            String row = "insert into teacher values (NULL," + toQuotedString(teacher.getName()) + ',' + toQuotedString(teacher.getSurname())+ ',' + toQuotedString(teacher.getUsername())+ ',' + toQuotedString(teacher.getPassword())+")";

            System.out.println("AuthorDAO insertRow: " +row);

            statement.executeUpdate(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateTeacherRow(Teacher teacher) {
        try {
            statement = MyConnection.connect().createStatement();
            String row = "update teacher set name ="+ toQuotedString(teacher.getName())
                    + ',' + "surname =" + toQuotedString(teacher.getSurname())
                     + " where teacherid="+teacher.getTeacherid();

            System.out.println("TeacherDAO updateRow: " +row);

            statement.executeUpdate(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Teacher retrieveTeacherById(int id) {
        Teacher teacher = new Teacher();
        try {
            statement = MyConnection.connect().createStatement();
            String row = "select * from teacher where teacherid = " + id;
            resultSet = statement.executeQuery(row);
            if (resultSet.next()) {
                teacher.setTeacherid(resultSet.getInt(1));
                teacher.setName(resultSet.getString(2).toString());
                teacher.setSurname(resultSet.getString(3).toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teacher;
    }



//    public String[][] gettingData() {
//        String data[][] = new String[authors.size()][getColumnCount()];
//        for (int i = 0; i < authors.size(); i++) {
//            data[i][0] = String.valueOf(authors.get(i).getAuthorid());
//            data[i][1] = authors.get(i).getName();
//            data[i][2] = authors.get(i).getName();
//        }
//
//    }
}
