package gui.swing.example.twoPannels;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame{

	public MainFrame() {
		super("TwoPanels");
		setBounds(3000, 100, 600, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(0, 2));
		
		PanelOne one = new PanelOne();
		add(one);
		
		PanelTwo two = new PanelTwo();
		add(two);
		
		one.reagierender = two;
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
