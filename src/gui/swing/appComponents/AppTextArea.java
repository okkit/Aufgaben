package gui.swing.appComponents;

import java.awt.Font;

import javax.swing.JTextArea;

public class AppTextArea extends JTextArea {
	private static final Font TEXT_FONT = new Font("SansSerif", Font.ITALIC, 16);

	public AppTextArea() {
		super();
		setFont(TEXT_FONT);
	}

}
