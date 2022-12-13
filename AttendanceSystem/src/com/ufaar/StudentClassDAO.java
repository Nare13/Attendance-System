package com.ufaar;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class StudentClassDAO {
    private List<StudentClass> studentsclasses = new ArrayList<>();
    private Student student = new Student();
    private Classes class1 = new Classes();
    private Statement statement = null;
    private ResultSet resultSet = null;


    public StudentClassDAO() {
    }

    public StudentClassDAO(Student student, Classes class1) {
        this.student = student;
        this.class1 = class1;
    }


//    public void fillBooks(){
//        int i = 0;
//        try {
//            statement = MyConnection.connect().createStatement();
//            resultSet = statement.executeQuery("Select student.name, student.surname, class.classnum from student, class where student.classid = class.classid ");
//            while(resultSet.next()){
//                StudentClass booksAndAuthors = new StudentClass();
//                StudentClass.setAuthor(new Author(resultSet.getString(1),resultSet.getString(2)));
//                booksAndAuthors.setBook(new Book(resultSet.getString(3)));
////                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
//                authorsAndBooks.add(booksAndAuthors);
//                System.out.println(authorsAndBooks.get(i).getAuthor().getName() + " " + authorsAndBooks.get(i).getAuthor().getName() + " " + authorsAndBooks.get(i).getBook().getTitle() );
//                i++;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//    }


    public List<StudentClass> getStudentsclasses() {
        return studentsclasses;
    }

    public void setStudentsclasses(List<StudentClass> studentsclasses) {
        this.studentsclasses = studentsclasses;
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

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public List<StudentClass> getStudentsClass() {
        return studentsclasses;
    }
    public String getStudentClass(){
        String str = "";
         for (int i = 0; i < studentsclasses.size(); i++) {
            str += studentsclasses.get(i).getStudent().getName();
            str += " ";
            str += studentsclasses.get(i).getStudent().getSurname();
            str += " ";

        }
        return str;
    }
    public int getRowCount() {
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

    public Object[][] getTableData(int classid) {

        Object[][] data1 = null;
        try {
            Statement statement = MyConnection.connect().createStatement();
            ResultSet resultSet = statement.executeQuery("Select student.studentid, " +
                    "student.name, student.surname, class.classnum from student, class where student.classid = class.classid and class.classid="+classid);
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

    public int Absentscount(String subject) {
        int rowCount = -1;
        try {
            statement = MyConnection.connect().createStatement();
            String countQuery = "select count(" +subject +") from student ";
            ResultSet rowCountResSet = statement.executeQuery(countQuery);
            rowCountResSet.next();
            rowCount = rowCountResSet.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }

    public int TotalAbsentscount (){
        int totalcount=Absentscount("English")+Absentscount("Armenian")+Absentscount("Mathematics")+Absentscount("History")+Absentscount("French")+Absentscount("Sport");
        return totalcount;
    }

    public Classes retrieveClassNumById(String res) {
        Classes classes = new Classes();
        try {
            statement = MyConnection.connect().createStatement();
            String row = "select classid from class where classnum = " + res;
            resultSet = statement.executeQuery(row);
            if (resultSet.next()) {
                classes.setClassid(resultSet.getInt(1));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return classes;
    }
    private String toQuotedString(String s) {
        return '"' + s + '"';
    }

    public void insertStudentClassRow(StudentClass student) {
        try {
            statement = MyConnection.connect().createStatement();
            String row = "insert into student values (NULL ," + toQuotedString(student.getName()) + ',' + toQuotedString(student.getSurname())+ ',' + toQuotedString(student.getClassnum())+',' + toQuotedString(student.getClassid()) + ',' +"0"+',' +"0"+ ',' +"0"+',' +"0"+',' + "0"+',' +"0" + ")";

            System.out.println("StudentDAO insertRow: " +row);

            statement.executeUpdate(row);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//    public String[][] getAuthorAndBookList(){
//        String[][] result = new String[10][3];
//        for (int i = 0; i < studentsclasses.size(); i++) {
//            result[i][0] = studentsclasses.get(i).getStudent().getName();
//            result[i][1] = studentsclasses.get(i).getStudent().getSurname();
//            result[i][2] = studentsclasses.get(i).getClass().getClassnum();
//        }
//        return result;
//    }
}
