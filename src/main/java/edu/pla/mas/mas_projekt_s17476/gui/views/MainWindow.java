package edu.pla.mas.mas_projekt_s17476.gui.views;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.util.List;
import java.awt.CardLayout;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.SoftBevelBorder;
import edu.pla.mas.mas_projekt_s17476.model.Egzamin;
import edu.pla.mas.mas_projekt_s17476.model.Ocena;
import javax.swing.border.BevelBorder;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

public class MainWindow extends JFrame {
	
	private JPanel contentPane;
	public JFrame frame = this;
	
	//etykieta powitalna
	private JLabel welcomeLabel = new JLabel("");
	
	//role użytkownika
	private JComboBox rolesComboBox = new JComboBox();
	
	private JButton closeButton = new JButton("Zamknij");
	
	//cards layout
	private CardLayout cl;
	private JPanel cardsPanel = new JPanel();
	
	private JComboBox<Egzamin> egzaminy = new JComboBox<>();
	private JButton showGradesButton = new JButton("Pokaż moje oceny");
	private JList<Ocena> gradesList = new JList<Ocena>();
	private JButton newTestButton = new JButton("Nowy test");
	private JComboBox egzaminyComboBox = new JComboBox();
	private JButton testButton = new JButton("Rozwiąż");


	public MainWindow(String tytul) {
		super(tytul);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 400);
		
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
		
		JLabel lblNewLabel_4 = new JLabel("Moduł uczeń");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		uczen.add(lblNewLabel_4, "cell 0 0");
		testButton.setEnabled(false);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		uczen.add(panel_3, "cell 0 1 6 1,grow");
		panel_3.setLayout(new MigLayout("", "[77px,grow]", "[14px][][]"));
		
		JLabel lblNewLabel_3 = new JLabel("Dostępne testy:");
		panel_3.add(lblNewLabel_3, "cell 0 0,alignx left,aligny top");
		
		panel_3.add(egzaminyComboBox, "cell 0 1,growx");
		
		panel_3.add(testButton, "cell 0 2,alignx right");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		uczen.add(panel_4, "cell 0 2 1 6,grow");
		panel_4.setLayout(new MigLayout("", "[1px][121px,grow][250px]", "[][][][]"));
		//panel_4.add(gradesList, "cell 0 0,alignx left,aligny center");
		gradesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		panel_4.add(showGradesButton, "cell 1 0,alignx left,aligny center");
		
		JScrollPane scrollPane = new JScrollPane(gradesList);
		
		panel_4.add(scrollPane, "cell 1 1 2 3,grow");
		
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

	public JButton getTestButton() {
		return testButton;
	}

	public void setTestButton(JButton testButton) {
		this.testButton = testButton;
	}
	
}
