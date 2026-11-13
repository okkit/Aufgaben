package gui.mittwoch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Schild extends JLabel{
	
	public Schild(String text) {
		super(text);
		
		setFont(new Font("Arial", Font.ROMAN_BASELINE, 24));
		setForeground(Color.YELLOW);
		
		
		int breite = 0;
		setPreferredSize(new Dimension(200 + breite, 40 + breite));
		setBorder(BorderFactory.createEmptyBorder(breite, breite, breite, breite));
		
//		setBounds(100, 80, 400, 40);
	}

}
