package edu.pla.mas.mas_projekt_s17476.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.pla.mas.mas_projekt_s17476.gui.views.Creator;
import edu.pla.mas.mas_projekt_s17476.gui.views.MainWindow;
import edu.pla.mas.mas_projekt_s17476.model.Grupa;
import edu.pla.mas.mas_projekt_s17476.model.KadraDydaktyczna;
import edu.pla.mas.mas_projekt_s17476.model.Osoba;
import edu.pla.mas.mas_projekt_s17476.model.Przedmiot;
import edu.pla.mas.mas_projekt_s17476.model.PrzedmiotGrupa;
import edu.pla.mas.mas_projekt_s17476.repository.KadraDydaktycznaRepo;

/**
 * 
 * @author Grzegorz Frączek
 *
 */
@Component

public class CreatorController {
	
	@Autowired
	private KadraDydaktycznaRepo kaRepo;
	
	@Autowired
	private SelectionController selectionController;
	
	private Creator view;
	
	private MainWindow mainWindow;
	
	List<PrzedmiotGrupa> przedmiotyWGrupach;
	
	PrzedmiotGrupa przedmiotGrupa;
	
	public CreatorController() {
		view = new Creator("Nowy test");
	}

	private void initListeners() {
		
		//zamykanie okna
		view.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		    	mainWindow.setEnabled(true);
		    	view.dispose();
		    }
		});
		
		//przycisk anuluj

		view.getCancelButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainWindow.setEnabled(true);
				view.dispose();
			}
		});
		
		//aktualizacja listy grup
		view.getComboPrzedmiot().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				DefaultComboBoxModel<Grupa> grupy = (DefaultComboBoxModel<Grupa>) view.getComboGrupa().getModel();
				grupy.removeAllElements();
				
				Przedmiot selected = (Przedmiot) view.getComboPrzedmiot().getSelectedItem();
				
				przedmiotyWGrupach.forEach(x -> {
					if(x.getPrzedmiot().equals(selected))
						grupy.addElement(x.getGrupa());
				});
			}
		});
		
		//przycisk dalej
		view.getDalejButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
				
				przedmiotyWGrupach.forEach(x -> {
					if(x.getPrzedmiot().equals(view.getComboPrzedmiot().getSelectedItem()) &&
							x.getGrupa().equals(view.getComboGrupa().getSelectedItem()))
						przedmiotGrupa = x;
				});
				SwingUtilities.invokeLater(() -> {
					

					
//					System.out.println(przedmiotGrupa);
					selectionController.showGui(przedmiotGrupa, mainWindow);
				
				});
			}
		});
	}

	public void showGui(MainWindow mainWindow, Osoba user) {
		this.mainWindow = mainWindow;
		view.setVisible(true);
		initListeners();

			initData(user);

		
	}

	private void initData(Osoba user) {
		DefaultComboBoxModel<Przedmiot> przedmioty = (DefaultComboBoxModel<Przedmiot>) view.getComboPrzedmiot().getModel();
		przedmioty.removeAllElements();

		Optional<KadraDydaktyczna> tmpUser = kaRepo.findByIdAndFetchSubjects(user.getKadraDydaktyczna().getId());
		
		przedmiotyWGrupach = new ArrayList<PrzedmiotGrupa>(tmpUser.get().getPrzedmiotGrupa());
		
		przedmiotyWGrupach.forEach(x -> {
			if(przedmioty.getIndexOf(x.getPrzedmiot()) == -1)
				przedmioty.addElement(x.getPrzedmiot());
		});
	}

}
