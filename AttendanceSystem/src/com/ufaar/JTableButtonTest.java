package com.ufaar;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
public class JTableButtonTest extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;
    public JTableButtonTest() {
        setTitle("JTableButton Test");
        TableCellRenderer tableRenderer;
        table = new JTable(new JTableButtonModel());
        tableRenderer = table.getDefaultRenderer(JButton.class);
        table.setDefaultRenderer(JButton.class, new JTableButtonRenderer(tableRenderer));
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 300);
        setVisible(true);
    }
}
class JTableButtonRenderer implements TableCellRenderer {
    private TableCellRenderer defaultRenderer;
    public JTableButtonRenderer(TableCellRenderer renderer) {
        defaultRenderer = renderer;
    }
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(value instanceof Component)
            return (Component)value;
        return defaultRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
class JTableButtonModel extends AbstractTableModel {
    private Object[][] rows = {getRows(),{new JButton("Absent")},{ new JButton("Absent"), new JButton("Absent")},{ new JButton("Absent")}};
    private String[] columns = { "id",  "name", "surname", "class", "presence"};
    public String getColumnName(int column) {
        return columns[column];
    }


    public Object[][] getRows() {
        return rows;
    }

    public void setRows(Object[][] rows) {
        this.rows = rows;
    }

    public String[] getColumns() {
        return columns;
    }

    public void setColumns(String[] columns) {
        this.columns = columns;
    }

    public int getRowCount() {
        return rows.length;
    }
    public int getColumnCount() {
        return columns.length;
    }
    public Object getValueAt(int row, int column) {
        return rows[row][column];
    }
    public boolean isCellEditable(int row, int column) {
        return false;
    }
    public Class getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }
}