package gui.swing.appComponents;

import java.awt.Color;
import java.awt.event.ItemEvent;

import javax.swing.JList;

import data.dataHandling.MySqlDataManager;
import data.objekte.Aufgabe;
import data.objekte.Thema;

public class AppListPanel extends AppPanel {

	private static final Color BG_COLOR = Color.WHITE;
	private static final String TITLE = "Liste";

	AppComboBox comboBox;

	public AppListPanel() {
		super(TITLE);
		setBackground(BG_COLOR);
		initComponents();
	}

	protected void initComponents() {

		IO.println("comboBox");
		Thema[] themen = MySqlDataManager.getInstance().getThemenOverView();
		if (themen != null) {
			comboBox = new AppComboBox(themen);
			addComponent(comboBox, 0, 0, 100, 10);
		}
		comboBox.addItemListener(e-> itemWasSelected(e));
	}

	private void itemWasSelected(ItemEvent e) {
		
		Thema th = (Thema) e.getItem();
		
		Aufgabe[] all = new Aufgabe[th.getAufgaben().size()];
		int i = 0;
		for (Aufgabe aufgabe : all) {
			all[i++] = aufgabe;
		}
		
		JList<Aufgabe> liste = new JList<Aufgabe>(all);
		addComponent(liste, 0, 1, 100, 90);
		
		showMessage("ok");
		revalidate();
		repaint();
	}

}
