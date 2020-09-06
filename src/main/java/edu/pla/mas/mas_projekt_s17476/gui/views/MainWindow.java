package edu.pla.mas.mas_projekt_s17476.gui.views;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.List;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.SoftBevelBorder;

import edu.pla.mas.mas_projekt_s17476.model.Egzamin;
import edu.pla.mas.mas_projekt_s17476.model.Ocena;
import edu.pla.mas.mas_projekt_s17476.model.Osoba;
import javax.swing.border.BevelBorder;
import javax.swing.JList;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

public class MainWindow extends JFrame {
	
	private Osoba user;
	private JPanel contentPane;
	public JFrame frame = this;
	
	//etykieta powitalna
	JLabel welcomeLabel = new JLabel("");
	
	//role użytkownika
	JComboBox rolesComboBox = new JComboBox();
	
	JButton closeButton = new JButton("Zamknij");
	
	//cards layout
	CardLayout cl;
	JPanel cardsPanel = new JPanel();
	JComboBox<Egzamin> egzaminy = new JComboBox<>();
	JButton showGradesButton = new JButton("Pokaż moje oceny");
	JList<Ocena> gradesList = new JList<Ocena>(new DefaultListModel<Ocena>());
	JButton newTestButton = new JButton("Nowy test");
	JComboBox egzaminyComboBox = new JComboBox();

	/**
	 * Create the frame.
	 */
	public MainWindow(String tytul) {
		super(tytul);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 958, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Plik");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Pomoc");
		menuBar.add(mnNewMenu_1);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][][][]", "[][grow]"));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 0 5 1,alignx left,growy");
		
		JButton btnNewButton = new JButton("Kalendarz");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Wiadomości");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Moje pliki");
		panel.add(btnNewButton_2);
		
		
		

		panel.add(closeButton);
		

		
		JPanel panel_7 = new JPanel();
		contentPane.add(panel_7, "cell 5 0");
		FlowLayout flowLayout = (FlowLayout) panel_7.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		
		contentPane.add(cardsPanel, "cell 1 1 5 1,grow");
		cardsPanel.setLayout(new CardLayout());
		cl = (CardLayout)cardsPanel.getLayout();
		JLabel lblNewLabel = new JLabel("Zalogowano jako:");
		panel_7.add(lblNewLabel);
		

		panel_7.add(rolesComboBox);
		
		JPanel welcome = new JPanel();
		cardsPanel.add(welcome, "String");
		welcome.setLayout(new MigLayout("", "[grow][][][][][grow]", "[grow][][][][grow][grow]"));
		
		JPanel admin = new JPanel();
		cardsPanel.add(admin, "KadraAdministracyjna");
		admin.setLayout(new MigLayout("", "[grow][][][][][grow]", "[grow][][][][grow][grow]"));
		
		JPanel uczen = new JPanel();
		cardsPanel.add(uczen, "Uczen");
		uczen.setLayout(new MigLayout("", "[grow][][][][][grow]", "[grow][][][][][][grow][grow]"));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		uczen.add(panel_3, "cell 0 0 1 3,grow");
		panel_3.setLayout(new MigLayout("", "[77px,grow]", "[14px][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("Dostępne testy:");
		panel_3.add(lblNewLabel_3, "cell 0 0,alignx left,aligny top");
		
		
		panel_3.add(egzaminyComboBox, "cell 0 1,growx");
		JButton btnNewButton_8 = new JButton("Rozwiąż");
		panel_3.add(btnNewButton_8, "cell 0 2,alignx right");
		
		JLabel lblNewLabel_4 = new JLabel("Moduł uczeń");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		uczen.add(lblNewLabel_4, "cell 1 4");
		
		
		/**
		 * pobiera oceny z bazy danych
		 */
		
	

		uczen.add(showGradesButton, "cell 0 5");
		
		JPanel panel_4 = new JPanel();
		uczen.add(panel_4, "cell 0 6 1 2,grow");
		
		panel_4.add(gradesList);
		
		/**
		 * pobiera dostępne egzaminy
		 */
//		if(user.getUczen() != null) {
//		
//			CriteriaBuilder cb = db.getCriteriaBuilder();
//			CriteriaQuery<PrzedmiotGrupa> cr = cb.createQuery(PrzedmiotGrupa.class);
//			Root<PrzedmiotGrupa> root = cr.from(PrzedmiotGrupa.class);
//			
//			cr.select(root).where(cb.equal(root.get("grupa"), user.getUczen().getGrupa()));
//			System.out.println("Grupa"+user.getUczen().getGrupa());
//			 
//			Query<PrzedmiotGrupa> query = db.createQuery(cr);
//			List<PrzedmiotGrupa> results = (List<PrzedmiotGrupa>)query.getResultList();
//			
//			comboBox_1 = new JComboBox(results.get(0).getListaEgzaminow().toArray());
//			uczen.add(comboBox_1, "cell 0 0");
//			
//			System.out.println("Jest grupa "+results);
//		}
//		else
//			comboBox_1 = new  JComboBox();
		
		JPanel nauczyciel = new JPanel();
		nauczyciel.setBorder(null);
		cardsPanel.add(nauczyciel, "KadraDydaktyczna");
		nauczyciel.setLayout(new MigLayout("", "[][grow]", "[grow]"));
		
		JPanel panel_1 = new JPanel();
		nauczyciel.add(panel_1, "cell 0 0,grow");
		panel_1.setLayout(new MigLayout("", "[89px]", "[23px][][][][]"));
		
		JButton btnNewButton_4 = new JButton("Pokaż grupy");
		panel_1.add(btnNewButton_4, "cell 0 0,growx,aligny top");
		
		JButton btnNewButton_5 = new JButton("Pokaż przedmioty");
		panel_1.add(btnNewButton_5, "cell 0 1,growx");
		
		JSeparator separator = new JSeparator();
		panel_1.add(separator, "cell 0 2,grow");
		
		
		
		panel_1.add(newTestButton, "cell 0 3,growx");
		
		JButton btnNewButton_7 = new JButton("Pokaż testy");
		panel_1.add(btnNewButton_7, "cell 0 4,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		nauczyciel.add(panel_2, "cell 1 0,grow");
		
		JPanel panel_6 = new JPanel();
		welcome.add(panel_6, "cell 0 1 6 1,grow");
		//////////////////
		
		welcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_6.add(welcomeLabel);
		
		JPanel panel_5 = new JPanel();
		welcome.add(panel_5, "cell 0 3 6 1,grow");
		
		JLabel lblNewLabel_2 = new JLabel("W prawym górnym rogu wybierz rolę użytkownika.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_5.add(lblNewLabel_2);
		this.setMinimumSize(new Dimension(300, 400));
		setPreferredSize(new Dimension(1000, 700));
		setLocationRelativeTo(null);


		
	}

	public void setUser(Osoba user) {
		this.user = user;
	}

	public void setWelcomeLabel(String userName) {
		this.welcomeLabel.setText("Witaj " + userName);;
	}

	public JComboBox getRolesComboBox() {
		return rolesComboBox;
	}

	public void setRolesComboBox(List roles) {
		this.rolesComboBox.setModel(new DefaultComboBoxModel(roles.toArray()));
	}

	public JButton getCloseButton() {
		return closeButton;
	}

	public CardLayout getCl() {
		return cl;
	}

	public JPanel getCardsPanel() {
		return cardsPanel;
	}

	public JButton getShowGradesButton() {
		return showGradesButton;
	}

	public JList getGradesList() {
		return gradesList;
	}

	public JButton getNewTestButton() {
		return newTestButton;
	}

	public JComboBox<Egzamin> getEgzaminy() {
		return egzaminy;
	}

	public void setEgzaminy(JComboBox<Egzamin> egzaminy) {
		this.egzaminy = egzaminy;
	}

	public JComboBox getEgzaminyComboBox() {
		return egzaminyComboBox;
	}

	public void setEgzaminyComboBox(JComboBox egzaminyComboBox) {
		this.egzaminyComboBox = egzaminyComboBox;
	}
	
	
	
}
