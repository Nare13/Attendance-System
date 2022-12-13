//package com.ufaar;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.sql.Date;
//
//public class StudentEdit extends JFrame implements ActionListener {
//
//        private JLabel idLabel = new JLabel("Id");
//        private JLabel nameLabel = new JLabel("Name");
//        private JLabel surnameLabel = new JLabel("Surname");
//        private JLabel bdLabel = new JLabel("Birthday");
//        private JTextField id = new JTextField(12);
//        private JTextField name = new JTextField(12);
//        private JTextField surname = new JTextField(12);
//        private JTextField birthdate = new JTextField(12);
//        private JButton insertInto = new JButton("UPDATE");
//        private JButton retrieveInfo = new JButton("RETRIEVE");
//        private final AuthorDAO authorDao = new AuthorDAO();
//
//        public StudentEdit() throws HeadlessException {
//            setLayout(new FlowLayout());
//            add(idLabel);
//            add(id);
//            add(nameLabel);
//            add(name);
//            add(surnameLabel);
//            add(surname);
//            add(bdLabel);
//            add(birthdate);
//
//            retrieveInfo.addActionListener(this);
//            add(retrieveInfo);
//
//            insertInto.addActionListener(this);
//            add(insertInto);
//
//            setSize(600, 500);
//            setVisible(true);
//        }
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            final var source = e.getSource();
//            if (source == insertInto) {
//                try {
//                    Author author = new Author();
//                    author.setAuthorid(Integer.parseInt(id.getText()));
//                    author.setName(name.getText());
//                    author.setSurname(surname.getText());
//                    author.setBirthdateStringImpl(birthdate.getText());
//                    authorDao.updateAuthorRow(author);
//                    setVisible(false);
//                    new MainWindow().setVisible(true);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                }
//            } else if (source == retrieveInfo) {
//                Author author = authorDao.retrieveAuthorById(Integer.parseInt(id.getText()));
//                name.setText(author.getName());
//                surname.setText(author.getSurname());
//                birthdate.setText(author.getBirthdateStringImpl());
//            }
//        }
//
//}
