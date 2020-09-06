package edu.pla.mas.mas_projekt_s17476.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.pla.mas.mas_projekt_s17476.gui.views.MainWindow;
import edu.pla.mas.mas_projekt_s17476.gui.views.Selection;
import edu.pla.mas.mas_projekt_s17476.model.PrzedmiotGrupa;
import edu.pla.mas.mas_projekt_s17476.model.PytanieEgzaminacyjne;
import edu.pla.mas.mas_projekt_s17476.repository.PytanieEgzaminacyjneRepo;

@Component
public class SelectionController {

	@Autowired
	private PytanieEgzaminacyjneRepo peRepo;
	
	@Autowired
	private PytanieController pytanieController;
	
	private Selection view;
	private MainWindow mainWindow;
	private PrzedmiotGrupa przedmiotGrupa;
	private List<PytanieEgzaminacyjne> pytania;
	
	
	
	public SelectionController() {
		view = new Selection("Wybór pytań");
	}



	public void showGui(PrzedmiotGrupa przedmiotGrupa, MainWindow mainWindow) {
		this.przedmiotGrupa = przedmiotGrupa;
		this.mainWindow = mainWindow;
		this.mainWindow.setEnabled(false);
		view.setVisible(true);
		addListeners();
	
		initData();
		
		System.out.println(przedmiotGrupa.getGrupa() + "    " + przedmiotGrupa.getPrzedmiot() + "  " + przedmiotGrupa.getDydaktyk());
	}



	private void initData() {
		DefaultListModel<PytanieEgzaminacyjne> lista = view.getListModel();
		lista.removeAllElements();
		DefaultListModel<PytanieEgzaminacyjne> lista1 = view.getList1Model();
		lista1.removeAllElements();
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxx" + peRepo.findAllEagerly());
		
		peRepo.findAllEagerly()
			.forEach(x -> {
//				System.out.println("jeden " + x.getPrzedmiot().getId());
//				System.out.println("drugi " + przedmiotGrupa.getPrzedmiot().getId());
				if(x.getPrzedmiot().getId() == przedmiotGrupa.getPrzedmiot().getId()) {
					lista.addElement(x);
//					System.out.println("dodano");
				}
			});
		view.getPrzedmiotLabel().setText("Pytania z przedmiotu: " + przedmiotGrupa.getPrzedmiot());
		
	}



	private void addListeners() {
		
		// zamknięcie okna
		view.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	mainWindow.setEnabled(true);
		    }
		});
		
		// przycisk anuluj
		view.getAnulujButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		//dodaj do egzaminu
		view.getDodajButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(view.getList().getSelectedIndex() > -1) {
					view.getLabel().setText("");
					PytanieEgzaminacyjne pe = view.getListModel().get(view.getList().getSelectedIndex());
					view.getListModel().remove(view.getList().getSelectedIndex());
					view.getList1Model().addElement(pe);
				}
			}
		});
			
		//usun z egzaminu
		view.getUsunButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(view.getList_1().getSelectedIndex() > -1) {
					view.getLabel().setText("");
					PytanieEgzaminacyjne pe = view.getList1Model().get(view.getList_1().getSelectedIndex());
					view.getList1Model().remove(view.getList_1().getSelectedIndex());
					view.getListModel().addElement(pe);
				}
			}
		});
			
		// wyswietlanie zaznaczonego pytania
		view.getList().addListSelectionListener(new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent e) {
			try {
				String s = view.getListModel().get(view.getList().getSelectedIndex()).getTrescPytania();
				view.getLabel().setText(s);
			}catch(Exception exc) {}
			try {
				PytanieEgzaminacyjne p = (PytanieEgzaminacyjne)view.getListModel().get(view.getList().getSelectedIndex());
				List<String> zle = p.getZleOdpowiedzi();
				List<String> dobre = p.getDobreOdpowiedzi();
				String odpowiedzi = "<html><pre>";
				for (int i = 1; i <= zle.size(); i++) {
					odpowiedzi += i + ". <font color=red>" + zle.get(i-1) + "</font><br>";
				}
				for (int i = 1; i <= dobre.size(); i++) {
					odpowiedzi += i+zle.size() + ".  <font color=green>" + dobre.get(i-1) + "</font><br>";
				}
				odpowiedzi+="</pre></html>";
				view.getAnswerLabel().setText(odpowiedzi);
			}catch(Exception exc) {}
			}
		});
		
		view.getNewQuestion().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SwingUtilities.invokeLater(() ->{
				//System.out.println(przedmiotGrupa.getPrzedmiot());
				pytanieController.showGui(view, przedmiotGrupa.getPrzedmiot());
				view.setEnabled(false);
		
				
			});
		}
	});
	}
}
