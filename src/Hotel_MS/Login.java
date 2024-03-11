package Hotel_MS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class Login extends JFrame implements ActionListener {

    JTextField un;
    JPasswordField ps;

    JButton b1,b2;
    Login(){
        JLabel username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        username.setFont(new Font("Tahoma",Font.BOLD,16));
        username.setForeground(Color.WHITE);
        add(username);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Tahoma",Font.BOLD,16));
        password.setForeground(Color.WHITE);
        add(password);

        un = new JTextField();
        un.setBounds(150,20,150,30);
        un.setForeground(Color.WHITE);
        un.setFont(new Font("Viner Head ITC",Font.PLAIN,15));
        un.setBackground(new Color(26,104,110));
        add(un);

        ps = new JPasswordField();
        ps.setBounds(150,70,150,30);
        ps.setForeground(Color.WHITE);
        ps.setBackground(new Color(26,104,110));
        add(ps);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/logo.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(255,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(318,-30,255,300);
        add(label);

        b1=new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setFont(new Font("Serif",Font.BOLD,15));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.addActionListener(this);
        add(b1);

        b2=new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setFont(new Font("Serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);



        getContentPane().setBackground(new Color(48, 3, 3));


        setUndecorated(true);
        setLayout(null);
        setLocation(400,270);
        setSize(600,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b1){
            try{
               con c = new con();
               String user = un.getText();
               String pass = ps.getText();

               String q = "select * from login where username='"+user+"' and password='"+pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);
                if(resultSet.next()){
                    new Dashboard();
                    setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid");
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else{
            System.exit(401);
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
