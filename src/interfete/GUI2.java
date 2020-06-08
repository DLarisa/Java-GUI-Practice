package interfete;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GUI2 implements ActionListener {
    JFrame fr;
    JPanel po;

    JLabel l1, l2, l4, l11, main, l5, l6;
    JTextField tf1, tf2, tf5, tf6;

    JComboBox S1, gender;
    GridBagConstraints gbc;
    GridBagLayout go;
    JButton ok, exit;

    public GUI2() {
    fr = new JFrame("New Record Entry");
    Font f = new Font("Verdana", Font.BOLD, 24);

    // fr=new JFrame();
    po = new JPanel();
    fr.getContentPane().add(po);
    fr.setVisible(true);
    fr.setSize(1024, 768);

    fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    go = new GridBagLayout();
    gbc = new GridBagConstraints();
    po.setLayout(go);

    main = new JLabel("              NEW RECORD ENTRY              ");
    main.setFont(f);

    l1 = new JLabel("Dragon Nume :");
    tf1 = new JTextField(30);

    l2 = new JLabel("Dragon Specie :");
    tf2 = new JTextField(30);
    
    l5 = new JLabel("Dragon Varsta :");
    tf5 = new JTextField(10);
    
    l6 = new JLabel("Dragon Pret :");
    tf6 = new JTextField(10);

    l4 = new JLabel("Element :");
    String str1[] = { "Apa", "Pamant","Aer", "Foc" };
    gender = new JComboBox(str1);

    l11 = new JLabel("Culoare  :");
    String str[] = { "Verde", "Negru", "Alb", "Violet", "Rosu" };
    S1 = new JComboBox(str);

    ok = new JButton("Accept");

    exit = new JButton("Exit");

    S1.addActionListener(this);

    gender.addActionListener(this);

    // ///////////////////////////////////////
    
    

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 0;
    gbc.gridy = 0;
    go.setConstraints(l1, gbc);
    po.add(main);

    // a

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 5;
    gbc.gridy = 5;
    go.setConstraints(l1, gbc);
    po.add(l1);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 10;
    gbc.gridy = 5;
    go.setConstraints(tf1, gbc);
    po.add(tf1);

    // b

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 5;
    gbc.gridy = 10;
    go.setConstraints(l2, gbc);
    po.add(l2);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 10;
    gbc.gridy = 10;
    go.setConstraints(tf2, gbc);
    po.add(tf2);
    

    // d

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 5;
    gbc.gridy = 20;
    go.setConstraints(l4, gbc);
    po.add(l4);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 10;
    gbc.gridy = 20;
    go.setConstraints(gender, gbc);
    po.add(gender);

    // i

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 5;
    gbc.gridy = 60;
    go.setConstraints(l11, gbc);
    po.add(l11);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 10;
    gbc.gridy = 60;
    go.setConstraints(S1, gbc);
    po.add(S1);
    
 // b

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 5;
    gbc.gridy = 50;
    go.setConstraints(l5, gbc);
    po.add(l5);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 10;
    gbc.gridy = 50;
    go.setConstraints(tf5, gbc);
    po.add(tf5);
    
 // b

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 5;
    gbc.gridy = 55;
    go.setConstraints(l6, gbc);
    po.add(l6);

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 10;
    gbc.gridy = 55;
    go.setConstraints(tf6, gbc);
    po.add(tf6);

    // m

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 10;
    gbc.gridy = 90;
    go.setConstraints(ok, gbc);
    po.add(ok);

    ok.addActionListener(this);

    // n

    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 11;
    gbc.gridy = 90;
    go.setConstraints(exit, gbc);
    po.add(exit);

    exit.addActionListener(this);

    }

    public void actionPerformed(ActionEvent ev) {

    if (ev.getSource() == ok) {
    	
    	try {

	         Class.forName("com.mysql.cj.jdbc.Driver");
	   } catch (Exception ex) {
	       ex.getMessage();
	   }

            try {
            Connection con;
            JLabel last = new JLabel("Data inserted successfully");
            con = DriverManager
                            .getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");

            PreparedStatement ps = con
                            .prepareStatement("Insert into dragoni values(?,?,?,?,?,?)");

            String id = tf1.getText();
            String sname = tf2.getText();
            String pret = tf6.getText();
            String varsta = tf5.getText();

            String br = S1.getSelectedItem().toString();
            String gen = gender.getSelectedItem().toString();

            ps.setString(1, id);
            ps.setString(5, sname);
            
            ps.setDouble(4, parseDouble(pret));
            ps.setDouble(3, parseDouble(varsta));

            ps.setString(6, gen);
            ps.setString(2, br);

            ps.executeUpdate();
            con.close();

            tf1.setText("");
            tf2.setText("");
            po.add(last);
            } catch (Exception e) {

                    System.out.println("ERROR  " + e);

            }

            }

            if (ev.getSource() == exit) {

                    fr.dispose(); 
                    AuditGUI auditGUI = AuditGUI.getInstance();
                    Thread t1 = new Thread(auditGUI);
                    t1. start();
                    auditGUI.scriereFisier(2);
                    t1.interrupt();
                    new GUI();

            }
    }

	private double parseDouble(String pret) {
		double d=Double.parseDouble(pret);
		return d;
	}

}