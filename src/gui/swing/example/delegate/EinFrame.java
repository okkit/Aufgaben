package gui.swing.example.delegate;

import javax.swing.JFrame;

public class EinFrame extends JFrame{

	public EinFrame() {

		super("Exampe");
		setBounds(2800, 100, 400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		add(new PanelWithTwoPanels());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new EinFrame();
	}

}
