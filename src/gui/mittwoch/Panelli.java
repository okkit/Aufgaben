package gui.mittwoch;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Panelli extends JPanel implements ActionListener {

	private JTextField textField;

	/**
	 * Konstruktor
	 */
	public Panelli() {
		super();
		this.setBackground(new Color(90, 160, 220));
		this.setLayout(null);
		initComponents();
	}

	/**
	 * Initialisiert Komponenten, die zum Pannel hinzugefügt werden
	 */
	private void initComponents() {
		initLabel();

		initTextField();
		
		initButton();
	}

	private void initTextField() {
		
		textField = new JTextField();
		add(textField);
		textField.setText("Hallo");
		textField.setBounds(100, 120, 400, 40);		
	}

	/**
	 * Initialisiert und addet einen Button
	 */
	private void initButton() {
		Knopf button = new Knopf("Speichern");
		this.add(button);
		button.addActionListener(this);
	}

	/**
	 * Initialisiert und addet ein Label
	 */
	private void initLabel() {
		Schild labelli = new Schild("Halli Hallo");
		this.add(labelli);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// TODO Das Formular auslesen und in die DB schicken
		String text = textField.getText();
		JOptionPane.showMessageDialog(this, text);
		
	}

}
