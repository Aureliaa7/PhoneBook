package phoneBookPackage;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

// the View class

public class UI extends JFrame{

	JPanel panel;
	JButton add, showSubscribers, search, exit;
	JLabel name, address, phoneNumber;
	JTextField nameField, addressField, numberField, searchSubscriber;
	JTextArea textArea;
	JScrollPane scrollPane;
	GridBagConstraints constraints;
	
	public UI() {
		super("Phone book");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 450);
		setResizable(false);
		setVisible(true);
		this.constraints = new GridBagConstraints();
		this.panel = new JPanel();
		this.panel.setBackground(Color.LIGHT_GRAY);
		this.panel.setLayout(new GridBagLayout());
		this.name = new JLabel("Name");
		constraints.gridx = 0;
		constraints.gridy = 4;
		this.panel.add(this.name, constraints);
		this.nameField = new JTextField(40);
		constraints.gridx = 1;
		constraints.gridy = 4;
		this.panel.add(this.nameField, constraints);
		this.address = new JLabel("Address");
		constraints.gridx = 0;
		constraints.gridy = 5;
		this.panel.add(this.address, constraints);
		this.addressField = new JTextField(40);
		constraints.gridx = 1;
		constraints.gridy = 5;
		this.panel.add(this.addressField, constraints);
		this.phoneNumber = new JLabel("Phone number");
		constraints.gridx = 0;
		constraints.gridy = 6;
		this.panel.add(this.phoneNumber, constraints);
		this.numberField = new JTextField(40);
		constraints.gridx = 1;
		constraints.gridy = 6;
		this.panel.add(this.numberField, constraints);
		this.add = new JButton("Add subscriber");
		constraints.gridx = 0;
		constraints.gridy = 7;
		this.panel.add(this.add, constraints);
		this.showSubscribers = new JButton("Display subscribers");
		constraints.gridx = 1;
		constraints.gridy = 8;
		this.panel.add(this.showSubscribers, constraints);
		this.searchSubscriber = new JTextField(40);
		constraints.gridx = 8;
		constraints.gridy = 5;
		this.panel.add(this.searchSubscriber, constraints);
		this.search = new JButton("Search subscriber");
		constraints.gridx = 8;
		constraints.gridy = 6;
		this.panel.add(this.search, constraints);
		this.exit = new JButton("Exit");
		constraints.gridx = 8;
		constraints.gridy = 8;
		this.panel.add(this.exit, constraints);
		this.textArea = new JTextArea(50, 70);
		
		constraints.gridx = 1;
		constraints.gridy = 11;
	    textArea.setForeground(Color.DARK_GRAY);
	   
		this.scrollPane = new JScrollPane(textArea);
		this.textArea.setEditable(false);
		this.panel.add(this.scrollPane, constraints);	
		
		this.setContentPane(panel);
		pack();
	}
	
	public String getNameField() {
		return this.nameField.getText();
	}
	
	public String getAddressField() {
		return this.addressField.getText();
	}
	
	public String getPhoneNumberField() {
		return this.numberField.getText();
	}
	
	public String getSearchedName() {
		return this.searchSubscriber.getText();
	}
	
	public void setSearchedSubscriberName(String name) {
		this.searchSubscriber.setText(name);
	}
	
	// add ActionListener for each button
	public void addListeners(ActionListener listener) {
		add.addActionListener(listener);
		showSubscribers.addActionListener(listener);
		search.addActionListener(listener);
		exit.addActionListener(listener);
	}
		
	 // Open a popup that contains the error message passed
	public void displayErrorMessage(String errorMessage){
	        JOptionPane.showMessageDialog(this, errorMessage);
	}
	
	public void clearTextArea() {
		this.textArea.setText(null);
	}
}
