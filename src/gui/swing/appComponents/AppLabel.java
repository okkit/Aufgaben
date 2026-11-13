package gui.swing.appComponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class AppLabel extends JLabel{
	
	private static final Font LABEL_FONT = new Font("SansSerif", Font.ITALIC, 16);
	private static final Color LABEL_COLOR = new Color(80, 120, 190);

	public AppLabel(String text) {
		super(text);
		setFont(LABEL_FONT);
		setForeground(LABEL_COLOR);
	}

}
