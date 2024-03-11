package Hotel_MS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CheckOut extends JFrame {
    CheckOut(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(48,3,3));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Check Out");
        label.setBounds(100,20,150,30);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label1 = new JLabel("Customer ID");
        label1.setBounds(30,80,100,30);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        Choice customer = new Choice();
        customer.setBounds(200,80,150,25);
        customer.setBackground(new Color(48,3,3));
        customer.setForeground(Color.WHITE);
        panel.add(customer);

        JLabel labelroomno = new JLabel("Room Number");
        labelroomno.setBounds(30,130,200,30);
        labelroomno.setFont(new Font("Tahoma",Font.BOLD,14));
        labelroomno.setForeground(Color.WHITE);
        panel.add(labelroomno);

        JLabel label3 = new JLabel("");
        label3.setBounds(200,130,100,30);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JLabel labelcheckin = new JLabel("Check In Time");
        labelcheckin.setBounds(30,180,200,30);
        labelcheckin.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckin.setForeground(Color.WHITE);
        panel.add(labelcheckin);

        JLabel label4= new JLabel("");
        label4.setBounds(200,180,200,30);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JLabel labelcheckout = new JLabel("Check Out Time");
        labelcheckout.setBounds(30,230,200,30);
        labelcheckout.setFont(new Font("Tahoma",Font.BOLD,14));
        labelcheckout.setForeground(Color.WHITE);
        panel.add(labelcheckout);

        Date date = new Date();

        JLabel label6 = new JLabel(""+date);
        label6.setBounds(200,230,200,30);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        try{
           con c = new con();
            ResultSet resultSet = c.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                customer.add(resultSet.getString("number"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }

        JButton checkout = new JButton("Check-Out");
        checkout.setBounds(30,300,120,30);
        checkout.setForeground(Color.WHITE);
        checkout.setBackground(Color.BLACK);
        panel.add(checkout);
        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   con c = new con();
                   c.statement.executeUpdate("delete from customer where number='"+customer.getSelectedItem()+"'");
                   c.statement.executeUpdate("update room set availability='Available' where room_no='"+label3.getText()+"'");
                   JOptionPane.showMessageDialog(null,"Done");
                   setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton check = new JButton("Check");
        check.setBounds(300,300,120,30);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                con c = new con();
                try {
                    ResultSet resultSet =c.statement.executeQuery("select * from customer where number = '"+customer.getSelectedItem()+"'");
                    while (resultSet.next()){
                        label3.setText(resultSet.getString("room"));
                        label4.setText(resultSet.getString("checkin"));

                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(170,300,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setLayout(null);
        setLocation(500,210);
        setSize(800,400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
