package gui.mittwoch;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Mittwoch extends JFrame{
	
	public static void main(String[] args) {

		
		new Mittwoch();
	}

	public Mittwoch() {
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		setBounds(3000, 100, 600, 400);
		
		ImageIcon img = new ImageIcon("./rsrc/img/OIP.png");
		setIconImage(img.getImage());
		
		initComponents();
		setVisible(true);			
	}	
		
	private void initComponents() {
		
		Panelli panellli = new Panelli();
		add(panellli);
//		add(new PanelMitLayout());
	}

}
