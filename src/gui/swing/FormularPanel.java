package gui.swing;

import java.awt.Color;

import javax.swing.JScrollPane;

import data.objekte.Aufgabe;
import data.objekte.Thema;
import gui.swing.appComponents.AppButton;
import gui.swing.appComponents.AppLabel;
import gui.swing.appComponents.AppPanel;
import gui.swing.appComponents.AppTextArea;
import gui.swing.appComponents.AppTextField;

public class FormularPanel extends AppPanel {

	private static final Color BG_COLOR = Color.WHITE;
	private static final String KEY = "Stichwort zur Aufgabe";
	private static final String TEXT = "Text der Aufgabe";
	private static final String DELETE = "Löschen";
	private static final String NEW = "Neu";
	private static final String SAVE = "Speichern";

	private AppTextField titleField;
	private AppTextArea textArea;

	private Aufgabe currentAufgabe;
	
	private FormularPanelDelegate formularPanelDelegate;
	
	public void setFormularPanelDelegate(FormularPanelDelegate delegate) {
		formularPanelDelegate = delegate;
	}

	/**
	 * @param th 
	 * 
	 */
	public FormularPanel(Thema th) {
		super(th.getTitel());
		setBackground(BG_COLOR);
		initComponents();
		currentAufgabe = new Aufgabe();
		currentAufgabe.setThema(th);
	}

	/**
	 * 
	 */
	protected void initComponents() {

		titleField = new AppTextField();
		textArea = new AppTextArea();

		addComponent(new AppLabel(KEY), 0, 0, 100, 10);
		addComponent(titleField, 0, 1, 100, 10);
		addComponent(new AppLabel(TEXT), 0, 2, 100, 10);
		addComponent(makeTextAreaScrollable(), 0, 3, 100, 80);

		addComponent(initButtons(), 0, 4, 100, 10);
	}

	/**
	 * 
	 * @return
	 */
	private AppPanel initButtons() {

		AppPanel p = new AppPanel();
		AppButton button;

		button = new AppButton(DELETE);
		button.addActionListener(_ -> deleteAufgabe());
		p.addComponent(button, 0, 0, 100, 10);

		button = new AppButton(NEW);
		p.addComponent(button, 1, 0, 100, 10);
		button.addActionListener(_ -> newAufgabe());

		button = new AppButton(SAVE);
		p.addComponent(button, 2, 0, 100, 10);
		button.addActionListener(_ -> saveAufgabe());

		return p;
	}

	/**
	 * 
	 * @return
	 */
	private void deleteAufgabe() {
		formularPanelDelegate.deleteAufgabe(currentAufgabe);
	}

	/**
	 * 
	 * @return
	 */
	private void newAufgabe() {
		formularPanelDelegate.newAufgabe();
	}

	/**
	 * 
	 */
	private void saveAufgabe() {
		
		String key = titleField.getText();
		if (key == null || key.isEmpty()) {
			showError("ERROR_TITLE");
		}
		String text = textArea.getText();
		if (key == null || key.isEmpty()) {
			showError("ERROR_TEXT");
		}
		if (currentAufgabe == null) {
			currentAufgabe = new Aufgabe();
		}

		currentAufgabe.setTitel(key);
		currentAufgabe.setText(text);
		formularPanelDelegate.saveAufgabe(currentAufgabe);
	}

	/**
	 * 
	 */
	public void setAufgabe(Aufgabe a) {
		currentAufgabe = a;
		titleField.setText(a == null ? null : a.getTitel());
		textArea.setText(a == null ? null : a.getText());
	}
	
	/**
	 * 
	 * @return
	 */
	private JScrollPane makeTextAreaScrollable() {

		return new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}

}
