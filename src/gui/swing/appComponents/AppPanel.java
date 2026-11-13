package gui.swing.appComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public abstract class AppPanel extends JPanel {

	private static final Font PANEL_TITEL_FONT = new Font("SansSerif", Font.ITALIC, 18);
	private GridBagConstraints constraints;

	public AppPanel() {
		super();
		initLayout();
		initComponents();
	}

	public AppPanel(String title) {
		this();

		TitledBorder border = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), title,
				TitledBorder.DEFAULT_JUSTIFICATION, // Justification
				TitledBorder.DEFAULT_POSITION, // Position
				PANEL_TITEL_FONT, // Title Font
				Color.GRAY // Title Color
		);
		setBorder(border);
	}

	protected abstract void initComponents();

	protected void addComponent(JComponent comp, int col, int row, int width, int height) {

		constraints.gridx = col;
		constraints.gridy = row;

		constraints.weightx = width / 100.;
		constraints.weighty = height / 100.;

		add(comp, constraints);
	}

	private void initLayout() {
		GridBagLayout gbl = new GridBagLayout();
		constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.PAGE_START;
		gbl.setConstraints(this, constraints);
		setLayout(gbl);
		constraints.fill = GridBagConstraints.BOTH;
	}
	
	protected void showMessage(String text) {
		popUp("Info", text, JOptionPane.PLAIN_MESSAGE);
	}
	
	protected void showError(String text) {
		popUp("Fehler", text, JOptionPane.ERROR_MESSAGE);
	}
	
	private void popUp(String title, String text, int art) {
		JOptionPane.showMessageDialog(this, text, title, art);
	}
}
