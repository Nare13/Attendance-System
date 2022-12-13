package com.ufaar;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

public class ClassesDAO {

    private List<Classes> classes = new ArrayList<>();
    private Statement statement = null;
    private ResultSet resultSet = null;
    //private int columnCount;

    public List<Classes> getStudents() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }


    private int getRowCount() {
        int rowCount = -1;
        try {
            statement = MyConnection.connect().createStatement();
            String countQuery = "select count(classid) from class";
            ResultSet rowCountResSet = statement.executeQuery(countQuery);
            rowCountResSet.next();
            rowCount = rowCountResSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }


    public Object[][] getAllData() {
        Object[][] data1 = null;
        try {
            Statement statement = MyConnection.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("Select class.classnum from class");
            int columnCount = resultSet.getMetaData().getColumnCount();
            int rowCount = getRowCount();
            data1 = new Object[rowCount][columnCount];
            int i = 0;
            while (resultSet.next()) {
                for (int j = 0; j < columnCount; j++) {
                    data1[i][j] = resultSet.getObject(j + 1);
                    System.out.print(data1[i][j] + " ");
                }
//                System.out.println();
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data1;


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

    public String[][] gettingData() {
        String data[][] = new String[classes.size()][10];
        for (int i = 0; i < classes.size(); i++) {
            data[i][0] = String.valueOf(classes.get(i).getClassid());
            data[i][1] = classes.get(i).getClassnum();

        }

        return data;
    }

    public Classes retrieveClassesById(int id) {
        Classes classes = new Classes();
        try {
            statement = MyConnection.connect().createStatement();
            String row = "select * from class where classid = " + id;
            resultSet = statement.executeQuery(row);
            if (resultSet.next()) {
                classes.setClassid(resultSet.getInt(1));
                classes.setClassnum(resultSet.getString(2).toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }
//
//    public Classes retrieveClassNumById(String num) {
//        Classes classes = new Classes();
//        try {
//            statement = MyConnection.connect().createStatement();
//            String row = "select classid from class where classnum = " + num;
//            resultSet = statement.executeQuery(row);
//            if (resultSet.next()) {
//                classes.setClassid(resultSet.getInt(1));
//                classes.setClassnum(resultSet.getString(2).toString());
//
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return classes;
//    }

    public Classes retrieveClassNumById(String res) {
        Classes classes = new Classes();
        try {
            statement = MyConnection.connect().createStatement();
            String row = "select classid from class where classnum = " + res;
            resultSet = statement.executeQuery(row);
            if (resultSet.next()) {
                classes.setClassid(resultSet.getInt(1));
                classes.setClassnum(resultSet.getString(2).toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }
}


