package gui.swing;

import java.awt.Color;

import javax.swing.JScrollPane;

import gui.swing.appComponents.AppButton;
import gui.swing.appComponents.AppLabel;
import gui.swing.appComponents.AppTextArea;
import gui.swing.appComponents.AppTextField;
import gui.swing.appComponents.AppPanel;

public class FormularPanel extends AppPanel {

	private static final Color BG_COLOR = Color.WHITE;
	private static final String TITLE = "Aufgabe";
	private static final String KEY = "Stichwort zur Aufgabe";
	private static final String TEXT = "Text der Aufgabe";
	private static final String DELETE = "Löschen";
	private static final String NEW = "Neu";
	private static final String SAVE = "Speichern";

	private AppTextField titleField;
	private AppTextArea textArea;

	public FormularPanel() {
		super(TITLE);
		setBackground(BG_COLOR);
	}

	@Override
	protected void initComponents() {

		titleField = new AppTextField();
		textArea = new AppTextArea();

		addComponent(new AppLabel(KEY), 0, 0, 100, 10);
		addComponent(titleField, 0, 1, 100, 10);
		addComponent(new AppLabel(TEXT), 0, 2, 100, 10);
		addComponent(makeTextAreaScrollable(), 0, 3, 100, 80);

		addComponent(initButtons(), 0, 4, 100, 10);

	}

	private AppPanel initButtons() {

		AppPanel p = new AppPanel() {

			@Override
			protected void initComponents() {

				AppButton button;
				
				button = new AppButton(DELETE);
				button.addActionListener(_-> onDelete());
				addComponent(button, 0, 0, 100, 10);
				
				button = new AppButton(NEW);
				addComponent(button, 1, 0, 100, 10);
				button.addActionListener(_-> onNewAufgabe());
				
				button = new AppButton(SAVE);
				addComponent(button, 2, 0, 100, 10);
				button.addActionListener(_-> onSaveAufgabe());
			}
			
		};

		return p;
	}

	private void onDelete() {
		showMessage("Message");
	}
	
	private void onNewAufgabe() {
		showError("Fehler");
	}
	
	private void onSaveAufgabe() {

	}
	
	private JScrollPane makeTextAreaScrollable() {

		return new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	}

}
