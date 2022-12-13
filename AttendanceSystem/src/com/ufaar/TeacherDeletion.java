package com.ufaar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class TeacherDeletion extends JFrame implements ActionListener {
    JButton deleteButton = new JButton("DELETE");
    JTextField textField = new JTextField(12);
    JLabel label=new JLabel();
    private final TeacherDAO teacherDao = new TeacherDAO();

    public TeacherDeletion() throws HeadlessException {
        setLayout(new FlowLayout());
        setSize(700, 500);
        label.setText("Write the id of the teacher ");
        deleteButton.setBackground(Color.RED);

        add(label);
        add(textField);
        deleteButton.addActionListener(this);
        add(deleteButton);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final var source = e.getSource();
        if (source == deleteButton) {
            try {
                int id = Integer.parseInt(textField.getText());
                //System.out.println(id);
                 teacherDao.deleteById(id);
                new AdminFirstPage().setVisible(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
