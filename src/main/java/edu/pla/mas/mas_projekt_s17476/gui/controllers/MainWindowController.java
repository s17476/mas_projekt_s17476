package edu.pla.mas.mas_projekt_s17476.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.pla.mas.mas_projekt_s17476.gui.views.MainWindow;
import edu.pla.mas.mas_projekt_s17476.model.Osoba;
import edu.pla.mas.mas_projekt_s17476.repository.OsobaRepo;


@Component
public class MainWindowController {
	
	@Autowired
	private OsobaRepo oRepo;

	private MainWindow view;
	
	public MainWindowController() {
		view = new MainWindow("Dziennik Lekcyjny");

	}
	
	public void showGui(Osoba user) {
		initData(user);
		initListeners();
		view.setVisible(true);
	}
	
	private void initListeners() {
		// przyisk zamknij
		view.getCloseButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		//zmiany card layout
		view.getRolesComboBox().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.out.println(view.getRolesComboBox().getSelectedItem().getClass().getSimpleName());
			view.getCl().show(view.getCardsPanel(), view.getRolesComboBox().getSelectedItem().getClass().getSimpleName());
		}
	});
		
	}

	public void initData(Osoba user) {
		view.setUser(user);
		view.setWelcomeLabel(user.getImie());
		
		List list = new ArrayList<>();
		list.add("");
		if(user.getKadraAdmin() != null)
			list.add(user.getKadraAdmin());
		if(user.getKadraDydaktyczna() != null)
			list.add(user.getKadraDydaktyczna());
		if(user.getUczen() != null)
			list.add(user.getUczen());
		
		view.setRolesComboBox(list);
	}
}
