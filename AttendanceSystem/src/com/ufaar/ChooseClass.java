package com.ufaar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ChooseClass extends JFrame implements ActionListener {
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    public JPanel panel3 = new JPanel();
    private JLabel label1= new JLabel();
    public JPanel panel4 = new JPanel();


    private JButton but1=new JButton();
    private Buttons button1=new Buttons(but1, "1-1", panel4);
    private JButton but2=new JButton();
    private Buttons button2=new Buttons(but2, "1-2", panel4);
    private JButton but3=new JButton();
    private Buttons button3=new Buttons(but3, "1-3", panel4);
    private JButton but4=new JButton();
    private Buttons button4=new Buttons(but4, "2-1", panel4);
    private JButton but5=new JButton();
    private Buttons button5=new Buttons(but5, "3-1", panel4);

    private JButton but6=new JButton();
    private Buttons button6=new Buttons(but6, "3-2", panel4);

    private JButton but7=new JButton();
    private Buttons button7=new Buttons(but7, "4-1", panel4);

    private JButton but8=new JButton();
    private Buttons button8=new Buttons(but8, "5-1", panel4);


    private JButton but9=new JButton();
    private Buttons button9=new Buttons(but9, "5-2", panel4);

    private JButton but10=new JButton();
    private Buttons button10=new Buttons(but10, "5-3", panel4);

    private JButton but11=new JButton();
    private Buttons button11=new Buttons(but11, "6-1", panel4);

    private JButton but12=new JButton();
    private Buttons button12=new Buttons(but12, "6-2", panel4);


    public  ChooseClass() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1650, 880);
        setBackground(Color.LIGHT_GRAY);


        panel1.setBounds(0,0, 150, 1080);
        panel1.setBackground(Color.GREEN);

        panel2.setBounds(150,0, 200, 1080);
        panel2.setBackground(Color.WHITE);

        panel3.setBounds(440, 80 , 990, 630);
        panel3.setBackground(Color.WHITE);
        panel3.setLayout(new BorderLayout(50,50));

        panel4.setLayout(new GridLayout(3, 4, 80, 60));
        panel4.setBounds(20, 20 , 950, 500);
        panel4.setBackground(Color.WHITE);
        panel4.setBorder(new EmptyBorder(50, 50, 50, 50));




        label1.setText("  Choose Class");
        label1.setFont(new Font("Serif", Font.ROMAN_BASELINE, 50));
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
        but7.addActionListener(this);
        but7.setFocusable(false);
        but8.addActionListener(this);
        but8.setFocusable(false);
        but9.addActionListener(this);
        but9.setFocusable(false);
        but10.addActionListener(this);
        but10.setFocusable(false);
        but11.addActionListener(this);
        but11.setFocusable(false);
        but12.addActionListener(this);
        but12.setFocusable(false);


        add(panel1);
        add(panel2);
        add(panel3);
        panel3.add(panel4, BorderLayout.CENTER );
        panel3.add(label1, BorderLayout.NORTH);


        setVisible(true);
}
    class Buttons {

        public Buttons(JButton but, String cont, JPanel panel4) {
            but.setText(cont);
            but.setBackground(Color.LIGHT_GRAY);
            but.setFocusable(false);
            but.setFont(new Font("Serif", Font.ROMAN_BASELINE, 20));
            panel4.add(but);



        }


        public Buttons() {
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() ==but1) {
            setVisible(false);
            new ChooseSubject(1);
        }

        if (e.getSource() ==but2) {
            setVisible(false);
            new ChooseSubject( 2);
        }
        if (e.getSource() ==but3) {
            setVisible(false);
            new ChooseSubject(3);
        }
        if (e.getSource() ==but4) {
            setVisible(false);
            new ChooseSubject(4);
        }
        if (e.getSource() ==but5) {
            setVisible(false);
            new ChooseSubject(5);
        }
        if (e.getSource() ==but6) {
            setVisible(false);
            new ChooseSubject(6);
        }
        if (e.getSource() ==but7) {
            setVisible(false);
            new ChooseSubject(7);
        }
        if (e.getSource() ==but8) {
            setVisible(false);
            new ChooseSubject( 8);
        }
        if (e.getSource() ==but9) {
            setVisible(false);
            new ChooseSubject(9);
        }
        if (e.getSource() ==but10) {
            setVisible(false);
            new ChooseSubject(10);
        }
        if (e.getSource() ==but11) {
            setVisible(false);
            new ChooseSubject(11);
        }
        if (e.getSource() ==but12) {
            setVisible(false);
            new ChooseSubject( 12);
        }

//
//        if (e.getSource() ==but1) {
//            setVisible(false);
//            new ChooseSubject(but1.getText(), 1);
//        }
//
//        if (e.getSource() ==but2) {
//            setVisible(false);
//            new ChooseSubject(but2.getText(), 2);
//        }
//        if (e.getSource() ==but3) {
//            setVisible(false);
//            new ChooseSubject(but3.getText(), 3);
//        }
//        if (e.getSource() ==but4) {
//            setVisible(false);
//            new ChooseSubject(but4.getText(), 4);
//        }
//        if (e.getSource() ==but5) {
//            setVisible(false);
//            new ChooseSubject(but5.getText(), 5);
//        }
//        if (e.getSource() ==but6) {
//            setVisible(false);
//            new ChooseSubject(but6.getText(), 6);
//        }
//        if (e.getSource() ==but7) {
//            setVisible(false);
//            new ChooseSubject(but7.getText(), 7);
//        }
//        if (e.getSource() ==but8) {
//            setVisible(false);
//            new ChooseSubject(but8.getText(), 8);
//        }
//        if (e.getSource() ==but9) {
//            setVisible(false);
//            new ChooseSubject(but9.getText(), 9);
//        }
//        if (e.getSource() ==but10) {
//            setVisible(false);
//            new ChooseSubject(but10.getText(), 10);
//        }
//        if (e.getSource() ==but11) {
//            setVisible(false);
//            new ChooseSubject(but11.getText(), 11);
//        }
//        if (e.getSource() ==but12) {
//            setVisible(false);
//            new ChooseSubject(but12.getText(), 12);
//        }


}

    }



