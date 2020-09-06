package edu.pla.mas.mas_projekt_s17476.gui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.Map;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import edu.pla.mas.mas_projekt_s17476.gui.views.EgzaminView;
import edu.pla.mas.mas_projekt_s17476.gui.views.MainWindow;
import edu.pla.mas.mas_projekt_s17476.model.Egzamin;
import edu.pla.mas.mas_projekt_s17476.model.Ocena;
import edu.pla.mas.mas_projekt_s17476.model.Osoba;
import edu.pla.mas.mas_projekt_s17476.model.PytanieEgzaminacyjne;
import edu.pla.mas.mas_projekt_s17476.repository.EgzaminRepo;
import edu.pla.mas.mas_projekt_s17476.repository.OcenaRepo;
import edu.pla.mas.mas_projekt_s17476.repository.UczenRepo;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

@Component
public class EgzaminViewController {
	
	@Autowired
	EgzaminRepo eRepo;
	
	@Autowired
	UczenRepo uRepo;
	
	@Autowired
	OcenaRepo oRepo;
	
	MainWindow mainWindow;
	Egzamin egzamin;
	
	EgzaminView view;
	
	Thread thread;
	
	Osoba user;

	public EgzaminViewController() {
		
	}
	
	public void showGui(Egzamin egzamin, MainWindow mainWindow, Osoba user) {
		view = new EgzaminView("Egzamin", egzamin);
		view.setVisible(true);
		this.egzamin = egzamin;
		this.mainWindow = mainWindow;
		view.setEgzamin(egzamin);
		this.user = user;
		timer();
		addListeners();
	}
	
	private void addListeners() {
		//zakończ i zapisz egzamin
		view.getEndExam().addActionListener(new ActionListener() {
			private final Map<PytanieEgzaminacyjne, Map<String, JCheckBox>> result = view.getTest();
			public void actionPerformed(ActionEvent e) {
				
				String[] opcje =  { "Anuluj", "Zakończ"};
				int rc = JOptionPane.showOptionDialog(
				           null,
				           "Czy na pewno chcesz zakończyć egzamin?",
				           "Zakończyć?",
				           JOptionPane.DEFAULT_OPTION,
				           JOptionPane.QUESTION_MESSAGE,
				           null,
				           opcje,
				           opcje[0]);
				
				if(rc == 1) {
					int rezultat = egzamin.check(view.getTest());
					JOptionPane.showMessageDialog(view, "Uzyskałeś " + rezultat + " punktów.", "Wynik egzaminu", JOptionPane.INFORMATION_MESSAGE);
					//System.out.println(rezultat +  " " + user.getUczen() + " " + egzamin);
					var ocena = new Ocena(LocalDate.now(), 
							rezultat, 
							"", 
							uRepo.findByIdAndFetchOcenaEagerly(user.getUczen().getId()).get(), 
							eRepo.findByIdEagerlyAndFetchOcena(egzamin.getId()).get()
							);
					oRepo.save(ocena);
					
					mainWindow.setEnabled(true);
					
			    	thread.interrupt();
			    	
					view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
				}
			}
		});
		
	}

	//wątek minutnika
	public void timer() {
		
		thread = new Thread(new Runnable () {
	        @Override
	        public void run() {
	            int countdownSeconds = egzamin.getDostepnyCzas() * 60;

	            for (int i = countdownSeconds ; i >= 0; i--) {
	                try{
	                    Thread.sleep(1000);
	                }catch (InterruptedException e) {}
	                
	                int minuty = (int)i/60;
	                int sekundy = i-(minuty*60);
	                view.getTimerLabel().setText(minuty + ":" +sekundy);
	            }
	            view.getEndExam().doClick();
	        }
	    });
		thread.start();
	}
}
