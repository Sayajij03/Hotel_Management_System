package Hotel_MS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateRoom extends JFrame {
    UpdateRoom(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(48,3,3));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/update.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Room Status");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel label2 = new JLabel("ID");
        label2.setBounds(25,88,46,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        Choice c = new Choice();
        c.setBounds(248,85,140,20);
        c.setBackground(new Color(48,3,3));
        c.setForeground(Color.WHITE);
        panel.add(c);

        try{
            con co = new con();
            ResultSet resultSet = co.statement.executeQuery("select * from customer");
            while (resultSet.next()){
                c.add(resultSet.getString("number"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(25,129,107,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        JTextField textField = new JTextField();
        textField.setBounds(248,129,140,20);
        textField.setBackground(new Color(48,3,3));
        textField.setForeground(Color.WHITE);
        panel.add(textField);

        JLabel label4 = new JLabel("Availability");
        label4.setBounds(25,174,97,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField1 = new JTextField();
        textField1.setBounds(248,174,140,20);
        textField1.setBackground(new Color(48,3,3));
        textField1.setForeground(Color.WHITE);
        panel.add(textField1);

        JLabel label5 = new JLabel("Cleaning Status");
        label5.setBounds(25,216,150,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField2 = new JTextField();
        textField2.setBounds(248,216,140,20);
        textField2.setBackground(new Color(48,3,3));
        textField2.setForeground(Color.WHITE);
        panel.add(textField2);



        JButton update = new JButton("UPDATE");
        update.setBounds(120,315,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con co = new con();
                    String status = textField2.getText();
                    co.statement.executeUpdate("update room set cleaning_status = '"+status+"' where room_no = "+ textField.getText());
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(180,355,89,23);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JButton check = new JButton("CHECK");
        check.setBounds(60,355,89,23);
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = c.getSelectedItem();
                String q = "select * from customer where number = '"+id+"'";
                try{
                    con c = new con();
                    ResultSet resultSet = c.statement.executeQuery(q);

                    while (resultSet.next()){
                        textField.setText(resultSet.getString("room"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no='"+textField.getText()+"'");
                    while(resultSet1.next()){
                        textField1.setText(resultSet1.getString("availability"));
                        textField2.setText(resultSet1.getString("cleaning_status"));
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        setLocation(400,200);
        setLayout(null);
        setSize(950,450);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateRoom();
    }
}
