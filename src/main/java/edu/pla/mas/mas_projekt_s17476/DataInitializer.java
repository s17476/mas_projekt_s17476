package edu.pla.mas.mas_projekt_s17476;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

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

@Component
public class DataInitializer {
	
	@Autowired
	private OsobaRepo oRepo;
	
	@Autowired
	private GrupaRepo gRepo;
	
	@Autowired
	private	UczenRepo uRepo;
	
	@Autowired
	private	PrzedmiotRepo pRepo;
	
	@Autowired
	private	KadraDydaktycznaRepo kaRepo;
	
	@Autowired
	private	PrzedmiotGrupaRepo pgRepo;
	
	@Autowired
	private	PytanieEgzaminacyjneRepo peRepo;
	
	@Autowired
	private	EgzaminRepo eRepo;
	
	@Autowired
	private	ZadanieDomoweRepo zRepo;
	
	@Autowired
	private	OcenaRepo ocenaRepo;
	
		public void initData() {
			
			/*
			 * tworzę przykładowe osoby oraz ich adresy
			 */
			var a1 = new Adres("Kolejowa", "4", "Legnica", "59-100", "555555555");
			var a2 = new Adres("Polna", "2", "Poznań", "32-100", "555555555");
			
			var osoby = List.of(
				new Osoba("Arek", "Arkowski", "1234", "1", "1993-01-02", 
						new Adres("Kwiatowa", "12", "Szczecin", "21-210", "888888888")),
				new Osoba("Marek", "Markowski", "1234", "2", "1990-01-02", 
						new Adres("Leśna", "123", "Kalisz", "34-123", "777777777")),
				new Osoba("Jarek", "Jarkowski", "1234", "3", "1995-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Cezary", "Cezary", "1234", "4", "1991-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Michał", "Michalski", "1234", "5", "1997-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Tomasz", "Tomaszewski", "1234", "6", "1995-02-01", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Irek", "Irkowski", "1234", "7", "1995-04-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Paweł", "Nowak", "1234", "8", "1995-09-03", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Krystian", "Marzec", "1234", "9", "1995-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Grzegorz", "Kowalski", "1234", "10", "1995-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Kamil", "Mol", "1234", "11", "1995-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Ilona", "Wolska", "1234", "12", "1995-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Kamila", "Szyszka", "1234", "13", "1995-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Alicja", "Janosz", "1234", "14", "1995-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Marcelina", "Zawadzka", "1234", "15", "1995-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Arkadiusz", "Ściana", "1234", "16", "1995-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Mariusz", "Skalski", "1234", "17", "1995-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")),
				new Osoba("Mateusz", "Adamczewski", "1234", "18", "1995-01-02", 
						new Adres("Owocowa", "5", "Wrocław", "50-100", "666666666")));
				
			osoby.get(0).setAdres(a1);
			
			/*
			 * ustalam kadrę administracyjną pesel od 15 do 18
			 */
			String[] stanowiska = {"Sekretarka", "Szef biblioteki", "Dziekan", "Zastępca dziekana"};
			for(int i = osoby.size()-stanowiska.length; i < osoby.size(); i++) {
				osoby.get(i).setKadraAdmin(new KadraAdministracyjna(stanowiska[i-(osoby.size()-stanowiska.length)], "Jakieś obowiązki"));
			}
			
			/*
			 * ustalam kadrę dydaktyczną pesel od 13 do 18
			 */
			for(int i = 12; i < osoby.size(); i++) {
				osoby.get(i).setKadraDydaktyczna(new KadraDydaktyczna());
			}
			
			/*
			 * ustalam uczniów pesel od 1 do 12
			 */
			Grupa g1 = new Grupa(LocalDate.parse("2020-10-01"), "1a");
			Grupa g2 = new Grupa(LocalDate.parse("2020-10-01"), "1b");
			Grupa g3 = new Grupa(LocalDate.parse("2020-10-01"), "1c");
			gRepo.save(g1);
			gRepo.save(g2);
			gRepo.save(g3);
			for(int i = 0; i < 5; i++) {
				osoby.get(i).setUczen(new Uczen(LocalDate.parse("2020-10-01"), null, g1));
			}
			for(int i = 5; i < 8; i++) {
				osoby.get(i).setUczen(new Uczen(LocalDate.parse("2020-10-01"), null, g2));
			}
			for(int i = 8; i < 12; i++) {
				osoby.get(i).setUczen(new Uczen(LocalDate.parse("2020-10-01"), null, g3));
			}
			
			
			/*
			 * dodaję przedmioty
			 */
			List<Przedmiot> listaPrzedmiotow = Arrays.asList(
					new Przedmiot(
							"Modelowanie i analiza systemów informacyjnych", 
							"MAS", 
							"Przedmiot prowadzony przez internet. Techniki zaawansowane w Java"
							),
					new Przedmiot(
							"Narzędzia sztucznej inteligencji", 
							"NAI", 
							"Przedmiot prowadzony przez internet. Zagadnienia z dziedziny AI"
							),
					new Przedmiot(
							"Aplikacje baz danych", 
							"APBD", 
							"Przedmiot prowadzony przez internet. .net Core, C#"
							),
					new Przedmiot(
							"Graficzne interfejsy użytkownika", 
							"GUI", 
							"Przedmiot prowadzony przez internet. Pakiet Java Swing i AWT"
							),
					new Przedmiot(
							"Uniwersalne techniki programowania", 
							"UTP", 
							"Przedmiot prowadzony przez internet. Techniki uniwersalne w Java"
							),
					new Przedmiot(
							"Relacyjne bazy danych", 
							"RBD", 
							"Przedmiot prowadzony przez internet. Projektowanie i zarządzanie systemami DB"
							),
					new Przedmiot(
							"Technologie programowania rozproszonego", 
							"TPO", 
							"Przedmiot prowadzony przez internet. Techniki rozproszone w Java"
							)
					);
			
			pRepo.saveAll(listaPrzedmiotow);
			
			oRepo.saveAll(osoby);
			
			/*
			 * wypełniam tabelę PrzedmiotGrupa
			 */
			
			//dostępne przedmioty
			List<Przedmiot> przedmioty = (List<Przedmiot>) pRepo.findAllEagerly();
			
			//pobieram nauczycieli z bazy
//			List<Osoba> os = ((List<Osoba>) oRepo.findAll())
//														.stream()
//														.filter(x -> Objects.nonNull(x.getKadraDydaktyczna()))
//														.collect(Collectors.toList()
//																);
			
			List<KadraDydaktyczna> nauczyciele = kaRepo.findAllEagerly();
			
			List<Grupa> grupy = (List<Grupa>) gRepo.findAllEagerly();
			
			System.out.println("Grupy" + grupy);
			
//			System.out.println(" NAUCZYCIELE             " + nauczyciele);
			
			List<PrzedmiotGrupa> pg = List.of(
					new PrzedmiotGrupa(przedmioty.get(0), grupy.get(0), nauczyciele.get(0)),
					new PrzedmiotGrupa(przedmioty.get(1), grupy.get(0), nauczyciele.get(0)),
					new PrzedmiotGrupa(przedmioty.get(2), grupy.get(2), nauczyciele.get(0)),
					new PrzedmiotGrupa(przedmioty.get(0), grupy.get(1), nauczyciele.get(0)),
					new PrzedmiotGrupa(przedmioty.get(1), grupy.get(1), nauczyciele.get(0)),
					new PrzedmiotGrupa(przedmioty.get(2), grupy.get(1), nauczyciele.get(0)),
					new PrzedmiotGrupa(przedmioty.get(3), grupy.get(1), nauczyciele.get(1)),
					new PrzedmiotGrupa(przedmioty.get(4), grupy.get(1), nauczyciele.get(2)),
					new PrzedmiotGrupa(przedmioty.get(5), grupy.get(2), nauczyciele.get(3)),
					new PrzedmiotGrupa(przedmioty.get(6), grupy.get(2), nauczyciele.get(4))
					);
			
			pgRepo.saveAll(pg);
			

			/*
			 * dodaję opiekunów dla uczniów
			 */
			List<Osoba> list = (List<Osoba>)oRepo.findAll();
			
			Uczen u1 = uRepo.findByIdAndFetchAdresEagerly(list.get(0).getUczen().getId()).get();
			Uczen u2 = uRepo.findByIdAndFetchAdresEagerly(list.get(1).getUczen().getId()).get();
			Osoba o1 = oRepo.findByPeselAndFetchPodopieczniEagerly(list.get(17).getPesel()).get();
			
			u1.setOpiekunowie(o1);
			u2.setOpiekunowie(o1);
			
			oRepo.save(o1);
			uRepo.save(u1);
			uRepo.save(u2);
			
			o1 = oRepo.findByPeselAndFetchPodopieczniEagerly(list.get(17).getPesel()).get();
//			System.out.println("Podopieczni:          " + o1.getPodopieczni());
			
			/*
			 * dodaję przykładowe pytania
			 */
			
			String trescPytania[] = {
					"Czy Java to:", 
					"Czy metoda klasowa może byc użyta nawet wtedy gdy nie ma żadnego obiektu danej klasy?",
					"Zaznacz poprawne stwierdzenia:"};
			List<List<String>> dobre = Arrays.asList(
					List.of("Język programowania", "Wyspa na Pacyfiku", "Gatunek kawy"),
					List.of("Tak"),
					List.of("Jednym ze sposobów uzyskiwania trwałości ekstensji jest jej zapis do pliku")
					);
			List<List<String>> zle = Arrays.asList(
					List.of("Protokół sieciowy"),
					List.of("Nie"),
					List.of("Aplikacje biznesowe nie potrzebują trwałości ekstensji", 
							"Problem trwałości ekstensji, spowodowany powiązaniami, jest spowodowany słabą wydajnością platformy Java",
							"W celu poprawy wydajności, każdą ekstensję należy serializować do oddzielnego pliku")
					);
			for(int i = 0; i < trescPytania.length; i++) {
				PytanieEgzaminacyjne pe = new PytanieEgzaminacyjne(trescPytania[i], zle.get(i), dobre.get(i), przedmioty.get(0));
				peRepo.save(pe);
			}
			
			/*
			 * dodaję przykładowy egzamin
			 */
			List<PytanieEgzaminacyjne> pytania = (List<PytanieEgzaminacyjne>) peRepo.findAllEagerly();
			
			Set<PytanieEgzaminacyjne> pytaniaSet = new HashSet<PytanieEgzaminacyjne>();
			pytaniaSet.addAll(pytania);
			
			var pg1 = pgRepo.findByIdEagerly(52l).get();
			
			Egzamin egzamin = new Egzamin(
					"Kolokwium 1", 
					3, 
					10,
					LocalDate.parse("2020-09-03"), 
					LocalDate.parse("2020-10-27"), 
					pg1, 
					pytaniaSet
					);
			
//			System.out.println("EGZAMIN              " + egzamin);
			
			eRepo.save(egzamin);
			
			/*
			 * dodaję przykładowe zadanie domowe
			 */
			var zd = new ZadanieDomowe("Opisz jak działa Garbage Collector w Javie");
			
			zRepo.save(zd);
			
			List<ZadanieDomowe> listaZadan = (List<ZadanieDomowe>) zRepo.findAllEagerly();
			
			u1 = uRepo.findByIdAndFetchOcenaEagerly(u1.getId()).get();
			
			
			/*
			 * oceniam zadanie domowe
			 */
			var ocena = new Ocena(LocalDate.now(), 4, "", u1, listaZadan.get(0));
			
			ocenaRepo.save(ocena);
			
			
			
			//System.out.println(oRepo.findByPeselAndPassword("16", "1234"));
//			
//			Osoba o = oRepo.findByPeselAndFetchAdresEagerly("1").get();
//			System.out.println(o.getAdres());
			
			

		
	}

}
