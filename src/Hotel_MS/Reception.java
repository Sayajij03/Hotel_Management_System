package Hotel_MS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception extends JFrame {
    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(280,5,1238,820);
        panel.setBackground(new Color(48, 3, 3));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,5,270,820);
        panel1.setBackground(new Color(48,3,3));
        add(panel1);

//        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/HOTEL.gif"));
//        Image image = imageIcon.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
//        ImageIcon imageIcon1 = new ImageIcon(image);
//        JLabel label = new JLabel(imageIcon1);
//        label.setBounds(300,20,800,800);
//        panel.add(label);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/logo.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(10,530,250,250);
        panel1.add(label);

        JButton btnNCF = new JButton("New Customer Form");
        btnNCF.setBounds(30,30,200,35);
        btnNCF.setForeground(Color.WHITE);
        btnNCF.setBackground(Color.BLACK);
        panel1.add(btnNCF);
        btnNCF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new NewCustomer();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnRoom = new JButton("Room");
        btnRoom.setBounds(30,70,200,35);
        btnRoom.setForeground(Color.WHITE);
        btnRoom.setBackground(Color.BLACK);
        panel1.add(btnRoom);
        btnRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Room();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnDep = new JButton("Department");
        btnDep.setBounds(30,110,200,35);
        btnDep.setForeground(Color.WHITE);
        btnDep.setBackground(Color.BLACK);
        panel1.add(btnDep);
        btnDep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Department();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnAEI = new JButton("All Employee Info");
        btnAEI.setBounds(30,150,200,35);
        btnAEI.setForeground(Color.WHITE);
        btnAEI.setBackground(Color.BLACK);
        panel1.add(btnAEI);
        btnAEI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new AED();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnCI = new JButton("Customer Info");
        btnCI.setBounds(30,190,200,35);
        btnCI.setForeground(Color.WHITE);
        btnCI.setBackground(Color.BLACK);
        panel1.add(btnCI);
        btnCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CustomerInfo();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnMI = new JButton("Manager Info");
        btnMI.setBounds(30,230,200,35);
        btnMI.setForeground(Color.WHITE);
        btnMI.setBackground(Color.BLACK);
        panel1.add(btnMI);
        btnMI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new Manager();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnCo = new JButton("Check Out");
        btnCo.setBounds(30,270,200,35);
        btnCo.setForeground(Color.WHITE);
        btnCo.setBackground(Color.BLACK);
        panel1.add(btnCo);
        btnCo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new CheckOut();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnUCI = new JButton("Update Check In");
        btnUCI.setBounds(30,310,200,35);
        btnUCI.setForeground(Color.WHITE);
        btnUCI.setBackground(Color.BLACK);
        panel1.add(btnUCI);
        btnUCI.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateCheck();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnUR = new JButton("Update Room Status");
        btnUR.setBounds(30,350,200,35);
        btnUR.setForeground(Color.WHITE);
        btnUR.setBackground(Color.BLACK);
        panel1.add(btnUR);
        btnUR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new UpdateRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnPS = new JButton("Pick Up Service");
        btnPS.setBounds(30,390,200,35);
        btnPS.setForeground(Color.WHITE);
        btnPS.setBackground(Color.BLACK);
        panel1.add(btnPS);
        btnPS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton btnSR = new JButton("Search Rooms");
        btnSR.setBounds(30,430,200,35);
        btnSR.setForeground(Color.WHITE);
        btnSR.setBackground(Color.BLACK);
        panel1.add(btnSR);
        btnSR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    new SearchRoom();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton logout = new JButton("Logout");
        logout.setBounds(30,470,95,35);
        logout.setForeground(Color.WHITE);
        logout.setBackground(Color.BLACK);
        panel1.add(logout);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    System.exit(401);
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(140,470,95,35);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel1.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    setVisible(false);
                    new Dashboard();
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        getContentPane().setBackground(Color.BLACK.WHITE);
        setLayout(null);
        setSize(1950,1090);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Reception();
    }
}
