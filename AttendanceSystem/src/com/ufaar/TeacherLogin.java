package com.ufaar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TeacherLogin extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel titleLabel=new JLabel();
    private JTextField loginText=new JTextField(15);
    private JPasswordField passwordText = new JPasswordField(15);
    private JButton loginButt=new JButton();
    private JButton backbut=new JButton();



    public TeacherLogin() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
        setSize(1900, 1080);
        setBackground(Color.WHITE);
        setResizable(false);

        ImageIcon eye = new ImageIcon(getClass().getResource("png-clipart-cargill-organic-food-whole-foods-market-breakfast-back-button-angle-food-thumbnail.png)"));
        Image buttonImg = (eye).getImage().getScaledInstance(eye.getIconWidth() / 15, eye.getIconHeight() / 15, Image.SCALE_SMOOTH);
        eye = new ImageIcon(buttonImg);
        backbut.setIcon(eye);

        panel.setPreferredSize(new Dimension(400, 500));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100,20 ));
        panel.setBackground(Color.LIGHT_GRAY);

        titleLabel.setText("Login As Teacher: ");
        titleLabel.setFont(new Font("Serif", Font.ROMAN_BASELINE, 45));

        loginText.setText("Enter Login");
        loginText.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        loginText.setBackground(Color.white);



        passwordText.setText("Enter Password");
        passwordText.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        passwordText.setBackground(Color.white);

        loginButt.setText("Login");
        loginButt.setFont(new Font("Serif", Font.ROMAN_BASELINE, 25));
        loginButt.setBackground(new Color(0, 215,  20));
        loginButt.setFocusable(false);
        loginButt.setBorderPainted(false);
        loginButt.setFocusPainted(false);
        loginButt.setForeground(Color.WHITE);

        loginButt.addActionListener(this);



        add(panel);
        panel.add(titleLabel);
        panel.add(backbut);
        panel.add(loginText);
        panel.add(passwordText);
        panel.add(loginButt);

        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButt) {

            try {
                String Username = loginText.getText();
                String Password1 = String.valueOf(passwordText.getPassword());
                boolean flag = false;
                Statement statement = MyConnection.connect().createStatement();
                ResultSet results = statement.executeQuery("select * from teacher");

                while (results.next()) {
                    String teacherlogin = results.getString("login");
                    String password = results.getString("password");

                    if ((Username.equals(teacherlogin)) && (Password1.equals(password))) {
                        flag = true;
                        new ChooseClass();
                    }

                    if (!flag) {
                        JOptionPane.showMessageDialog(null, "Wrong Login or Password ");
                    }
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
