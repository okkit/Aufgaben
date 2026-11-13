package gui.swing.appComponents;

import java.awt.Font;

import javax.swing.JTextField;

public class AppTextField extends JTextField {
	
	private static final Font TEXT_FONT = new Font("SansSerif", Font.ITALIC, 16);

	public AppTextField() {
		super();
		setFont(TEXT_FONT);
	}

}
