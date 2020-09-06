package edu.pla.mas.mas_projekt_s17476.gui.controllers;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.pla.mas.mas_projekt_s17476.gui.views.MainWindow;
import edu.pla.mas.mas_projekt_s17476.model.Ocena;
import edu.pla.mas.mas_projekt_s17476.model.Osoba;
import edu.pla.mas.mas_projekt_s17476.model.Uczen;
import edu.pla.mas.mas_projekt_s17476.repository.OsobaRepo;
import edu.pla.mas.mas_projekt_s17476.repository.UczenRepo;


@Component
public class MainWindowController {
	
	@Autowired
	private UczenRepo uRepo;
	
	@Autowired
	private CreatorController creatorController;

	private MainWindow view;
	
	private Osoba user;
	
	public MainWindowController() {
		view = new MainWindow("Dziennik Lekcyjny");
	}
	
	public void showGui(Osoba user) {
		this.user = user;
		view.setUser(user);
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
		
		//zmiany paneli card layout
		view.getRolesComboBox().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(view.getRolesComboBox().getSelectedItem().getClass().getSimpleName());
				view.getCl().show(view.getCardsPanel(), view.getRolesComboBox().getSelectedItem().getClass().getSimpleName());
			}
		});
		
		//przycisk pokaż oceny - moduł uczeń
		view.getShowGradesButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
					Optional<Uczen> uczen = uRepo.findByIdAndFetchOcenaEagerly(user.getUczen().getId());
					List<Ocena> grades;
					if(uczen.isPresent()) {
						grades = new ArrayList<Ocena>(uczen.get().getOcena());
						System.out.println(grades);
						DefaultListModel<Ocena> dlm = (DefaultListModel<Ocena>) view.getGradesList().getModel();
						dlm.removeAllElements();
					grades.forEach(x -> dlm.addElement(x));
					}
			}
		});
		
		//przycisk - nowy test
		view.getNewTestButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setEnabled(false);
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						creatorController.showGui(view, user);
					}
				});
			}
		});
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void initData(Osoba user) {
		
		//ustawia imię na ekranie powitalnym
		view.setWelcomeLabel(user.getImie());
		
		//sprawdza dostępne dla użytkownika role i wczytuje je do combo box
		List list = new ArrayList<>();
		list.add("");
		
		//czy należy do administracji
		if(user.getKadraAdmin() != null)
			list.add(user.getKadraAdmin());
		
		//czy jest nauczycielem
		if(user.getKadraDydaktyczna() != null)
			list.add(user.getKadraDydaktyczna());
		
		
		//czy jest uczniem
		if(user.getUczen() != null)
			list.add(user.getUczen());
		
		view.setRolesComboBox(list);
	}
}
