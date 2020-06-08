package interfete;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

 

public class GUI9 extends JFrame implements ActionListener {

 

    JLabel l, l1, l2, l3, l4, l5;

    JButton b, button;

    JTextField tf1, tf2, tf3, tf4;

    JComboBox bx;

    String str;

 

    GUI9() {

        setVisible(true);

        setSize(700, 700);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Print Phoenixi");

 

        l = new JLabel("Select Name:");

        b = new JButton("Submit");
        button = new JButton("Back"); 
 

        tf1 = new JTextField();

        tf2 = new JTextField();

        tf3 = new JTextField();

        tf4 = new JTextField();

 

        l.setBounds(20, 20, 200, 20);

        b.setBounds(50, 50, 150, 30);
        button.setBounds(200, 50, 150, 30);

 
        
        add(l);

        add(b); 
        add(button);
 

        tf1.setEditable(false);

        tf2.setEditable(false);

        tf3.setEditable(false);

        tf4.setEditable(false);

        b.addActionListener(this);
        button.addActionListener(new GUI9.ButtonListener());
        button.setActionCommand("back");

        try {

	         Class.forName("com.mysql.cj.jdbc.Driver");
	   } catch (Exception ex) {
	       ex.getMessage();

        try {


        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");

            PreparedStatement ps = con.prepareStatement("select nume from phoenixi");

            ResultSet rs = ps.executeQuery();

            Vector<String> v = new Vector();

            while (rs.next()) {

                String s = rs.getString(1);

 

                v.add(s);

            }

            bx = new JComboBox(v);

            bx.setBounds(240, 20, 200, 20);

            add(bx);

 

        } catch (Exception e) {

            System.out.println(e);

        }
        }
    }

 


 

    public void actionPerformed(ActionEvent e) {

        showData();

    }

 

    public void showData() {

        JFrame f1 = new JFrame();

        f1.setVisible(true);

        f1.setSize(500, 500);

        f1.setLayout(null);

        f1.setTitle("Show Phoenixi");


        l5 = new JLabel("Displaying Phoenixi:");       

        l5.setForeground(Color.red);

        l5.setFont(new Font("Serif", Font.BOLD, 20));

        l1 = new JLabel("Nume:");

        l2 = new JLabel("Tara:");

        l3 = new JLabel("Varsta:");

        l4 = new JLabel("Pret:");

 

        l5.setBounds(100, 50, 300, 30);

        l1.setBounds(20, 110, 200, 20);

        l2.setBounds(20, 140, 200, 20);

        l3.setBounds(20, 170, 200, 20);

        l4.setBounds(20, 200, 200, 20);

 

        tf1.setBounds(240, 110, 200, 20);

        tf2.setBounds(240, 140, 200, 20);

        tf3.setBounds(240, 170, 200, 20);

        tf4.setBounds(240, 200, 200, 20);

 

        f1.add(l5);

        f1.add(l1);

        f1.add(tf1);

        f1.add(l2);

        f1.add(tf2);

        f1.add(l3);

        f1.add(tf3);

        f1.add(l4);

        f1.add(tf4);

 

        str = (String) bx.getSelectedItem();

        try {

	         Class.forName("com.mysql.cj.jdbc.Driver");
	   } catch (Exception ex) {
	       ex.getMessage();
	   }
   	
       //Create DataBase Coonection and Fetching Records  
       try {    
           
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");  
           PreparedStatement ps = con.prepareStatement("select * from phoenixi where nume=?");

            ps.setString(1, str);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

 

                tf1.setText(rs.getString(1));

                tf2.setText(rs.getString(5));

                tf3.setText(rs.getString(3));

                tf4.setText(rs.getString(4));

 

            }

        } catch (Exception ex) {

            System.out.println(ex);

        }

    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();

            if (cmd.equals("back")) {
                dispose();
                AuditGUI auditGUI = AuditGUI.getInstance();
                Thread t1 = new Thread(auditGUI);
                t1. start();
                auditGUI.scriereFisier(9);
                t1.interrupt();
                new GUI();
            }
        }
    }

}
