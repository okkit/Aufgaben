package gui.swing.appComponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class AppButton extends JButton{

	private static final Font TITTLE_FONT = new Font("SansSerif", Font.PLAIN, 16);
	private static final Color TEXT_COLOR = Color.BLACK;

	public AppButton(String title) {
		super(title);
		setFont(TITTLE_FONT);
		setFocusable(false);
		setBackground(Color.WHITE);
		setForeground(TEXT_COLOR);
		setBorderPainted(false);
	}

}
