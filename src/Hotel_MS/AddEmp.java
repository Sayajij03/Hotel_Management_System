package Hotel_MS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmp extends JFrame implements ActionListener {

    JTextField nameText, ageText, salaryText, phoneText, aadharText, emailText;

    JRadioButton radioButtonM,radioButtonF;

    JComboBox comboBox;

    JButton b1,b2;
    AddEmp(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(48,3,3));
        add(panel);

        JLabel labe = new JLabel("ADD EMPLOYEE DETAILS");
        labe.setBounds(450,24,445,35);
        labe.setFont(new Font("Tahoma",Font.BOLD,31));
        labe.setForeground(Color.WHITE);
        panel.add(labe);

        JLabel label = new JLabel("NAME");
        label.setBounds(60,30,150,27);
        label.setFont(new Font("Serif",Font.BOLD,17));
        label.setForeground(Color.WHITE);
        panel.add(label);

        nameText = new JTextField();
        nameText.setBounds(200,30,150,27);
        nameText.setBackground(new Color(152, 80, 80));
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        nameText.setForeground(Color.WHITE);
        panel.add(nameText);

        JLabel label1 = new JLabel("AGE");
        label1.setBounds(60,80,150,27);
        label1.setFont(new Font("Serif",Font.BOLD,17));
        label1.setForeground(Color.WHITE);
        panel.add(label1);

        ageText = new JTextField();
        ageText.setBounds(200,80,150,27);
        ageText.setBackground(new Color(152, 80, 80));
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        ageText.setForeground(Color.WHITE);
        panel.add(ageText);

        JLabel label2 = new JLabel("GENDER");
        label2.setBounds(60,120,150,27);
        label2.setFont(new Font("Serif",Font.BOLD,17));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        radioButtonM = new JRadioButton("MALE");
        radioButtonM.setBounds(200,120,70,27);
        radioButtonM.setBackground(new Color(48,3,3));
        radioButtonM.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonM.setForeground(Color.WHITE);
        panel.add(radioButtonM);

        radioButtonF = new JRadioButton("FEMALE");
        radioButtonF.setBounds(280,120,100,27);
        radioButtonF.setBackground(new Color(48,3,3));
        radioButtonF.setFont(new Font("Tahoma",Font.BOLD,14));
        radioButtonF.setForeground(Color.WHITE);
        panel.add(radioButtonF);

        JLabel label3 = new JLabel("JOB");
        label3.setBounds(60,170,150,27);
        label3.setFont(new Font("Serif",Font.BOLD,17));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        comboBox = new JComboBox(new String[]{"Front Desk","Housekeeping","Kitchen Staff","Room Service","Manager","Chef"});
        comboBox.setBackground(new Color(152,80,80));
        comboBox.setBounds(200,170,150,30);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox.setForeground(Color.WHITE);
        panel.add(comboBox);

        JLabel label4 = new JLabel("SALARY");
        label4.setBounds(60,220,150,27);
        label4.setFont(new Font("Serif",Font.BOLD,17));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        salaryText = new JTextField();
        salaryText.setBounds(200,220,150,27);
        salaryText.setBackground(new Color(152, 80, 80));
        salaryText.setFont(new Font("Tahoma",Font.BOLD,14));
        salaryText.setForeground(Color.WHITE);
        panel.add(salaryText);

        JLabel label5 = new JLabel("PHONE");
        label5.setBounds(60,270,150,27);
        label5.setFont(new Font("Serif",Font.BOLD,17));
        label5.setForeground(Color.WHITE);
        panel.add(label5);

        phoneText = new JTextField();
        phoneText.setBounds(200,270,150,27);
        phoneText.setBackground(new Color(152, 80, 80));
        phoneText.setFont(new Font("Tahoma",Font.BOLD,14));
        phoneText.setForeground(Color.WHITE);
        panel.add(phoneText);

        JLabel label6 = new JLabel("AADHAR");
        label6.setBounds(60,320,150,27);
        label6.setFont(new Font("Serif",Font.BOLD,17));
        label6.setForeground(Color.WHITE);
        panel.add(label6);

        aadharText = new JTextField();
        aadharText.setBounds(200,320,150,27);
        aadharText.setBackground(new Color(152, 80, 80));
        aadharText.setFont(new Font("Tahoma",Font.BOLD,14));
        aadharText.setForeground(Color.WHITE);
        panel.add(aadharText);


        JLabel label7 = new JLabel("EMAIL");
        label7.setBounds(60,370,150,27);
        label7.setFont(new Font("Serif",Font.BOLD,17));
        label7.setForeground(Color.WHITE);
        panel.add(label7);

        emailText = new JTextField();
        emailText.setBounds(200,370,150,27);
        emailText.setBackground(new Color(152, 80, 80));
        emailText.setFont(new Font("Tahoma",Font.BOLD,14));
        emailText.setForeground(Color.WHITE);
        panel.add(emailText);

        b1=new JButton("ADD");
        b1.setBounds(80,420,100,30);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(200,420,100,30);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/addemp.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel i = new JLabel(imageIcon1);
        i.setBounds(500,100,300,300);
        panel.add(i);
        
        setUndecorated(true);
        setLocation(60,160);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String name = nameText.getText();
            String age = ageText.getText();
            String salary = salaryText.getText();
            String phone = phoneText.getText();
            String email = emailText.getText();
            String aadhar = aadharText.getText();

            String job = (String) comboBox.getSelectedItem();
            String gender = null;
            if(radioButtonM.isSelected()){
                gender = "Male";
            } else if (radioButtonF.isSelected()) {
                gender = "Female";
            }


            try{
               con c = new con();
               String q = "insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
               c.statement.executeUpdate(q);

               JOptionPane.showMessageDialog(null,"Employee Added");
               setVisible(false);

            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddEmp();
    }
}
