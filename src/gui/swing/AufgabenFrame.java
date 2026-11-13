package gui.swing;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class AufgabenFrame extends JFrame{
	
	public static final Rectangle BOUNDS = new Rectangle(3000, 200, 600, 400);
	private static final String IMAGE_FILE = "./rsrc/img/OIP.png";
	
	public AufgabenFrame() {
		
		setBounds(BOUNDS);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon img = new ImageIcon(IMAGE_FILE);
		setIconImage(img.getImage());
		
		add(new RootPanel());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new AufgabenFrame();
	}

}
