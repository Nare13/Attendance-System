package com.ufaar;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener  {
    private JPanel panel = new JPanel();
    private JLabel titleLabel=new JLabel();
    private JLabel welcomelabel=new JLabel();
    private JButton adminButton=new JButton();
    private JButton teacherButton=new JButton();
    private JButton loginButt=new JButton();


    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 0, 100));
        setSize(1900, 1080);
        setBackground(Color.WHITE);
        setResizable(false);


        panel.setPreferredSize(new Dimension(400, 450));
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 150,30 ));
        panel.setBackground(Color.LIGHT_GRAY);




        titleLabel.setText("Login As: ");
        titleLabel.setFont(new Font("Serif", Font.ROMAN_BASELINE, 45));

        welcomelabel.setText("Login As: ");
        welcomelabel.setFont(new Font("Serif", Font.ROMAN_BASELINE, 55));

        adminButton.setText(" Admin ");
        adminButton.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        adminButton.setBackground(new Color(0, 215,  20));
        adminButton.setBorderPainted(false);
        //teacherButton.setContentAreaFilled(false);
        adminButton.setFocusPainted(false);
        adminButton.setForeground(Color.WHITE);



        teacherButton.setText("Teacher");
        teacherButton.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        teacherButton.setBackground(new Color(0, 215,  20));
        teacherButton.setBorderPainted(false);
        //teacherButton.setContentAreaFilled(false);
        teacherButton.setFocusPainted(false);
        teacherButton.setForeground(Color.WHITE);

        adminButton.addActionListener(this);
        teacherButton.addActionListener(this);
        adminButton.setFocusable(false);
        teacherButton.setFocusable(false);


        add(panel);
        //add.welcomelabel.setLayout(FlowLayout.LEADING);
        setVisible(true);
        panel.add(titleLabel);
        panel.add(adminButton);
        panel.add(teacherButton);



    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminButton) {
            setVisible(false);
            new AdminLogin();

        }
        if (e.getSource() == teacherButton) {
            setVisible(false);
            new TeacherLogin();

        }
    }
}
