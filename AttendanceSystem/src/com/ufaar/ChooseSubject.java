package com.ufaar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ChooseSubject extends JFrame implements ActionListener {


    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    public JPanel panel3 = new JPanel();
    private JLabel label1= new JLabel();
    public JPanel panel4 = new JPanel();
    private JLabel label2=new JLabel();

    private JButton but1=new JButton();
    private JButton but2=new JButton();
    private JButton but3=new JButton();
    private JButton but4=new JButton();
    private JButton but5=new JButton();
    private JButton but6=new JButton();
    private int classid;


    public  ChooseSubject( int classid) {

        this.classid=classid;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1650, 880);
        setBackground(Color.LIGHT_GRAY);







        panel1.setBounds(0,0, 150, 1080);
        panel1.setBackground(Color.GREEN);

        panel2.setBounds(150,0, 200, 1080);
        panel2.setBackground(Color.WHITE);

        panel3.setLayout(new GridLayout(7, 1, 20, 30));
        panel3.setBounds(560, 80 , 750, 630);
        panel3.setBackground(Color.WHITE);
        panel3.setBorder(new EmptyBorder(10, 150, 20, 150));


        but1.setText("English");
        but1.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        but1.setBackground(Color.LIGHT_GRAY);
        but1.setFocusable(false);

        but2.setText("History");
        but2.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        but2.setBackground(Color.LIGHT_GRAY);
        but2.setFocusable(false);

        but3.setText("Mathematics");
        but3.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        but3.setBackground(Color.LIGHT_GRAY);
        but3.setFocusable(false);

        but4.setText("Armenian");
        but4.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        but4.setBackground(Color.LIGHT_GRAY);
        but4.setFocusable(false);

        but5.setText("French");
        but5.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        but5.setBackground(Color.LIGHT_GRAY);
        but5.setFocusable(false);

        but6.setText("Sport");
        but6.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 20));
        but6.setBackground(Color.LIGHT_GRAY);
        but6.setFocusable(false);



        label1.setText("Choose Subject");
        label1.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 50));

        var dao = new ClassesDAO();
        //String classnum1 =dao.retrieveClassNumById(classid);

//        label2.setFont(new Font("MV Boli", Font.ROMAN_BASELINE, 30));
//        label2.setText(classnum);


        //label1.setBounds(600, 100, 50, 50);
        but1.addActionListener(this);
        but1.setFocusable(false);
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


        add(panel1);
        add(panel2);
        add(panel3);
        //panel3.add(label2);
        panel3.add(label1);
        panel3.add(but1);
        panel3.add(but2);
        panel3.add(but3);
        panel3.add(but4);
        panel3.add(but5);
        panel3.add(but6);



        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==but1) {
            setVisible(false);
            new TickAbsents(classid, but1.getText());

        }
        if (e.getSource() ==but2) {
            setVisible(false);
            new TickAbsents(classid, but2.getText());

        }
        if (e.getSource() ==but3) {
            setVisible(false);
            new TickAbsents(classid, but3.getText());
        }
        if (e.getSource() ==but4) {
            setVisible(false);
            new TickAbsents(classid, but4.getText());
        }
        if (e.getSource() ==but5) {
            setVisible(false);
            new TickAbsents(classid, but5.getText());
        }
        if (e.getSource() ==but6) {
            setVisible(false);
            new TickAbsents(classid, but6.getText());

//        if (e.getSource() ==but1) {
//            setVisible(false);
//            new TickAbsents(but1.getText(), label2.getText());
//
//        }
//        if (e.getSource() ==but1) {
//            setVisible(false);
//            new TickAbsents(but1.getText(), label2.getText());
//        }
//        if (e.getSource() ==but2) {
//            setVisible(false);
//            new TickAbsents(but2.getText(), label2.getText());
//
//        }
//        if (e.getSource() ==but3) {
//            setVisible(false);
//            new TickAbsents(but3.getText(), label2.getText());
//        }
//        if (e.getSource() ==but4) {
//            setVisible(false);
//            new TickAbsents(but4.getText(), label2.getText());
//        }
//        if (e.getSource() ==but5) {
//            setVisible(false);
//            new TickAbsents(but5.getText(), label2.getText());
//        }
//        if (e.getSource() ==but6) {
//            setVisible(false);
//
//            new TickAbsents(but6.getText(),  label2.getText());
        }


    }
}





