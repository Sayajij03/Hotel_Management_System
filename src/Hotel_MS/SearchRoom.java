package Hotel_MS;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom extends JFrame implements ActionListener {

    JCheckBox checkBox;
    Choice choice;
    JTable table;
    JButton b1,b2;
    SearchRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(48,3,3));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Search For Room");
        label.setBounds(250,11,186,31);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(label);

        JLabel label1 = new JLabel("Room Bed Type");
        label1.setBounds(50,73,120,20);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2 = new JLabel("Room Number");
        label2.setBounds(23,162,150,20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3 = new JLabel("Availability");
        label3.setBounds(175,162,150,20);
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4 = new JLabel("Status");
        label4.setBounds(306,162,120,20);
        label4.setForeground(Color.WHITE);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5 = new JLabel("Price");
        label5.setBounds(458,162,150,20);
        label5.setForeground(Color.WHITE);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6 = new JLabel("Bed Type");
        label6.setBounds(580,162,150,20);
        label6.setForeground(Color.WHITE);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        checkBox =new JCheckBox("Only Display Available");
        checkBox.setBounds(400,69,205,23);
        checkBox.setForeground(Color.WHITE);
        checkBox.setBackground(new Color(48,3,3));
        panel.add(checkBox);

        choice = new Choice();
        choice.add("Single Bed");
        choice.add("Double Bed");
        choice.setBounds(170,70,120,20);
        choice.setBackground(new Color(48,3,3));
        choice.setForeground(Color.WHITE);
        panel.add(choice);

        table = new JTable();
        table.setBounds(0,187,700,150);
        table.setBackground(new Color(48,3,3));
        table.setForeground(Color.WHITE);
        panel.add(table);

        try{
           con c = new con();
           String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
           table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception E){
            E.printStackTrace();
        }

        b1=new JButton("SEARCH");
        b1.setBounds(200,420,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(380,420,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);


        setUndecorated(true);
        setLocation(500,200);
        setLayout(null);
        setSize(700,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String q ="select * from room where bed_type='"+choice.getSelectedItem()+"'";
            String q1 ="select * from room where availability='Available' and bed_type='"+choice.getSelectedItem()+"'";
            try{
               con c =new con();
               ResultSet resultSet = c.statement.executeQuery(q);
               table.setModel(DbUtils.resultSetToTableModel(resultSet));

               if(checkBox.isSelected()){
                   ResultSet resultSet1 =c.statement.executeQuery(q1);
                   table.setModel(DbUtils.resultSetToTableModel(resultSet1));
               }

            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new SearchRoom();
    }
}
