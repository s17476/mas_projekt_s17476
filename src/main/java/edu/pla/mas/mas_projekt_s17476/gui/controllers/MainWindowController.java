package edu.pla.mas.mas_projekt_s17476.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.pla.mas.mas_projekt_s17476.gui.views.MainWindow;
import edu.pla.mas.mas_projekt_s17476.model.Egzamin;
import edu.pla.mas.mas_projekt_s17476.model.Grupa;
import edu.pla.mas.mas_projekt_s17476.model.Ocena;
import edu.pla.mas.mas_projekt_s17476.model.Osoba;
import edu.pla.mas.mas_projekt_s17476.model.PrzedmiotGrupa;
import edu.pla.mas.mas_projekt_s17476.model.Uczen;
import edu.pla.mas.mas_projekt_s17476.repository.EgzaminRepo;
import edu.pla.mas.mas_projekt_s17476.repository.GrupaRepo;
import edu.pla.mas.mas_projekt_s17476.repository.OsobaRepo;
import edu.pla.mas.mas_projekt_s17476.repository.PrzedmiotGrupaRepo;
import edu.pla.mas.mas_projekt_s17476.repository.UczenRepo;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Component
public class MainWindowController {
	
	@Autowired
	private EgzaminViewController evController;
	
	@Autowired
	private PrzedmiotGrupaRepo pgRepo;
	
	@Autowired
	private GrupaRepo gRepo;
	
	@Autowired
	private EgzaminRepo eRepo;
	
	
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
		initData(user);
		initListeners();
		view.setVisible(true);
	}
	
	private void initListeners() {
		
		//comboBox z egzaminami
		view.getEgzaminy().addActionListener(e -> {
			System.out.println();
		});
		
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
		
		// przycisk rozpoczynający test
		view.getTestButton().addActionListener(e ->{
			try {
				Egzamin egz = (Egzamin) view.getEgzaminyComboBox().getModel().getSelectedItem();
					if(egz != null)
					SwingUtilities.invokeLater(() ->{
						evController.showGui(egz, view, user);
					});
			}catch(Exception exc){}
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
		
		
		//czy jest uczniem + wczytywanie dostępnych dla ucznia materiałów
		if(user.getUczen() != null) {
			list.add(user.getUczen());
			Grupa grupa = user.getUczen().getGrupa();
			
			Optional<Grupa> pg = gRepo.findByIdAndFetchPrzedmiotGrupa(grupa.getId());
			
			if (pg.isPresent()) {
				Set<PrzedmiotGrupa> pgg = pg.get().getPrzedmiotGrupa();
				Set<PrzedmiotGrupa> peEager = new HashSet<>();
				pgg.forEach(x -> peEager.add(pgRepo.findByIdEagerly(x.getId()).get()));
				List<Set<Egzamin>> egz = new ArrayList<>();
				peEager.forEach(x -> egz.add(x.getEgzaminy()));
				List<Egzamin> egzaminy = new ArrayList<Egzamin>();
				egz.forEach(x -> x.forEach(y -> egzaminy.add(eRepo.findByIdEagerly(y.getId()).get())));
				
				DefaultComboBoxModel<Egzamin> comboModel = (DefaultComboBoxModel<Egzamin>) view.getEgzaminyComboBox().getModel();
				comboModel.removeAllElements();
				comboModel.addAll(egzaminy);
	
				view.getTestButton().setEnabled(true);
				
			}
			DefaultListModel dlm = new DefaultListModel<Ocena>();
			view.getGradesList().setModel(dlm);
			dlm.removeAllElements();
			
		}
		
		// wypełnienie combo box danymi o egzaminach - moduł uczeń
		view.setRolesComboBox(list);
	}
}
