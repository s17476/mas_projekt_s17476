package edu.pla.mas.mas_projekt_s17476;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import edu.pla.mas.mas_projekt_s17476.gui.controllers.LogInController;
import edu.pla.mas.mas_projekt_s17476.model.Adres;
import edu.pla.mas.mas_projekt_s17476.model.Egzamin;
import edu.pla.mas.mas_projekt_s17476.model.Grupa;
import edu.pla.mas.mas_projekt_s17476.model.KadraAdministracyjna;
import edu.pla.mas.mas_projekt_s17476.model.KadraDydaktyczna;
import edu.pla.mas.mas_projekt_s17476.model.Ocena;
import edu.pla.mas.mas_projekt_s17476.model.Osoba;
import edu.pla.mas.mas_projekt_s17476.model.Przedmiot;
import edu.pla.mas.mas_projekt_s17476.model.PrzedmiotGrupa;
import edu.pla.mas.mas_projekt_s17476.model.PytanieEgzaminacyjne;
import edu.pla.mas.mas_projekt_s17476.model.Uczen;
import edu.pla.mas.mas_projekt_s17476.model.ZadanieDomowe;
import edu.pla.mas.mas_projekt_s17476.repository.EgzaminRepo;
import edu.pla.mas.mas_projekt_s17476.repository.GrupaRepo;
import edu.pla.mas.mas_projekt_s17476.repository.KadraDydaktycznaRepo;
import edu.pla.mas.mas_projekt_s17476.repository.OcenaRepo;
import edu.pla.mas.mas_projekt_s17476.repository.OsobaRepo;
import edu.pla.mas.mas_projekt_s17476.repository.PrzedmiotGrupaRepo;
import edu.pla.mas.mas_projekt_s17476.repository.PrzedmiotRepo;
import edu.pla.mas.mas_projekt_s17476.repository.PytanieEgzaminacyjneRepo;
import edu.pla.mas.mas_projekt_s17476.repository.UczenRepo;
import edu.pla.mas.mas_projekt_s17476.repository.ZadanieDomoweRepo;

@SpringBootApplication
public class MasProjektS17476Application {
	
	@Autowired
	DataInitializer dataInitializer;

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MasProjektS17476Application.class)
				.headless(false).run(args);
		
		ctx.getBean(DataInitializer.class).initData();
		
		SwingUtilities.invokeLater(() -> {
			ctx.getBean(LogInController.class).showGui();
		});
	}
	
	

}
