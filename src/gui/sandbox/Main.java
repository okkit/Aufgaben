package gui.sandbox;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Der erste Versuch mit Swing
 */
public class Main {

	public static void main(String[] args) {
		
		JFrame myFrame = new JFrame("First down");
				
		myFrame.setBounds(3000, 100, 400, 300);		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		myFrame.setLayout(new GridLayout(0, 2));
		
		JPanel panel = new JPanel();
		panel.setSize(100, 100);
		panel.setBackground(Color.BLACK);
		myFrame.add(panel);
		
		JLabel label = new JLabel("Hallo");
		panel.add(label);
		label.setFont(new Font("Helvetica", Font.PLAIN, 30));
		label.setForeground(Color.WHITE);
		
		panel = new JPanel();
		panel.setSize(200, 100);
		panel.setBackground(new Color(90, 140, 230));		
		myFrame.add(panel);
		
		JButton button = new JButton("Kickoff");
		button.setFont(new Font("Helvetica", Font.PLAIN, 30));
		button.setFocusable(false);
		panel.add(button);
		
		myFrame.setVisible(true);
		
		

	}

}
