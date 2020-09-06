package edu.pla.mas.mas_projekt_s17476.gui.views;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class LogIn extends JFrame {
	
	private JTextField userField;
	private JPasswordField passwordField;
	JButton btnNewButton = new JButton("LOG IN");


	public LogIn(String name) {
		super(name);
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[69px,grow][][grow]", "[][][23px,grow]"));
		
		JLabel lblNewLabel = new JLabel("Pesel lub nr Id");
		panel.add(lblNewLabel, "cell 0 0,alignx right");
		
		userField = new JTextField();
		panel.add(userField, "cell 2 0,growx");
		userField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Hasło");
		panel.add(lblNewLabel_1, "cell 0 1,alignx right");
		
		passwordField = new JPasswordField();
		panel.add(passwordField, "cell 2 1,growx");
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 0 2 3 1,grow");
		

		panel_1.add(btnNewButton);
		
		getRootPane().setDefaultButton(btnNewButton);
		pack();
		setLocationRelativeTo(null);

	}
	


	public JButton getLogInButton() {
		return btnNewButton;
	}

	public JTextField getUserField() {
		return userField;
	}

	public JPasswordField getPasswordField() {
		return passwordField;
	}

}
