package com.ufaar;


    import javax.swing.*;
    import javax.swing.border.EmptyBorder;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

public class TickAbsents  extends JFrame implements ActionListener  {

    JFrame f;
    JTable j;
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JLabel label=new JLabel();
    private JLabel label1=new JLabel();
    private final ClassesDAO classDao = new ClassesDAO();
    private int classid;
    private String subject;

        TickAbsents(int classid, String subject)
        {
            this.classid=classid;
            this.subject=subject;
            f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setLayout(null);
            f.setSize(1650, 880);
            f.setBackground(Color.LIGHT_GRAY);

            panel1.setBounds(0,0, 150, 1080);
            panel1.setBackground(Color.GREEN);

            panel2.setBounds(150,0, 200, 1080);
            panel2.setBackground(Color.WHITE);

            panel3.setBounds(440, 80 , 990, 630);
            panel3.setLayout(new BorderLayout(50,50));

            var dao = new StudentClassDAO();
            Object[][] data = dao.getTableData(classid );
            int rows=data.length;
            //String[][] findata=new String[rows][5];
//            for (int i=0; i<rows; i++)
//                data[i][1]=new JButton("Absent");




            String[] columnNames = { "id",  "name", "surname", "class", "presence"};

            j = new JTable(data, columnNames);


            JScrollPane sp = new JScrollPane(j);
            sp.setBounds(560, 80 , 750, 630);
            j.setFont(new Font("Serif", Font.PLAIN, 20));
            j.setRowHeight(50);

            Classes classes = classDao.retrieveClassesById(classid);
            label.setText(classes.getClassnum()+", "+subject);
            label.setFont(new Font("Serif", Font.ROMAN_BASELINE, 45));


            //panel1.setBounds(560, 80 , 750, 630);
            //panel1.setBackground(Color.yellow);

            //f.add(panel1);
           // panel1.add(sp);
            f.add(panel1);
            f.add(panel2);
            f.add(panel3);
            panel3.add(sp, BorderLayout.CENTER);
            f.setVisible(true);

            panel3.add(label, BorderLayout.NORTH);
        }
        public TickAbsents(){

        }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // Driver  method


}
