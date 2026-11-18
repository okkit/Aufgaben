package gui.swing.appComponents;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JComboBox;

import data.objekte.AObject;

public class AppComboBox<T extends AObject> extends JComboBox<AObject> {

	private static final Color BG_COLOR = Color.WHITE;
	private static final Font FONT = new Font("SansSerif", Font.PLAIN, 14);


	public AppComboBox(AObject[] items) {
		super(items);
		setBackground(BG_COLOR);
		setFont(FONT);
	}
}
