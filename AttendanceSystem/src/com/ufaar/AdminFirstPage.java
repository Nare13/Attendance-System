package com.ufaar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminFirstPage extends JFrame implements ActionListener {


    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    public JPanel panel3 = new JPanel();
    JPanel panelmenu;

    private JLabel label1= new JLabel();
    private JLabel label2=new JLabel();
    private JLabel label3=new JLabel();
    private JLabel label4=new JLabel();

    public JPanel panel4 = new JPanel();

    private JButton but1=new JButton();
    private JButton but2=new JButton();
    private JButton but3=new JButton();
    private JButton but4=new JButton();
    private JButton but5=new JButton();
    private JButton but6=new JButton();




    public  AdminFirstPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1650, 880);
        setBackground(Color.LIGHT_GRAY);


        panel1.setBounds(0,0, 150, 1080);
        panel1.setBackground(Color.GREEN);

        //panelmenu.setBounds(0,0, 350, 1080);
        //panelmenu.setBackground(Color.GREEN);

        panel2.setBounds(150,0, 200, 1080);
        panel2.setBackground(Color.WHITE);

        panel3.setLayout(new GridLayout(7, 1, 20, 30));
        panel3.setBounds(560, 80 , 750, 630);
        panel3.setBackground(Color.WHITE);
        panel3.setBorder(new EmptyBorder(10, 150, 20, 150));


        but1.setText("Menu");
        but1.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        but1.setBackground(Color.LIGHT_GRAY);
        but1.setFocusable(false);

        but2.setText("Add a Student");
        but2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 15));
        but2.setBackground(Color.LIGHT_GRAY);
        but2.setFocusable(false);

        but3.setText("Delete a Student");
        but3.setFont(new Font("Serif", Font.ROMAN_BASELINE, 15));
        but3.setBackground(Color.LIGHT_GRAY);
        but3.setFocusable(false);

        but4.setText("Edit a Student");
        but4.setFont(new Font("Serif", Font.ROMAN_BASELINE, 15));
        but4.setBackground(Color.LIGHT_GRAY);
        but4.setFocusable(false);

        but5.setText("Add a Teacher");
        but5.setFont(new Font("Serif", Font.ROMAN_BASELINE, 15));
        but5.setBackground(Color.LIGHT_GRAY);
        but5.setFocusable(false);

        but6.setText("Delete a Teacher");
        but6.setFont(new Font("Serif", Font.ROMAN_BASELINE, 15));
        but5.setBackground(Color.LIGHT_GRAY);
        but6.setFocusable(false);



        //label1.setBounds(600, 100, 50, 50);

        label1.setText("Dashboard");
        label1.setFont(new Font("Serif", Font.ROMAN_BASELINE, 50));


        var dao = new StudentClassDAO();
        int count=dao.getRowCount();
        String countstr=Integer.toString(count);
        label2.setText("Number of Students: "+countstr);
        label2.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        label2.setBackground(Color.LIGHT_GRAY);


        var dao2 = new TeacherDAO();
        int count2=dao2.getRowCount();
        String count2str=Integer.toString(count2);
        label3.setText("Number of Teachers: "+count2str);
        label3.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        label3.setBackground(Color.LIGHT_GRAY);

        var dao3 = new StudentClassDAO();
        int count3=dao3.TotalAbsentscount();
        String count3str=Integer.toString(count3);
        label4.setText("Adsents Till Today: "+count3str);
        label4.setFont(new Font("Serif", Font.ROMAN_BASELINE, 30));
        label4.setBackground(Color.LIGHT_GRAY);

        Icon icon = new ImageIcon("![](../../kisspng-hamburger-button-computer-icons-menu-5afa4b5d6c72a7.2738325215263527334442.jpg)");
        JButton but7 = new JButton(icon);




//        var dao = new ClassesDAO();
//        JComboBox dropmenu=new JComboBox(dao.getAllData());

        add(panel1);
        add(panel2);
        add(panel3);

        panel3.add(label1);
       // panel3.add(dropmenu);
        panel1.add(but1);
        panel1.add(but7);
        panel3.add(label1);
        panel3.add(label2);
        panel3.add(label3);
        panel3.add(label4);
        panel2.add(but2);
        panel2.add(but3);
        panel2.add(but4);
        panel2.add(but5);
        panel2.add(but6);

        but2.addActionListener(this);
        but2.setFocusable(false);

        but3.addActionListener(this);
        but3.setFocusable(false);

        but4.addActionListener(this);
        but4.setFocusable(false);

        but5.addActionListener(this);
        but5.setFocusable(false);

        but6.addActionListener(this);
        but6.setFocusable(false);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() ==but2) {
            new StudentAdd();
        }
        if (e.getSource() ==but3) {
            new StudentDeletion();
        }

        if (e.getSource() ==but4) {
           // new StudentEdit();
        }


        if (e.getSource() ==but5) {
            new TeacherAdd();
        }

        if (e.getSource() ==but6) {
            new TeacherDeletion();
        }


    }

}



