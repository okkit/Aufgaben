package gui.mittwoch;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Schild extends JLabel{
	
	public Schild(String text) {
		super(text);
		
		setFont(new Font("Arial", Font.ROMAN_BASELINE, 32));
		setForeground(Color.YELLOW);
		
		setBounds(100, 80, 400, 40);
	}

}
