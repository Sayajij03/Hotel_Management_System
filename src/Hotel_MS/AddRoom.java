package Hotel_MS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AddRoom extends JFrame implements ActionListener {

    JTextField t1, t3 ;

    JComboBox t2, t4, t5;

    JButton b1,b2;
    AddRoom(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,875,490);
        panel.setBackground(new Color(48,3,3));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("Add Rooms");
        label.setBounds(194,10,160,22);
        label.setFont(new Font("Tahoma",Font.BOLD,22));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label1 = new JLabel("Room Number");
        label1.setBounds(64,70,152,22);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        t1=new JTextField();
        t1.setBounds(200,70,156,22);
        t1.setFont(new Font("Tahoma",Font.PLAIN,14));
        t1.setForeground(Color.WHITE);
        t1.setBackground(new Color(152, 80, 80));
        panel.add(t1);

        JLabel label2 = new JLabel("Availability");
        label2.setBounds(64,110,152,22);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        t2 =new JComboBox(new String[]{"Available","Occupied"});
        t2.setBounds(200,110,156,22);
        t2.setFont(new Font("Tahoma",Font.PLAIN,14));
        t2.setForeground(Color.WHITE);
        t2.setBackground(new Color(152, 80, 80));
        panel.add(t2);

        JLabel label3 = new JLabel("Price");
        label3.setBounds(64,150,152,22);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        t3=new JTextField();
        t3.setBounds(200,150,156,22);
        t3.setFont(new Font("Tahoma",Font.PLAIN,14));
        t3.setForeground(Color.WHITE);
        t3.setBackground(new Color(152, 80, 80));
        panel.add(t3);

        JLabel label4 = new JLabel("Cleaning Status");
        label4.setBounds(64,190,152,22);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        t4=new JComboBox(new String[]{"Cleaned","Dirty"});
        t4.setBounds(200,190,156,22);
        t4.setFont(new Font("Tahoma",Font.PLAIN,14));
        t4.setForeground(Color.WHITE);
        t4.setBackground(new Color(152, 80, 80));
        panel.add(t4);

        JLabel label5 = new JLabel("Bed Type");
        label5.setBounds(64,230,152,22);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        t5=new JComboBox(new String[]{"Single Bed","Double Bed"});
        t5.setBounds(200,230,156,22);
        t5.setFont(new Font("Tahoma",Font.PLAIN,14));
        t5.setForeground(Color.WHITE);
        t5.setBackground(new Color(152, 80, 80));
        panel.add(t5);

        b1= new JButton("ADD");
        b1.setBounds(64,321,111,33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2= new JButton("BACK");
        b2.setBounds(198,321,111,33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);


        ImageIcon imageIcon= new ImageIcon(ClassLoader.getSystemResource("Icon/roomser.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label6 = new JLabel(imageIcon1);
        label6.setBounds(500,60,300,300);
        panel.add(label6);


        setUndecorated(true);
        setLocation(20,200);
        setLayout(null);
        setSize(885,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            try{
                con c = new con();
                String room = t1.getText();
                String ava = (String) t2.getSelectedItem();
                String status = (String) t4.getSelectedItem();
                String price = t3.getText();
                String bedtype = (String) t5.getSelectedItem();

                String q = "insert into room values ('"+room+"','"+ava+"','"+status+"','"+price+"','"+bedtype+"')";
                c.statement.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Room Added");
                setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }

        }else {
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
