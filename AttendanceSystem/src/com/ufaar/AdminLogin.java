package com.ufaar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminLogin extends JFrame implements ActionListener {
    private JPanel panel = new JPanel();
    private JLabel titleLabel = new JLabel();
    private JTextField loginText = new JTextField(15);
    private JPasswordField passwordText = new JPasswordField(15);
    private JButton loginButt=new JButton();



    public AdminLogin() throws HeadlessException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
        setSize(1900, 1080);
        setBackground(Color.WHITE);


        panel.setPreferredSize(new Dimension(400, 500));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100,20 ));
        panel.setBackground(Color.LIGHT_GRAY);

        titleLabel.setText("Login As Admin: ");
        titleLabel.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 45));

        loginText.setText("Enter Login");
        loginText.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        loginText.setBackground(Color.white);

        passwordText.setText("Enter Password");
        passwordText.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        passwordText.setBackground(Color.white);

        loginButt.setText("Login");
        loginButt.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        loginButt.setBackground(Color.GREEN);
        loginButt.setFocusable(false);

        loginButt.addActionListener(this);

        add(panel);
        panel.add(titleLabel);
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
                ResultSet results = statement.executeQuery("select * from adminloginpass");

                while (results.next()) {
                    String adminlogin = results.getString("login");
                    String password = results.getString("password");

                    if ((Username.equals(adminlogin)) && (Password1.equals(password))) {
                        flag = true;
                        new AdminFirstPage();
                    }

                    if (!flag) {
                        JOptionPane.showMessageDialog(null, "Wrong Login or Password ");
                    }
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }    }
    }
}