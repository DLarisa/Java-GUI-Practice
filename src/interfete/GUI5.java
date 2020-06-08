package interfete;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUI5 {

public GUI5() {
	AuditGUI auditGUI = AuditGUI.getInstance();
    Thread t1 = new Thread(auditGUI);
    t1. start();
    auditGUI.scriereFisier(5);
    t1.interrupt();
generateJTable();
}

/**
* This method helps to generate Table with buttons like Add, Update, Delete
*/
public static void generateJTable() {

// create JFrame and JTable
JFrame frame = new JFrame();
final JTable table = new JTable();

// create a table model and set a Column Identifiers to this model
Object[] columns = { "Nume", "Culoare", "Specie", "Element", "Varsta", "Pret" };
final DefaultTableModel model = new DefaultTableModel();
model.setColumnIdentifiers(columns);

// set the model to the table
table.setModel(model);

// Change A JTable Background Color, Font Size, Font Color, Row Height
table.setBackground(Color.CYAN.brighter());
table.setForeground(Color.black);
Font font = new Font("", 1, 15);
table.setFont(font);
table.setRowHeight(20);

// create JTextFields to hold the value
final JTextField nume = new JTextField();
final JTextField culoare = new JTextField();
final JTextField specie = new JTextField();
final JTextField element = new JTextField();
final JTextField varsta = new JTextField();
final JTextField pret = new JTextField();

// create JButtons to add the action
JButton btnAdd = new JButton("Add");
JButton btnDelete = new JButton("Delete");
JButton btnUpdate = new JButton("Update");

nume.setBounds(20, 200, 100, 25);
culoare.setBounds(20, 230, 100, 25);
specie.setBounds(20, 260, 100, 25);
element.setBounds(20, 290, 100, 25);
varsta.setBounds(20, 310, 100, 25);
pret.setBounds(20, 330, 100, 25);

btnAdd.setBounds(150, 220, 100, 25);
btnUpdate.setBounds(150, 265, 100, 25);
btnDelete.setBounds(150, 310, 100, 25);

// create JScrollPane
JScrollPane pane = new JScrollPane(table);
pane.setBounds(0, 0, 880, 200);

frame.setLayout(null);

frame.add(pane);

// add JTextFields to the jframe
frame.add(nume);
frame.add(culoare);
frame.add(specie);
frame.add(element);
frame.add(varsta);
frame.add(pret);

// add JButtons to the jframe
frame.add(btnAdd);
frame.add(btnDelete);
frame.add(btnUpdate);

// create an array of objects to set the row data
final Object[] row = new Object[6];

// button add row - Clicked on Add Button
btnAdd.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {

row[0] = nume.getText();
row[1] = culoare.getText();
row[2] = specie.getText();
row[3] = element.getText();
row[4] = varsta.getText();
row[5] = pret.getText();

// add row to the model
model.addRow(row);
}
});

// button remove row - Clicked on Delete Button
btnDelete.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {

// i = the index of the selected row
int i = table.getSelectedRow();
if (i >= 0) {
// remove a row from jtable
model.removeRow(i);
} else {
System.out
.println("There were issue while Deleting the Row(s).");
}
}
});

// get selected row data From table to textfields
table.addMouseListener(new MouseAdapter() {

@Override
public void mouseClicked(MouseEvent e) {

// i = the index of the selected row
int i = table.getSelectedRow();

nume.setText(model.getValueAt(i, 0).toString());
culoare.setText(model.getValueAt(i, 1).toString());
specie.setText(model.getValueAt(i, 2).toString());
element.setText(model.getValueAt(i, 3).toString());
varsta.setText(model.getValueAt(i, 4).toString());
pret.setText(model.getValueAt(i, 5).toString());
}
});

// button update row - Clicked on Update Button
btnUpdate.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {

// i = the index of the selected row
int i = table.getSelectedRow();

if (i >= 0) {
model.setValueAt(nume.getText(), i, 0);
model.setValueAt(culoare.getText(), i, 1);
model.setValueAt(specie.getText(), i, 2);
model.setValueAt(element.getText(), i, 3);
model.setValueAt(varsta.getText(), i, 4);
model.setValueAt(pret.getText(), i, 5);
} else {
System.out.println("Update Error");
}
}
});

frame.setSize(900, 400);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);

}
}