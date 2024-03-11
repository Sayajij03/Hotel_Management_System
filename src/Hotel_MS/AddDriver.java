package Hotel_MS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDriver extends JFrame implements ActionListener {

    JTextField nameText, ageText,carComp, carName;

    JComboBox comboBox,comboBox1;

    JButton b1,b2;
    AddDriver(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,890,490);
        panel.setBackground(new Color(48,3,3));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("ADD DRIVERS");
        label.setBounds(194,10,200,22);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Tahoma",Font.BOLD,22));
        panel.add(label);

        JLabel name = new JLabel("NAME");
        name.setBounds(64,70,102,22);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.WHITE);
        panel.add(name);

        nameText = new JTextField();
        nameText.setBounds(174,70,156,20);
        nameText.setForeground(Color.WHITE);
        nameText.setFont(new Font("Tahoma",Font.BOLD,14));
        nameText.setBackground(new Color(152,80,80));
        panel.add(nameText);

        JLabel age = new JLabel("AGE");
        age.setBounds(64,110,102,22);
        age.setFont(new Font("Tahoma",Font.BOLD,14));
        age.setForeground(Color.WHITE);
        panel.add(age);

        ageText = new JTextField();
        ageText.setBounds(174,110,156,20);
        ageText.setBackground(new Color(152, 80, 80));
        ageText.setFont(new Font("Tahoma",Font.BOLD,14));
        ageText.setForeground(Color.WHITE);
        panel.add(ageText);

        JLabel label2 = new JLabel("GENDER");
        label2.setBounds(64,150,102,22);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        label2.setForeground(Color.WHITE);
        panel.add(label2);

        comboBox = new JComboBox(new String[]{"Male","Female"});
        comboBox.setBounds(174,150,156,20);
        comboBox.setForeground(Color.WHITE);
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox.setBackground(new Color(152,80,80));
        panel.add(comboBox);

        JLabel label3 = new JLabel("CAR COMPANY");
        label3.setBounds(64,190,110,22);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setForeground(Color.WHITE);
        panel.add(label3);

        carComp = new JTextField();
        carComp.setBounds(174,190,156,20);
        carComp.setBackground(new Color(152, 80, 80));
        carComp.setFont(new Font("Tahoma",Font.BOLD,14));
        carComp.setForeground(Color.WHITE);
        panel.add(carComp);

        JLabel label4 = new JLabel("CAR NAME");
        label4.setBounds(64,230,102,22);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        label4.setForeground(Color.WHITE);
        panel.add(label4);

        carName = new JTextField();
        carName.setBounds(174,230,156,20);
        carName.setBackground(new Color(152, 80, 80));
        carName.setFont(new Font("Tahoma",Font.BOLD,14));
        carName.setForeground(Color.WHITE);
        panel.add(carName);
        
        JLabel label5 = new JLabel("AVAILABLE");
        label5.setBounds(64,270,102,22);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        label5.setForeground(Color.WHITE);
        panel.add(label5);
        
        comboBox1 = new JComboBox(new String[]{"Yes","No"});
        comboBox1.setBounds(174,270,156,20);
        comboBox1.setBackground(new Color(152,80,80));
        comboBox1.setFont(new Font("Tahoma",Font.BOLD,14));
        comboBox1.setForeground(Color.WHITE);
        panel.add(comboBox1);

        b1=new JButton("ADD");
        b1.setBounds(64,380,111,33);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        panel.add(b1);

        b2=new JButton("BACK");
        b2.setBounds(198,380,111,33);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        panel.add(b2);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/driver.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel i = new JLabel(imageIcon1);
        i.setBounds(500,60,300,300);
        panel.add(i);


        setLocation(20,200);
        setLayout(null);
        setSize(900,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==b1){
            String name = nameText.getText();
            String age = ageText.getText();
            String gender = (String) comboBox.getSelectedItem();
            String company = carComp.getText();
            String carname = carName.getText();
            String available = (String) comboBox1.getSelectedItem();
            try{
                con c = new con();
                String q = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+carname+"','"+available+"')";
                c.statement.executeUpdate(q);

                JOptionPane.showMessageDialog(null,"Driver Added");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
