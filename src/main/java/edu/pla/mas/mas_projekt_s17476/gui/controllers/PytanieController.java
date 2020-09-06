package edu.pla.mas.mas_projekt_s17476.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.pla.mas.mas_projekt_s17476.gui.views.Pytanie;
import edu.pla.mas.mas_projekt_s17476.gui.views.Selection;
import edu.pla.mas.mas_projekt_s17476.model.Przedmiot;
import edu.pla.mas.mas_projekt_s17476.model.PytanieEgzaminacyjne;
import edu.pla.mas.mas_projekt_s17476.repository.PytanieEgzaminacyjneRepo;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Component
public class PytanieController {

	@Autowired
	private PytanieEgzaminacyjneRepo peRepo;
	
	Selection selectionView;
	
	Pytanie view;
	
	Przedmiot przedmiot;
	
	
	public PytanieController() {
		view = new Pytanie("Dodaj nowe pytanie");
		addListeners();
		
	}
	
	public void showGui(Selection selectionView, Przedmiot przedmiot) {
		this.przedmiot = przedmiot;
		this.selectionView = selectionView;
		view.setVisible(true);
		
	}

	
	private void addListeners() {
		
		//zamknięcie okna
		view.addWindowListener(new java.awt.event.WindowAdapter() {
	    @Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
	    	selectionView.setEnabled(true);
		    }
		});
		
		// przycisk anuluj
		view.getCancelButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
			}
		});
		
		//przycisk dodaj
		view.getDodajButton().addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {//////////////////////////////////////////////
			try {
				boolean isOk = true;
				String[] list = {view.getTextField().getText(), 
						view.getTextField_1().getText(), 
						view.getTextField_2().getText(), 
						view.getTextField_3().getText(), 
						view.getTextField_4().getText()};
				for(int i = 0; i < list.length; i++) {
					if(list[i].length() < 1) isOk = false;
					}
				if(!isOk) {
					JOptionPane.showMessageDialog(view, "Sprawdź wprowadzone dane!");
					return;
				}
				List<String> zle = new ArrayList<>();
				List<String> dobre = new ArrayList<>();
				
				if(view.getButtonGroup().isSelected(view.getRdbtnNewRadioButton().getModel())) zle.add(view.getTextField_1().getText());
				else dobre.add(view.getTextField_1().getText());
				
				if(view.getButtonGroup2().isSelected(view.getRdbtnNewRadioButton_2().getModel())) zle.add(view.getTextField_2().getText());
				else dobre.add(view.getTextField_2().getText());
				
				if(view.getButtonGroup3().isSelected(view.getRdbtnNewRadioButton_4().getModel())) zle.add(view.getTextField_3().getText());
				else dobre.add(view.getTextField_3().getText());
				
				if(view.getButtonGroup4().isSelected(view.getRdbtnNewRadioButton_6().getModel())) zle.add(view.getTextField_4().getText());
				else dobre.add(view.getTextField_4().getText());

				System.out.println("dobre" + dobre);
				
				System.out.println("złe" + zle);
				PytanieEgzaminacyjne pe = new PytanieEgzaminacyjne(view.getTextField().getText(), zle, dobre,  przedmiot);
				peRepo.save(pe);
				
				selectionView.getListModel().addElement(pe);
				view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
				selectionView.setEnabled(true);
			}catch(Exception exc){
				JOptionPane.showMessageDialog(view, "Sprawdź wprowadzone dane!");
			}
		}
	});

	}
}
