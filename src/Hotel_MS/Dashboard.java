package Hotel_MS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {

    JButton adm,rec;
    Dashboard(){

        super("HOTEL MANAGEMENT SYSTEM");

        rec= new JButton("RECEPTION");
        rec.setBounds(425,510,140,30);
        rec.setFont(new Font("Tahoma",Font.BOLD,15));
        rec.setBackground(new Color(255,98,0));
        rec.setForeground(Color.WHITE);
        rec.addActionListener(this);
        add(rec);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("Icon/Reception.png"));
        Image img2 = i2.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(img2);
        JLabel label = new JLabel(i22);
        label.setBounds(400,300,200,195);
        add(label);

        adm= new JButton("ADMIN");
        adm.setBounds(880,510,140,30);
        adm.setFont(new Font("Tahoma",Font.BOLD,15));
        adm.setBackground(new Color(255,98,0));
        adm.setForeground(Color.WHITE);
        adm.addActionListener(this);
        add(adm);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icon/admin.png"));
        Image img = i1.getImage().getScaledInstance(200,195,Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(img);
        JLabel label1 = new JLabel(i11);
        label1.setBounds(850,300,200,195);
        add(label1);



        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/Dashboard.gif"));
        Image image = imageIcon.getImage().getScaledInstance(1950,1090,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label2 = new JLabel(imageIcon1);
        label2.setBounds(0,0,1950,1090);
        add(label2);



        setLayout(null);
        setSize(1950,1090);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==rec){
            new Reception();
            setVisible(false);
        }else{
            new Login2();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Dashboard();
    }
}
