package gui.mittwoch;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class Knopf extends JButton implements ActionListener{

	public Knopf(String text) {
		super(text);
		
	//		button.setOpaque(false);
		setBackground(new Color(255, 180, 255));
		setBounds(100, 200, 400, 40);
		setFont(new Font("Arial", Font.ROMAN_BASELINE, 32));
		setFocusable(false);
		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		setBackground(Color.WHITE);
		
	}
}
