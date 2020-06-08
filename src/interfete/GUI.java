package interfete;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class GUI implements ActionListener{
	JFrame frame;
	JButton button1, button2, button3, button4, button5, button6, button7, button8, button9;
	JPanel panel;
	JLabel label;

	public GUI() {
		AuditGUI auditGUI = AuditGUI.getInstance();
		Thread t1 = new Thread(auditGUI);
        t1. start();
        auditGUI.scriereFisier(0);
        t1.interrupt();
        
		frame = new JFrame();
		button1 = new JButton("InfoDragon");
		button2 = new JButton("AddDragon");
		button3 = new JButton("DeleteDragon");
		button4 = new JButton("PrintDragoni");
		button5 = new JButton("UpdateDragon");
		button6 = new JButton("InfoPhoenix");
		button7 = new JButton("AddPhoenix");
		button8 = new JButton("DeletePhoenix");
		button9 = new JButton("PrintPhoenix");
		panel = new JPanel();
		label = new JLabel("Bine ati venit in aplicatia Petshop-ului!");
		button1.addActionListener(this);
		button2.addActionListener(new Button2());
		button3.addActionListener(new Button3());
		button4.addActionListener(new Button4());
		button5.addActionListener(new Button5());
		button6.addActionListener(new Button6());
		button7.addActionListener(new Button7());
		button8.addActionListener(new Button8());
		button9.addActionListener(new Button9());
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1));
		panel.add(label);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		panel.add(button7);
		panel.add(button8);
		panel.add(button9);
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Pethsop");
		frame.pack();
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		new GUI1();
		
	}
	
	public class Button2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI2();
		}
		
	}
	
	private class Button3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI3();
		}
		
	}
	
	private class Button4 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI4();
		}
		
	}
	
	private class Button5 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI5();
		}
		
	}
	
	private class Button6 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI6();
		}
		
	}
	
	private class Button7 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI7();
		}
		
	}
	
	private class Button8 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI8();
		}
		
	}
	
	private class Button9 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GUI9();
		}
		
	}

}

