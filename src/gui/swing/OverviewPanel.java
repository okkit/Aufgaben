package gui.swing;

import java.awt.Color;
import java.awt.event.ItemEvent;

import javax.swing.DefaultListModel;

import data.objekte.AObject;
import data.objekte.Aufgabe;
import data.objekte.Thema;
import gui.swing.appComponents.AppComboBox;
import gui.swing.appComponents.AppList;
import gui.swing.appComponents.AppPanel;

/**
 * 
 */
public class OverviewPanel extends AppPanel {

	private static final Color BG_COLOR = Color.WHITE;
	private static final String THEMEN = "Themen";
	private static final String AUFGABEN = "Aufgaben";

	AppComboBox<Thema> comboBox;
	AppList<Aufgabe> liste;
	
	private OverviewPanelDelegate delegate;
	public void setAufgabenListDelegate(OverviewPanelDelegate aufgabenListDelegate) {
		this.delegate = aufgabenListDelegate;
	}

	/**
	 * 
	 */
	public OverviewPanel(Thema[] themen) {
		super(THEMEN);
		setBackground(BG_COLOR);

		if (themen == null)
			themen = new Thema[0];
		addComponent(initThemenComboBox(themen), 0, 0, 100, 8);
		addComponent(initAufgabenListPanel(themen[0]), 0, 1, 100, 92);
	}

	/**
	 * 
	 * @return
	 */
	private AppComboBox<Thema> initThemenComboBox(Thema[] themen) {

		comboBox = new AppComboBox(themen);
		comboBox.addItemListener(e -> themaWasSelected(e));
		return comboBox;
	}

	/**
	 * 
	 * @param e
	 */
	private void themaWasSelected(ItemEvent e) {

		if (e.getStateChange() != ItemEvent.SELECTED)
			return;
		Thema th = (Thema) e.getItem();
		if (th == null)
			return;
		liste.setModel(createAufgabenListModel(th));
		delegate.handleThema(th);
	}

	/**
	 * 
	 * @param th
	 */
	public void refreshAufgabenList(Thema th) {
		liste.setModel(createAufgabenListModel(th));
		liste.repaint();
	}

	/**
	 * 
	 * @param th
	 * @return
	 */
	private DefaultListModel<AObject> createAufgabenListModel(Thema th) {
		DefaultListModel<AObject> model = (DefaultListModel<AObject>) liste.getModel();
		model.clear();
		if (th.getAufgaben() != null)
			model.addAll(th.getAufgaben());
		return model;
	}
	
	/**
	 * 
	 * @return
	 */
	private AppPanel initAufgabenListPanel(Thema th) {
		AppPanel p = new AppPanel(AUFGABEN);

		DefaultListModel<AObject> model = new DefaultListModel<AObject>();
		model.addAll(th.getAufgaben());
		liste = new AppList<Aufgabe>(model);
		p.addComponent(liste, 0, 0, 100, 90);
		liste.addListSelectionListener(_ -> delegate.aufgabeWasSelected((Aufgabe) liste.getSelectedValue()));

		return p;
	}
	
	public Thema getSelectedThema() {
		return (Thema) comboBox.getSelectedItem();
	}
}
