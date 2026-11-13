package gui.swing;

import java.awt.Color;
import java.awt.event.ItemEvent;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import data.dataHandling.MySqlDataManager;
import data.objekte.Aufgabe;
import data.objekte.Thema;
import gui.swing.appComponents.AppPanel;

public class OverviewPanel extends AppPanel {

	private static final Color BG_COLOR = Color.WHITE;
	private static final String TITLE = "Liste";

	AppComboBox comboBox;
	JList<Aufgabe> liste;

	public OverviewPanel() {
		super(TITLE);
		setBackground(BG_COLOR);
	}

	@Override
	protected void initComponents() {

		Thema[] themen = MySqlDataManager.getInstance().leseAlleThemen();
		if (themen != null) {
			comboBox = new AppComboBox(themen);
			addComponent(comboBox, 0, 0, 100, 10);
		}
		comboBox.addItemListener(e-> itemWasSelected(e));
		
		addComponent(initListPanel(), 0, 1, 100, 90);
	}

	private AppPanel initListPanel() {
		AppPanel p = new AppPanel("Aufgaben") {
			
			@Override
			protected void initComponents() {
				liste = new JList<Aufgabe>(new Aufgabe[0]);
				addComponent(liste, 0, 0, 100, 90);
				liste.setAutoscrolls(true);
			}
		};
		return p;
	}

	private void itemWasSelected(ItemEvent e) {
		
		Thema th = (Thema) e.getItem();
		
		Aufgabe[] all = new Aufgabe[th.getAufgaben().size()];
		int i = 0;
		for (Aufgabe aufgabe : all) {
			all[i++] = aufgabe;
		}	
		
		liste.setListData(all);
//		showMessage(all.toString());
		liste.revalidate();
		liste.repaint();
	}

}
