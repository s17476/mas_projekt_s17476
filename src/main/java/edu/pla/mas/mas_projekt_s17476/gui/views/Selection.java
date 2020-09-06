package edu.pla.mas.mas_projekt_s17476.gui.views;

import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import edu.pla.mas.mas_projekt_s17476.model.PytanieEgzaminacyjne;
import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

public class Selection extends JFrame {

	public JFrame frame  =this; 
	private MainWindow mainWindow;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel label = new JLabel();
	private JLabel answerLabel = new JLabel("");
	private JTextField txtPrzykad = new JTextField();
	
	private JButton anulujButton = new JButton("Anuluj");
	private DefaultListModel<PytanieEgzaminacyjne> listModel = new DefaultListModel<>();
	
	private JButton dodajButton = new JButton("DODAJ ->");
	private JButton usunButton = new JButton("<- USUŃ");
	
	private JList<PytanieEgzaminacyjne> list = new JList<>(listModel);
	
	private DefaultListModel<PytanieEgzaminacyjne> list1Model = new DefaultListModel<>();
	private JList<PytanieEgzaminacyjne> list_1 = new JList<>(list1Model);
	private JLabel przedmiotLabel = new JLabel();

	private JButton newQuestion = new JButton("Nowe pytanie");
	
	private JButton createExam = new JButton("Utwórz egzamin");

	/**
	 * Create the frame.
	 */
	public Selection(String name) {
		super(name);

		setPreferredSize(new Dimension(1000, 550));
		setResizable(false);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[400px:400px:400px][128px][400px:400px:400px]", "[14px][14px][183px][14px][10px][][14px][grow]"));
		
		contentPane.add(przedmiotLabel, "cell 0 0 3 1,alignx center,aligny top");
		
		JLabel lblNewLabel_1 = new JLabel("Dostępne:");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx left,aligny top");
		
		JLabel lblNewLabel_2 = new JLabel("Wybrane:");
		contentPane.add(lblNewLabel_2, "cell 2 1,alignx left,aligny top");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 1 2,grow");
		panel.setLayout(new MigLayout("", "[grow][][]", "[][][][]"));
		
		panel.add(usunButton, "cell 0 1 3 1,growx,aligny center");
		
		panel.add(dodajButton, "cell 0 2 3 1,growx,aligny center");
		
		panel.add(newQuestion, "cell 0 3 3 1,growx,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Wybrane pytanie:");
		contentPane.add(lblNewLabel_3, "cell 0 3,alignx left,aligny top");

		label.setHorizontalAlignment(SwingConstants.LEFT);
		
		answerLabel.setHorizontalAlignment(SwingConstants.LEFT);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		contentPane.add(list, "cell 0 2,grow");
		
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list_1, "cell 2 2,grow");
				
		JPanel panel_5 = new JPanel();
		contentPane.add(panel_5, "cell 2 3 1 4,grow");
		panel_5.setLayout(new MigLayout("", "[][grow]", "[20px][20px][20px][20px]"));
			
		JLabel lblNewLabel_7 = new JLabel("Tytuł:");
		panel_5.add(lblNewLabel_7, "cell 0 0,alignx right");
		panel_5.add(txtPrzykad, "cell 1 0,growx,aligny top");
				
				
		txtPrzykad.setText("Przykład");
		txtPrzykad.setColumns(10);
				
		JLabel lblNewLabel_8 = new JLabel("Dostępny czas:");
		panel_5.add(lblNewLabel_8, "cell 0 1,alignx right");
				
		textField_1 = new JTextField();
		panel_5.add(textField_1, "cell 1 1,growx,aligny top");
		textField_1.setText("30");
		textField_1.setColumns(10);
				
		JLabel lblNewLabel_9 = new JLabel("Dostępny od:");
		panel_5.add(lblNewLabel_9, "cell 0 2,alignx right");
				
		textField_2 = new JTextField();
		panel_5.add(textField_2, "cell 1 2,growx,aligny top");
		textField_2.setText("2020-07-13");
		textField_2.setColumns(10);				
				
		JLabel lblNewLabel_10 = new JLabel("Dostępny do:");
		panel_5.add(lblNewLabel_10, "cell 0 3,alignx right");
				
		textField_3 = new JTextField();
		panel_5.add(textField_3, "cell 1 3,growx,aligny top");
		textField_3.setText("2020-07-14");
		textField_3.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, "cell 0 4,alignx left,growy");

		panel_1.add(label);
				
		JLabel lblNewLabel_5 = new JLabel("Odpowiedzi:");
		contentPane.add(lblNewLabel_5, "cell 0 5,alignx left,aligny top");
				
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, "cell 0 6 2 2,grow");
		panel_3.setLayout(new MigLayout("", "[12px,grow]", "[12px,grow]"));
			
		panel_3.add(answerLabel, "cell 0 0,growx,aligny top");

		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, "cell 2 7,alignx right,aligny bottom");

		panel_4.add(anulujButton);

		panel_4.add(createExam);		

		pack();
		setLocationRelativeTo(null);
	}

	public JButton getAnulujButton() {
		return anulujButton;
	}


	public DefaultListModel<PytanieEgzaminacyjne> getListModel() {
		return listModel;
	}


	public JButton getDodajButton() {
		return dodajButton;
	}


	public JList<PytanieEgzaminacyjne> getList() {
		return list;
	}


	public JLabel getLabel() {
		return label;
	}


	public DefaultListModel<PytanieEgzaminacyjne> getList1Model() {
		return list1Model;
	}


	public JList<PytanieEgzaminacyjne> getList_1() {
		return list_1;
	}


	public JButton getUsunButton() {
		return usunButton;
	}


	public JLabel getPrzedmiotLabel() {
		return przedmiotLabel;
	}


	public JLabel getAnswerLabel() {
		return answerLabel;
	}


	public JButton getNewQuestion() {
		return newQuestion;
	}


	public JButton getCreateExam() {
		return createExam;
	}


	public JTextField getTxtPrzykad() {
		return txtPrzykad;
	}


	public void setTxtPrzykad(JTextField txtPrzykad) {
		this.txtPrzykad = txtPrzykad;
	}


	public JTextField getTextField_1() {
		return textField_1;
	}


	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}


	public JTextField getTextField_2() {
		return textField_2;
	}


	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}


	public JTextField getTextField_3() {
		return textField_3;
	}


	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}
	
	
	
}


