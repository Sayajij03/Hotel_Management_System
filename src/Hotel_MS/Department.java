package Hotel_MS;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department extends JFrame {
    Department(){

        JPanel panel = new JPanel();
        panel.setBackground(new Color(48,3,3));
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(0,40,700,350);
        table.setBackground(new Color(48,3,3));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            con c = new con();
            String DeptInfo = "select * from department";
            ResultSet resultSet = c.statement.executeQuery(DeptInfo);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception E){
            E.printStackTrace();
        }

        JButton back = new JButton("BACK");
        back.setBounds(400,410,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JLabel label = new JLabel("Department");
        label.setBounds(145,11,105,20);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);

        JLabel label1 = new JLabel("Budget");
        label1.setBounds(431,11,105,20);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        setUndecorated(true);
        setLocation(550,150);
        setLayout(null);
        setSize(700,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Department();
    }
}
