package com.ufaar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private List<Student> students = new ArrayList<>();
    private Statement statement = null;
    private ResultSet resultSet = null;
    private int columnCount;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }



    public Object[][] getAllData() {
        Object[][] data = null;
        try {
            Statement statement = MyConnection.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from student");
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

    private int getRowCount() {
        int rowCount = -1;
        try {
            statement = MyConnection.connect().createStatement();
            String countQuery = "select count(name) from student";
            ResultSet rowCountResSet = statement.executeQuery(countQuery);
            rowCountResSet.next();
            rowCount = rowCountResSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public String getAllStudents() {
        String result = "";
        for (Student student : students) {
            result += student.toString();

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
            statement.executeUpdate("delete from student where studentid=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String toQuotedString(String s) {
        return '"' + s + '"';
    }

    public void insertStudentRow(Student student) {
        try {
            statement = MyConnection.connect().createStatement();
            String row = "insert into student values (NULL ," + toQuotedString(student.getName()) + ',' + toQuotedString(student.getSurname())+
                    ',' + toQuotedString(student.getNumclass())+',' + "1" + ',' +"0"+',' +"0"+ ',' +"0"+',' +"0"+',' + "0"+',' +"0" + ")";

            System.out.println("StudentDAO insertRow: " +row);

            statement.executeUpdate(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateStudentRow(Student student) {
        try {
            statement = MyConnection.connect().createStatement();
            String row = "update student set name ="+ toQuotedString(student.getName())
                    + ',' + "surname =" + toQuotedString(student.getSurname())
                    + " where studentid="+Student.getStudentid();

            System.out.println("StudentDAO updateRow: " +row);

            statement.executeUpdate(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Student retrieveStudentById(int id) {
        Student student = new Student();
        try {
            statement = MyConnection.connect().createStatement();
            String row = "select * from student where studentid = " + id;
            resultSet = statement.executeQuery(row);
            if (resultSet.next()) {
                student.setStudentid(resultSet.getInt(1));
                student.setName(resultSet.getString(2).toString());
                student.setSurname(resultSet.getString(3).toString());

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }







    public Object[][] getTableData() {
        Object[][] data1 = null;
        try {
            Statement statement = MyConnection.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("select id name surname from student");
            int columnCount = resultSet.getMetaData().getColumnCount();
            int rowCount = getRowCount();
            data1 = new Object[rowCount][columnCount];
            int i = 0;
            while (resultSet.next()) {
                for (int j = 0; j < columnCount; j++) {
                    data1[i][j] = resultSet.getObject(j + 1);
//                    System.out.print(data[i][j] + " ");
                }
//                System.out.println();
                i++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data1;
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
