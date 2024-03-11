package Hotel_MS;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.module.ResolutionException;
import java.sql.ResultSet;

public class CustomerInfo extends JFrame {
    CustomerInfo(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(48,3,3));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10,40,900,450);
        table.setBackground(new Color(48,3,3));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
            con c = new con();
            String q = "select * from customer";
            ResultSet resultset = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultset));

        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel label = new JLabel("ID");
        label.setBounds(31,11,100,14);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);

        JLabel label1= new JLabel("Number");
        label1.setBounds(150,11,100,14);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Name");
        label2.setBounds(270,11,100,14);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Gender");
        label3.setBounds(360,11,100,14);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Country");
        label4.setBounds(480,11,100,16);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Room");
        label5.setBounds(600,11,100,14);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label7 = new JLabel("Time");
        label7.setBounds(680,11,100,14);
        label7.setForeground(Color.WHITE);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);

        JLabel label6 = new JLabel("Deposit");
        label6.setBounds(800,11,100,16);
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JButton b1 = new JButton("BACK");
        b1.setBounds(450,510,120,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        panel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setLocation(500,100);
        setLayout(null);
        setSize(900,600);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CustomerInfo();
    }

}
