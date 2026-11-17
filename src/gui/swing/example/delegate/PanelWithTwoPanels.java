package gui.swing.example.delegate;

import java.awt.GridLayout;

import javax.swing.JPanel;

/**
 * Ein einfaches JPanel, bestehend aus zwei weiteren Panels:<br>
 * einem PanelWithList und einem PanelWithForm.<br>
 * Diese beiden Panels delegieren einige ihrer Funktionalitäten an diese Klasse.<br>
 * Um dies zu gewährleisten, muss diese Klasse entsprechende Interfaces implementieren.
 */
public class PanelWithTwoPanels extends JPanel implements ListItemDelegate, SaveButtonDelegate {

	private PanelWithList listPanel;
	private PanelWithForm formPanel;

	public PanelWithTwoPanels() {

		setLayout(new GridLayout(0, 2));

		listPanel = new PanelWithList();
		listPanel.setItemDelegate(this);
		add(listPanel);

		formPanel = new PanelWithForm();
		formPanel.setSaveButtonDelegate(this);
		add(formPanel);
	}

	@Override
	public void showItem(String item) {
		formPanel.setText(item);
	}

	@Override
	public void save(String data) {
		listPanel.addToList(data);
	}
}
