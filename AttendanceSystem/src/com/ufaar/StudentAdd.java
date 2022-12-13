package com.ufaar;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class StudentAdd extends JFrame implements ActionListener {

    private JLabel nameLabel = new JLabel("Name");
    private JLabel surnameLabel = new JLabel("Surname");
    private JLabel classlabel = new JLabel("Class");

    private JTextField name = new JTextField(12);
    private JTextField surname = new JTextField(12);
    private JTextField classnum = new JTextField(12);



    private JButton insertInto = new JButton("INSERT");

    private final StudentClassDAO studentdao = new StudentClassDAO();

    public StudentAdd() throws HeadlessException {
        setLayout(new FlowLayout());
        add(nameLabel);
        add(name);
        add(surnameLabel);
        add(surname);
        add(classlabel);
        add(classnum);


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
                StudentClass student=new StudentClass();
                student.setName(name.getText());
                student.setSurname(surname.getText());
                student.setClassnum(classnum.getText());

                var dao = new StudentClassDAO();
                Classes ress=dao.retrieveClassNumById(classnum.getText());
                student.setClassid(ress.getClassid());
                studentdao.insertStudentClassRow(student);
                setVisible(false);
                new MainWindow().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
