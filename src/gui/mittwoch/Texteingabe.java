package gui.mittwoch;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class Texteingabe extends JTextField{

	public Texteingabe() {
		super();
		
		setFont(new Font("Arial", Font.ROMAN_BASELINE, 24));
		
		int breite = 0;
		setPreferredSize(new Dimension(300 + breite, 40 + breite));
		setBorder(BorderFactory.createEmptyBorder(breite, breite, breite, breite));
	}
	
	

}
