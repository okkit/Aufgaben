package gui.swing;

import java.awt.Color;
import java.util.List;

import data.dataHandling.MySqlDataManager;
import data.objekte.Aufgabe;
import data.objekte.Thema;
import gui.swing.appComponents.AppPanel;

public class RootPanel extends AppPanel implements OverviewPanelDelegate, FormularPanelDelegate {

	private static final Color BG_COLOR = new Color(200, 200, 200);
	private OverviewPanel overviewPanel;
	private FormularPanel formularPanel;

	public RootPanel() {
		super();
		setBackground(BG_COLOR);
		initComponents();
	}

	/**
	 * 
	 */
	protected void initComponents() {

		Thema[] themen = getThemen();
		overviewPanel = new OverviewPanel(themen);
		overviewPanel.setAufgabenListDelegate(this);
		
		formularPanel = new FormularPanel(themen[0]);
		formularPanel.setFormularPanelDelegate(this);

		addComponent(overviewPanel, 0, 0, 100, 100);
		addComponent(formularPanel, 1, 0, 100, 100);
	}

	/**
	 * 
	 * @return
	 */
	private Thema[] getThemen() {
		List<Thema> liste = MySqlDataManager.getInstance().leseAlleThemen(true);
		Thema[] themen = new Thema[liste.size()];
		int i = 0;
		for (Thema thema : liste)
			themen[i++] = thema;

		return themen;
	}
	
	/**
	 * 
	 * @param th
	 * @return
	 */
	public Aufgabe createNewAufgabe(Thema th) {
		Aufgabe a = new Aufgabe();
		a.setThema(th);
		return a;
	}
	
	@Override
	public void handleThema(Thema th) {
		formularPanel.setTitle(th.getTitel());
		formularPanel.setAufgabe(createNewAufgabe(th));	
	}
	
	@Override
	public void aufgabeWasSelected(Aufgabe a) {

		formularPanel.setAufgabe(a);
	}

	@Override
	public void saveAufgabe(Aufgabe a) {

		String err = MySqlDataManager.getInstance().save(a);
		handleError(err);
		if (err == null)
			overviewPanel.refreshAufgabenList(a.getThema());
	}
	
	@Override
	public void deleteAufgabe(Aufgabe a) {

		Thema th = a.getThema();
		String err = MySqlDataManager.getInstance().delete(a);

		overviewPanel.refreshAufgabenList(th);
		handleError(err);
	}

	@Override
	public void newAufgabe() {
		formularPanel.setAufgabe(createNewAufgabe(overviewPanel.getSelectedThema()));	
	}

}
