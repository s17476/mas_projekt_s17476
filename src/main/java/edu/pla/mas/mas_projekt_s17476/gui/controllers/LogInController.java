package edu.pla.mas.mas_projekt_s17476.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Optional;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.pla.mas.mas_projekt_s17476.gui.views.LogIn;
import edu.pla.mas.mas_projekt_s17476.model.Osoba;
import edu.pla.mas.mas_projekt_s17476.repository.OsobaRepo;



@Component
public class LogInController {
	
	@Autowired
	private OsobaRepo oRepo;
	
	@Autowired
	private MainWindowController mainWindowController;
	
	
	private LogIn view;
	
	public LogInController() {
		view = new LogIn("Log in");
		initLogInListeners();
	}
	
	private void initLogInListeners() {
		view.getLogInButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var pass = new String(view.getPasswordField().getPassword());
				var pesel = new String(view.getUserField().getText());
				
				Optional<Osoba> user = oRepo.findByPeselAndPassword(pesel, pass);
				
				if(user.isPresent()) { 
					close();
//					System.out.println(user.get());
					SwingUtilities.invokeLater(() -> {
						mainWindowController.showGui(user.get());
					});
				}else {
					JOptionPane.showMessageDialog(view, "Zły pesel lub hasło");
				}
			}
		});
		
	}

	public void showGui() {
		view.setVisible(true);
	}
	
	public void close() {
		view.dispose();
	}

}
