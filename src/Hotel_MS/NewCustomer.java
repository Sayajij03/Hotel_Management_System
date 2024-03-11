package Hotel_MS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Stack;

public class NewCustomer extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField number,nameField,countryField,depositField;
    JRadioButton rm,rf;
    Choice c1;
    JLabel date;
    JButton add,back;
    NewCustomer(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(48,3,3));
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/customer.png"));
        Image image = imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel label1 = new JLabel("NEW CUSTOMER FORM");
        label1.setBounds(118,11,260,53);
        label1.setFont(new Font("Tahoma",Font.BOLD,20));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        JLabel govID = new JLabel("ID ");
        govID.setBounds(35,76,200,14);
        govID.setForeground(Color.WHITE);
        govID.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(govID);

        comboBox = new JComboBox(new String[]{"Passport","Aadhar Card","Voter ID","Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(new Color(48,3,3));
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);


        JLabel numb = new JLabel("Number");
        numb.setBounds(35,111,200,14);
        numb.setForeground(Color.WHITE);
        numb.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(numb);

        number=new JTextField();
        number.setBounds(271,111,150,20);
        number.setBackground(new Color(48,3,3));
        number.setForeground(Color.WHITE);
        panel.add(number);

        JLabel name = new JLabel("Name");
        name.setBounds(35,151,200,14);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);

        nameField=new JTextField();
        nameField.setBounds(271,151,150,20);
        nameField.setBackground(new Color(48,3,3));
        nameField.setForeground(Color.WHITE);
        panel.add(nameField);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(35,191,200,14);
        gender.setForeground(Color.WHITE);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);

        rm = new JRadioButton("Male");
        rm.setBounds(271,191,80,12);
        rm.setFont(new Font("Tahoma",Font.BOLD,14));
        rm.setBackground(new Color(48,3,3));
        rm.setForeground(Color.WHITE);
        panel.add(rm);

        rf = new JRadioButton("Female");
        rf.setBounds(350,191,80,12);
        rf.setFont(new Font("Tahoma",Font.BOLD,14));
        rf.setBackground(new Color(48,3,3));
        rf.setForeground(Color.WHITE);
        panel.add(rf);

        JLabel country = new JLabel("Country");
        country.setBounds(35,231,200,14);
        country.setForeground(Color.WHITE);
        country.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(country);

        countryField=new JTextField();
        countryField.setBounds(271,231,150,20);
        countryField.setBackground(new Color(48,3,3));
        countryField.setForeground(Color.WHITE);
        panel.add(countryField);

        JLabel room = new JLabel("Allocated Room Number");
        room.setBounds(35,274,200,14);
        room.setForeground(Color.WHITE);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);


        c1= new Choice();
        try{
           con c= new con();
            ResultSet resultSet=c.statement.executeQuery("select * from room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        c1.setBounds(271,274,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(48,3,3));
        panel.add(c1);

        JLabel cis = new JLabel("Checked In");
        cis.setBounds(35,316,200,14);
        cis.setForeground(Color.WHITE);
        cis.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(cis);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(271,316,200,14);
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(date);

        JLabel deposit = new JLabel("Deposit");
        deposit.setBounds(35,359,200,14);
        deposit.setForeground(Color.WHITE);
        deposit.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(deposit);

        depositField=new JTextField();
        depositField.setBounds(271,359,150,20);
        depositField.setBackground(new Color(48,3,3));
        depositField.setForeground(Color.WHITE);
        panel.add(depositField);

        add=new JButton("ADD");
        add.setBounds(100,430,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(this);
        panel.add(add);

        back=new JButton("BACK");
        back.setBounds(260,430,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        panel.add(back);

        setLocation(500,150);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==add){
            con c = new con();
            String radiobtn = null;
            if (rm.isSelected()){
                radiobtn = "Male";
            } else if (rf.isSelected()) {
                radiobtn = "Female";
            }

            String s1 = (String) comboBox.getSelectedItem();
            String s2 = number.getText();
            String s3 = nameField.getText();
            String s4 = radiobtn;
            String s5 = countryField.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = depositField.getText();

            try{
                String q = "insert into customer values('"+s1+"','"+s2+"','"+s3+"','"+s4+"','"+s5+"','"+s6+"','"+s7+"','"+s8+"')";
                String q1= "update room set availability = 'Occupied' where room_no="+s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);

                JOptionPane.showMessageDialog(null,"Added Successfully");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }

        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new NewCustomer();
    }
}
