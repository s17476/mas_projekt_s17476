package edu.pla.mas.mas_projekt_s17476.gui.views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

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
	JLabel label = new JLabel();
	JLabel answerLabel = new JLabel("");
	JTextField txtPrzykad = new JTextField();
	
	JButton anulujButton = new JButton("Anuluj");
	DefaultListModel<PytanieEgzaminacyjne> listModel = new DefaultListModel<>();
	
	JButton dodajButton = new JButton("DODAJ ->");
	JButton usunButton = new JButton("<- USUŃ");
	
	JList<PytanieEgzaminacyjne> list = new JList<>(listModel);
	
	DefaultListModel<PytanieEgzaminacyjne> list1Model = new DefaultListModel<>();
	JList<PytanieEgzaminacyjne> list_1 = new JList<>(list1Model);
	JLabel przedmiotLabel = new JLabel();

	JButton newQuestion = new JButton("Nowe pytanie");
	
	JButton createExam = new JButton("Utwórz egzamin");

	/**
	 * Create the frame.
	 */
	public Selection(String name) {
		super(name);

		setPreferredSize(new Dimension(1000, 450));
		setResizable(false);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[300px:n:300px,grow][128px][300px:n:300px,grow]", "[14px][14px][183px][14px][10px][][14px][78px,grow]"));
		
		
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
				
				JLabel lblNewLabel_7 = new JLabel("Tytuł:");
				contentPane.add(lblNewLabel_7, "cell 1 3,alignx right");
		
				JPanel panel_1 = new JPanel();
				contentPane.add(panel_1, "cell 0 4,alignx left,growy");
				
				JLabel lblNewLabel_8 = new JLabel("Dostępny czas:");
				contentPane.add(lblNewLabel_8, "cell 1 4,alignx trailing");
				
				textField_1 = new JTextField();
				textField_1.setText("30");
				contentPane.add(textField_1, "cell 2 4,growx");
				textField_1.setColumns(10);
				
				JLabel lblNewLabel_9 = new JLabel("Dostępny od:");
				contentPane.add(lblNewLabel_9, "cell 1 5,alignx trailing");
				
				JLabel lblNewLabel_5 = new JLabel("Odpowiedzi:");
				contentPane.add(lblNewLabel_5, "cell 0 6,alignx left,aligny top");
				
				JPanel panel_2 = new JPanel();

				panel_1.add(label);
				
				JLabel lblNewLabel_10 = new JLabel("Dostępny do:");
				contentPane.add(lblNewLabel_10, "cell 1 6,alignx right");
				
				JPanel panel_3 = new JPanel();
				contentPane.add(panel_3, "cell 0 7,alignx left,growy");
				
				panel_3.add(answerLabel);
				
				JPanel panel_4 = new JPanel();
				contentPane.add(panel_4, "cell 2 7,alignx center,aligny center");
				

				panel_4.add(anulujButton);
				
				

				panel_4.add(createExam);
				
				
				txtPrzykad.setText("Przykład");
				contentPane.add(txtPrzykad, "cell 2 3,growx");
				txtPrzykad.setColumns(10);
				
				textField_3 = new JTextField();
				textField_3.setText("2020-07-14");
				contentPane.add(textField_3, "cell 2 6,growx");
				textField_3.setColumns(10);
				
				textField_2 = new JTextField();
				textField_2.setText("2020-07-13");
				contentPane.add(textField_2, "cell 2 5,growx");
				textField_2.setColumns(10);				
	
		

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


