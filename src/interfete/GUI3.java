package interfete;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class GUI3 implements ActionListener {
    JFrame fr;
    JPanel po;

    JLabel l1, l2, l4, l11, main, l5, l6;
    JTextField tf1, tf2, tf5, tf6;

    GridBagConstraints gbc;
    GridBagLayout go;
    JButton ok, exit;

    public GUI3() {
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

    ok = new JButton("Accept");

    exit = new JButton("Exit");


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
                            .prepareStatement("DELETE FROM dragoni WHERE nume = ?");

            String nume = tf1.getText();
            ps.setString(1, nume);

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
                    auditGUI.scriereFisier(3);
                    t1.interrupt();
                    new GUI();

            }
    }

}