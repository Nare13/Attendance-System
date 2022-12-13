package com.ufaar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class TeacherAdd extends JFrame implements ActionListener {

    private JLabel nameLabel = new JLabel("Name");
    private JLabel surnameLabel = new JLabel("Surname");
    private JLabel classlabel = new JLabel("Class");
    private JLabel loginlabel = new JLabel("Username");
    private JLabel passlabel = new JLabel("Password");


    private JTextField name = new JTextField(12);
    private JTextField surname = new JTextField(12);
//    private JTextField classnum = new JTextField(12);
    private JTextField login = new JTextField(12);
    private JTextField password = new JTextField(12);



    private JButton insertInto = new JButton("ADD");

    private final TeacherDAO teacherDao = new TeacherDAO();

    public TeacherAdd() throws HeadlessException {
        setLayout(new FlowLayout());
        add(nameLabel);
        add(name);
        add(surnameLabel);
        add(surname);

        add(loginlabel);
        add(login);
        add(passlabel);
        add(password);


        insertInto.addActionListener(this);
        add(insertInto);

        setSize(600, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if (source == insertInto) {
            try {
                Teacher teacher=new Teacher();
                teacher.setName(name.getText());
                teacher.setSurname(surname.getText());

//                var dao = new StudentClassDAO();
//                Classes ress=dao.retrieveClassNumById(classnum.getText());
                //student.setClassid(ress.getClassid());

                teacher.setUsername(login.getText());
                teacher.setPassword(password.getText());
                teacherDao.insertTeacherRow(teacher);
                setVisible(false);
                new MainWindow().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
