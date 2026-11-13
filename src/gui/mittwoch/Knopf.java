package gui.mittwoch;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Knopf extends JButton implements ActionListener{

	public Knopf(String text) {
		super(text);
		
		setPreferredSize(new Dimension(160, 40));
		
	//		button.setOpaque(false);
		setBackground(new Color(255, 180, 255));
		setBounds(100, 200, 400, 40);
		setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
		setFocusable(false);
//		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		setBackground(Color.WHITE);
		
	}
}
