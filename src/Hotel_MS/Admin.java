package Hotel_MS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin extends JFrame implements ActionListener {

    JButton AddEmp,AddRoom,AddDriver,logout,back;
    Admin(){

        AddEmp = new JButton("ADD EMPLOYEE");
        AddEmp.setBounds(250,230,200,30);
        AddEmp.setBackground(Color.BLACK);
        AddEmp.setForeground(Color.WHITE);
        AddEmp.setFont(new Font("Tahoma",Font.BOLD,15));
        AddEmp.addActionListener(this);
        add(AddEmp);

        AddRoom = new JButton("ADD ROOM");
        AddRoom.setBounds(250,380,200,30);
        AddRoom.setBackground(Color.BLACK);
        AddRoom.setForeground(Color.WHITE);
        AddRoom.setFont(new Font("Tahoma",Font.BOLD,15));
        AddRoom.addActionListener(this);
        add(AddRoom);

        AddDriver = new JButton("ADD DRIVER");
        AddDriver.setBounds(250,530,200,30);
        AddDriver.setBackground(Color.BLACK);
        AddDriver.setForeground(Color.WHITE);
        AddDriver.setFont(new Font("Tahoma",Font.BOLD,15));
        AddDriver.addActionListener(this);
        add(AddDriver);

        logout = new JButton("LOGOUT");
        logout.setBounds(10,800,100,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.WHITE);
        logout.setFont(new Font("Tahoma",Font.BOLD,15));
        logout.addActionListener(this);
        add(logout);

        back = new JButton("BACK");
        back.setBounds(110, 800,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.BOLD,15));
        back.addActionListener(this);
        add(back);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/employees.png"));
        Image image = imageIcon.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(70,180,120,120);
        add(label);

        ImageIcon imageIconR = new ImageIcon(ClassLoader.getSystemResource("Icon/room.png"));
        Image imageR = imageIconR.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIconRR = new ImageIcon(imageR);
        JLabel labelR = new JLabel(imageIconRR);
        labelR.setBounds(70,340,120,120);
        add(labelR);

        ImageIcon imageIconD = new ImageIcon(ClassLoader.getSystemResource("Icon/driver.png"));
        Image imageD = imageIconD.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
        ImageIcon imageIconDD = new ImageIcon(imageD);
        JLabel labelD = new JLabel(imageIconDD);
        labelD.setBounds(70,500,120,120);
        add(labelD);

        ImageIcon imageIconL = new ImageIcon(ClassLoader.getSystemResource("Icon/logo.jpg"));
        Image imageL = imageIconL.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1L = new ImageIcon(imageL);
        JLabel labelL = new JLabel(imageIcon1L);
        labelL.setBounds(1000,220,400,400);
        add(labelL);

        getContentPane().setBackground(new Color(48,3,3));
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==AddEmp){
            new AddEmp();
        } else if (e.getSource()==AddRoom) {
            new AddRoom();
        } else if (e.getSource()==AddDriver) {
            new AddDriver();
        }else if (e.getSource()==logout){
            System.exit(401);
        } else if(e.getSource()==back){
            new Dashboard();
            setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Admin();
    }
}
