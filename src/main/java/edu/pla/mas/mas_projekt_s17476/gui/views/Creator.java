package edu.pla.mas.mas_projekt_s17476.gui.views;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import edu.pla.mas.mas_projekt_s17476.model.Grupa;
import edu.pla.mas.mas_projekt_s17476.model.Przedmiot;
import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

public class Creator extends JFrame {

	private JPanel contentPane;

	private JButton cancelButton = new JButton("Anuluj");
	
	private JComboBox<Przedmiot> comboPrzedmiot = new JComboBox<Przedmiot>();
	
	private JComboBox<Grupa> comboGrupa = new JComboBox<Grupa>();
	
	private JButton dalejButton = new JButton("Dalej");
	
	/**
	 * Create the frame.
	 */
	public Creator(String name) {
		super(name);

		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][200px,grow][grow]", "[][][][][][][][][][][][][]"));
		
		JLabel lblNewLabel = new JLabel("Wybierz grupę i przedmiot");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel, "cell 0 1 3 1,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Przedmiot");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_2, "cell 1 3");
		
		contentPane.add(comboGrupa, "cell 1 9,growx");
		
		contentPane.add(comboPrzedmiot, "cell 1 5,growx");
		
		JLabel lblNewLabel_1 = new JLabel("Grupa");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblNewLabel_1, "cell 1 7");
		
		JSeparator separator = new JSeparator();
		contentPane.add(separator, "cell 1 11,grow");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 12 3 1,growx");
	
		panel.add(cancelButton);
		panel.add(dalejButton);
		setResizable(false);
		setLocationRelativeTo(null);

	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JComboBox getComboPrzedmiot() {
		return comboPrzedmiot;
	}

	public JComboBox getComboGrupa() {
		return comboGrupa;
	}

	public JButton getDalejButton() {
		return dalejButton;
	}

}