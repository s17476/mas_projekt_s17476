package edu.pla.mas.mas_projekt_s17476.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.pla.mas.mas_projekt_s17476.gui.views.MainWindow;
import edu.pla.mas.mas_projekt_s17476.gui.views.Selection;
import edu.pla.mas.mas_projekt_s17476.model.Egzamin;
import edu.pla.mas.mas_projekt_s17476.model.PrzedmiotGrupa;
import edu.pla.mas.mas_projekt_s17476.model.PytanieEgzaminacyjne;
import edu.pla.mas.mas_projekt_s17476.repository.EgzaminRepo;
import edu.pla.mas.mas_projekt_s17476.repository.PrzedmiotGrupaRepo;
import edu.pla.mas.mas_projekt_s17476.repository.PytanieEgzaminacyjneRepo;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Component
public class SelectionController {
	
	@Autowired
	private PrzedmiotGrupaRepo pgRepo;
	
	@Autowired
	private EgzaminRepo eRepo;

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
		addListeners();
	}

	public void showGui(PrzedmiotGrupa przedmiotGrupa, MainWindow mainWindow) {
		this.przedmiotGrupa = przedmiotGrupa;
		this.mainWindow = mainWindow;
		this.mainWindow.setEnabled(false);
		view.getAnswerLabel().setText("");
		view.getLabel().setText("");
		view.setVisible(true);
		initData();
	}

	private void initData() {
		DefaultListModel<PytanieEgzaminacyjne> lista = view.getListModel();
		lista.removeAllElements();
		DefaultListModel<PytanieEgzaminacyjne> lista1 = view.getList1Model();
		lista1.removeAllElements();
		
		peRepo.findAllEagerly()
			.forEach(x -> {

				if(x.getPrzedmiot().getId() == przedmiotGrupa.getPrzedmiot().getId()) {
					if(!lista.contains(x))
						lista.addElement(x);
				}
			});
		view.getPrzedmiotLabel().setText("Pytania z przedmiotu: " + przedmiotGrupa.getPrzedmiot());
		
	}

	private void addListeners() {
		// utwórz nowy egzamin
		view.getCreateExam().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		try {
				Set<PytanieEgzaminacyjne> pe = new HashSet<>();
				if(view.getList1Model().getSize()<1 || view.getList1Model().getSize()>10)
					throw new Exception();
				for(int i = 0; i < view.getList1Model().getSize(); i++) {
					pe.add(view.getList1Model().get(i));
				}
				Egzamin egz = new Egzamin(view.getTxtPrzykad().getText(), 10, Integer.parseInt(view.getTextField_1().getText()), LocalDate.parse(view.getTextField_2().getText()), LocalDate.parse(view.getTextField_3().getText()), 
						pgRepo.findByIdEagerly(przedmiotGrupa.getId()).get(), pe);
				
				view.getList1Model().removeAllElements();
				view.getListModel().removeAllElements();
				pgRepo.save(przedmiotGrupa);
				eRepo.save(egz);
				
				JOptionPane.showMessageDialog(view, "Egzamin zapisany!");
				view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
				
			}catch(Exception exc) {
				JOptionPane.showMessageDialog(view, "Sprawdź wprowadzone dane!");
			}
			}
		});

		// zamknięcie okna
		view.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	mainWindow.setEnabled(true);
		    	view.dispose();
		    }
		});
		
		// przycisk anuluj
		view.getAnulujButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.setEnabled(true);
				view.dispose();
			}
		});
		
		//dodaj do egzaminu
		view.getDodajButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(view.getList().getSelectedIndex() > -1) {
					view.getLabel().setText("");
					view.getAnswerLabel().setText("");
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
						if(zle.get(i-1).length() > 60)
							odpowiedzi += i + ". <font color=red>" + zle.get(i-1).substring(0, 60) + "<br>   " + zle.get(i-1).substring(60, zle.get(i-1).length()) + "</font><br>";
						else
							odpowiedzi += i + ". <font color=red>" + zle.get(i-1) + "</font><br>";
					}
					for (int i = 1; i <= dobre.size(); i++) {
						if(dobre.get(i-1).length() > 60)
							odpowiedzi += i+zle.size() + ". <font color=green>" + dobre.get(i-1).substring(0, 60) + "<br>   " +  dobre.get(i-1).substring(60, dobre.get(i-1).length()) + "</font><br>";
						else
							odpowiedzi += i+zle.size() + ". <font color=green>" + dobre.get(i-1) + "</font><br>";
					}
					odpowiedzi+="</pre></html>";
					view.getAnswerLabel().setText(odpowiedzi);
				}catch(Exception exc) {}
			}
		});
		
		//przycisk nowe pytanie
		view.getNewQuestion().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() ->{
					pytanieController.showGui(view, przedmiotGrupa.getPrzedmiot());
					view.setEnabled(false);
				});
			}
		});
	}
}
