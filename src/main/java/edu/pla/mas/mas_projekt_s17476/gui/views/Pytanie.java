package edu.pla.mas.mas_projekt_s17476.gui.views;

import java.awt.Dimension;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import edu.pla.mas.mas_projekt_s17476.model.Przedmiot;
import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

public class Pytanie extends JFrame {

	private JPanel contentPane;

	public JFrame parent;
	public JFrame frame = this;
	public Przedmiot przedmiot;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private ButtonGroup buttonGroup = new ButtonGroup();
	private ButtonGroup buttonGroup_1 = new ButtonGroup();
	private ButtonGroup buttonGroup2 = new ButtonGroup();
	private ButtonGroup buttonGroup3 = new ButtonGroup();
	private ButtonGroup buttonGroup4 = new ButtonGroup();
	
	private JButton cancelButton = new JButton("Anuluj");
	private JButton dodajButton = new JButton("Dodaj");

	private JRadioButton rdbtnNewRadioButton = new JRadioButton();
	private JRadioButton rdbtnNewRadioButton_2 = new JRadioButton();
	private JRadioButton rdbtnNewRadioButton_4 = new JRadioButton();
	private JRadioButton rdbtnNewRadioButton_6 = new JRadioButton();
	
	
	public Pytanie(String name) {
		super(name);

		setPreferredSize(new Dimension(500, 200));
		setResizable(false);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][40px,center][40px,center]", "[][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Twoje pytanie:");
		contentPane.add(lblNewLabel, "cell 1 0 3 1");
		
		textField = new JTextField();
		contentPane.add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Odpowiedzi:");
		contentPane.add(lblNewLabel_1, "cell 1 2");
		
		JLabel lblNewLabel_3 = new JLabel("Fałsz");
		contentPane.add(lblNewLabel_3, "cell 2 2");
		
		JLabel lblNewLabel_2 = new JLabel("Prawda");
		contentPane.add(lblNewLabel_2, "cell 3 2");
		
		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 1 3,growx");
		textField_1.setColumns(10);
		
		buttonGroup.add(rdbtnNewRadioButton);
		contentPane.add(rdbtnNewRadioButton, "cell 2 3");
		rdbtnNewRadioButton.setSelected(true);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton();
		buttonGroup.add(rdbtnNewRadioButton_1);
		contentPane.add(rdbtnNewRadioButton_1, "cell 3 3");
		
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);
		
		textField_2 = new JTextField();
		contentPane.add(textField_2, "cell 1 4,growx");
		textField_2.setColumns(10);
		
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		contentPane.add(rdbtnNewRadioButton_2, "cell 2 4");
		rdbtnNewRadioButton_2.setSelected(true);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton();
		buttonGroup_1.add(rdbtnNewRadioButton_3);
		contentPane.add(rdbtnNewRadioButton_3, "cell 3 4");
		
		buttonGroup2.add(rdbtnNewRadioButton_2);
		buttonGroup2.add(rdbtnNewRadioButton_3);
		
		textField_3 = new JTextField();
		contentPane.add(textField_3, "cell 1 5,growx");
		textField_3.setColumns(10);
		
		contentPane.add(rdbtnNewRadioButton_4, "cell 2 5");
		rdbtnNewRadioButton_4.setSelected(true);
		
		JRadioButton rdbtnNewRadioButton_5 = new JRadioButton();
		contentPane.add(rdbtnNewRadioButton_5, "cell 3 5");
		
		buttonGroup3.add(rdbtnNewRadioButton_4);
		buttonGroup3.add(rdbtnNewRadioButton_5);

		textField_4 = new JTextField();
		contentPane.add(textField_4, "cell 1 6,growx");
		textField_4.setColumns(10);
		
		contentPane.add(rdbtnNewRadioButton_6, "cell 2 6");
		rdbtnNewRadioButton_6.setSelected(true);
		
		JRadioButton rdbtnNewRadioButton_7 = new JRadioButton();
		contentPane.add(rdbtnNewRadioButton_7, "cell 3 6");
		
		buttonGroup4.add(rdbtnNewRadioButton_6);
		buttonGroup4.add(rdbtnNewRadioButton_7);

		JSeparator separator = new JSeparator();
		contentPane.add(separator, "cell 0 7 4 1,grow");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 8 3 1,alignx right,growy");
		
		panel.add(cancelButton);
		
		panel.add(dodajButton);
		
		setLocationRelativeTo(null);

	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getDodajButton() {
		return dodajButton;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
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

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}

	public ButtonGroup getButtonGroup_1() {
		return buttonGroup_1;
	}

	public void setButtonGroup_1(ButtonGroup buttonGroup_1) {
		this.buttonGroup_1 = buttonGroup_1;
	}

	public ButtonGroup getButtonGroup2() {
		return buttonGroup2;
	}

	public void setButtonGroup2(ButtonGroup buttonGroup2) {
		this.buttonGroup2 = buttonGroup2;
	}

	public ButtonGroup getButtonGroup3() {
		return buttonGroup3;
	}

	public void setButtonGroup3(ButtonGroup buttonGroup3) {
		this.buttonGroup3 = buttonGroup3;
	}

	public ButtonGroup getButtonGroup4() {
		return buttonGroup4;
	}

	public void setButtonGroup4(ButtonGroup buttonGroup4) {
		this.buttonGroup4 = buttonGroup4;
	}

	public JRadioButton getRdbtnNewRadioButton() {
		return rdbtnNewRadioButton;
	}

	public void setRdbtnNewRadioButton(JRadioButton rdbtnNewRadioButton) {
		this.rdbtnNewRadioButton = rdbtnNewRadioButton;
	}

	public JRadioButton getRdbtnNewRadioButton_2() {
		return rdbtnNewRadioButton_2;
	}

	public void setRdbtnNewRadioButton_2(JRadioButton rdbtnNewRadioButton_2) {
		this.rdbtnNewRadioButton_2 = rdbtnNewRadioButton_2;
	}

	public JRadioButton getRdbtnNewRadioButton_4() {
		return rdbtnNewRadioButton_4;
	}

	public void setRdbtnNewRadioButton_4(JRadioButton rdbtnNewRadioButton_4) {
		this.rdbtnNewRadioButton_4 = rdbtnNewRadioButton_4;
	}

	public JRadioButton getRdbtnNewRadioButton_6() {
		return rdbtnNewRadioButton_6;
	}

	public void setRdbtnNewRadioButton_6(JRadioButton rdbtnNewRadioButton_6) {
		this.rdbtnNewRadioButton_6 = rdbtnNewRadioButton_6;
	}
	
}
