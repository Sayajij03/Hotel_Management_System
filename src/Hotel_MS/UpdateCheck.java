package Hotel_MS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateCheck extends JFrame {
    UpdateCheck(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(48,3,3));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Check In Details");
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

        JLabel label4 = new JLabel("Name");
        label4.setBounds(25,174,97,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        JTextField textField1 = new JTextField();
        textField1.setBounds(248,174,140,20);
        textField1.setBackground(new Color(48,3,3));
        textField1.setForeground(Color.WHITE);
        panel.add(textField1);

        JLabel label5 = new JLabel("Checked In");
        label5.setBounds(25,216,97,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        JTextField textField2 = new JTextField();
        textField2.setBounds(248,216,140,20);
        textField2.setBackground(new Color(48,3,3));
        textField2.setForeground(Color.WHITE);
        panel.add(textField2);

        JLabel label6 = new JLabel("Amount Paid");
        label6.setBounds(25,261,97,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        JTextField textField3 = new JTextField();
        textField3.setBounds(248,261,140,20);
        textField3.setBackground(new Color(48,3,3));
        textField3.setForeground(Color.WHITE);
        panel.add(textField3);

        JLabel label7 = new JLabel("Pending Amount");
        label7.setBounds(25,302,150,14);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        JTextField textField4 = new JTextField();
        textField4.setBounds(248,302,140,20);
        textField4.setBackground(new Color(48,3,3));
        textField4.setForeground(Color.WHITE);
        panel.add(textField4);

        JButton update = new JButton("UPDATE");
        update.setBounds(56,378,89,23);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        panel.add(update);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    con co = new con();
                    String q = c.getSelectedItem();
                    String room = textField.getText();
                    String name = textField1.getText();
                    String check = textField2.getText();
                    String amt = textField3.getText();

                    co.statement.executeUpdate("update customer set room ='"+room+"',name = '"+name+"',checkin = '"+check+"',deposit = '"+amt+"' where number = '"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    setVisible(false);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("BACK");
        back.setBounds(168,378,89,23);
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
        check.setBounds(281,378,89,23);
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
                        textField1.setText(resultSet.getString("name"));
                        textField2.setText(resultSet.getString("checkin"));
                        textField3.setText(resultSet.getString("deposit"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no='"+textField.getText()+"'");
                    while(resultSet1.next()){
                        String price = resultSet1.getString("price");
                        int amtpaid = Integer.parseInt(price) - Integer.parseInt(textField3.getText());
                        textField4.setText(""+amtpaid);
                    }

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        setLocation(400,200);
        setLayout(null);
        setSize(950,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
