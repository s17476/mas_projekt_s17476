package edu.pla.mas.mas_projekt_s17476.gui.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import edu.pla.mas.mas_projekt_s17476.model.Egzamin;
import edu.pla.mas.mas_projekt_s17476.model.Osoba;
import edu.pla.mas.mas_projekt_s17476.model.PytanieEgzaminacyjne;
import net.miginfocom.swing.MigLayout;

/**
 * 
 * @author Grzegorz Frączek
 *
 */

public class EgzaminView extends JFrame {
	private JFrame parent;
	private JPanel contentPane;
	private Egzamin egzamin;
	public PytanieEgzaminacyjne pe;
	public Osoba osoba;
	JLabel titleLabel = new JLabel("");
	JLabel timerLabel = new JLabel("00:00");
	JButton endExam = new JButton("ZAKOŃCZ EGZAMIN");
	Map<PytanieEgzaminacyjne, Map<String, JCheckBox>> test = new HashMap<>();

	/**
	 * Create the frame.
	 */
	public EgzaminView(String name, Egzamin egzamin) {
		super(name);
		this.egzamin = egzamin;
		setBounds(100, 100, 1153, 694);
		setPreferredSize(new Dimension(1200, 700));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][grow][]", "[][][grow][]"));
		
		
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(titleLabel, "cell 0 0");
			
		JLabel lblNewLabel_2 = new JLabel("Czas pozostały do końca egzaminu:");
		contentPane.add(lblNewLabel_2, "flowx,cell 2 1,alignx right");
			
		
		contentPane.add(timerLabel, "cell 2 1,alignx right");
			
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 2 4 1,grow");
			
		JPanel panel = new JPanel();
		
		scrollPane.setViewportView(panel);
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][][][][][]"));
			
		
			
		
		
		/**
		 * dodaje pytania  i odpowiedzi do paneli
		 */
		for (int i = 0; i < egzamin.getPytaniaEgzaminacyjne().size(); i++) {
			
			pe = egzamin.getPytaniaEgzaminacyjne().get(i);
			
			Map<String, JCheckBox> check = new HashMap<>();
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			JSeparator separator = new JSeparator();
			
			panel.add(panel_1, "cell 0 "+i+",grow");
			panel_1.setLayout(new MigLayout("", "[][grow][center]", "[][][][][]"));
			
			JLabel lblNewLabel_3 = new JLabel(pe.getTrescPytania());
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
			panel_1.add(lblNewLabel_3, "cell 1 0");
			panel_1.add(separator, "cell 1 1,grow");
			
			List<String> odpowiedzi = new ArrayList<>(); 
			pe.getDobreOdpowiedzi().stream().forEach(x -> {
				odpowiedzi.add(x);
			});
			pe.getZleOdpowiedzi().stream().forEach(x -> {
				odpowiedzi.add(x);
			});
			
			Collections.shuffle(odpowiedzi);
			
			JLabel lblNewLabel_4 = new JLabel(odpowiedzi.get(0));
			panel_1.add(lblNewLabel_4, "cell 1 2");
			
			JCheckBox chckbxNewCheckBox = new JCheckBox("");
			panel_1.add(chckbxNewCheckBox, "cell 2 2");
			check.put(odpowiedzi.get(0), chckbxNewCheckBox);
			
			JLabel lblNewLabel_5 = new JLabel(odpowiedzi.get(1));
			panel_1.add(lblNewLabel_5, "cell 1 3");
			
			JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
			panel_1.add(chckbxNewCheckBox_1, "cell 2 3");
			
			check.put(odpowiedzi.get(1), chckbxNewCheckBox_1);
			
			JLabel lblNewLabel_6 = new JLabel(odpowiedzi.get(2));
			panel_1.add(lblNewLabel_6, "cell 1 4");
			
			JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
			panel_1.add(chckbxNewCheckBox_2, "cell 2 4");
			
			check.put(odpowiedzi.get(2), chckbxNewCheckBox_2);
			
			JLabel lblNewLabel_7 = new JLabel(odpowiedzi.get(3));
			panel_1.add(lblNewLabel_7, "cell 1 5");
			
			
			JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
			panel_1.add(chckbxNewCheckBox_3, "cell 2 5");	
			
			check.put(odpowiedzi.get(3), chckbxNewCheckBox_3);
			
			test.put(pe, check);
		}
		
		
		

		

		
		/**
		 * blokuje okno
		 */
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		endExam.setBackground(Color.RED);
		contentPane.add(endExam, "cell 2 3,alignx center");
	}

	public JLabel getTitleLabel() {
		return titleLabel;
	}

	public void setTitleLabel(JLabel titleLabel) {
		this.titleLabel = titleLabel;
	}

	public void setEgzamin(Egzamin egzamin) {
		this.egzamin = egzamin;
	}

	public JLabel getTimerLabel() {
		return timerLabel;
	}

	public void setTimerLabel(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}

	public JButton getEndExam() {
		return endExam;
	}

	public void setEndExam(JButton endExam) {
		this.endExam = endExam;
	}

	public Map<PytanieEgzaminacyjne, Map<String, JCheckBox>> getTest() {
		return test;
	}

	public void setTest(Map<PytanieEgzaminacyjne, Map<String, JCheckBox>> test) {
		this.test = test;
	}

	
	
}