package gui.swing;

import java.awt.Font;
import java.util.List;

import javax.swing.JComboBox;

import data.objekte.Thema;

public class AppComboBox extends JComboBox<Thema> {

	private static final Font FONT = new Font("SansSerif", Font.PLAIN, 14);

	public AppComboBox() {
		// TODO Auto-generated constructor stub
	}
	
	public AppComboBox(Thema[] items) {
		super(items);
		
		setFont(FONT);
	}

	public AppComboBox(List<Thema> items) {
//		items.add(0, null);
		super((Thema[]) items.toArray());
		
		setFont(FONT);
	}

}
