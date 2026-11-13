package gui.mittwoch;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JPanel;

public class PanelMitLayout extends JPanel {

	Texteingabe textField = new Texteingabe();

	public PanelMitLayout() {
		super();
		setBackground(Color.BLACK);
		initLayout();
	}

	private void initLayout() {

		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbl.setConstraints(this, gbc);
		setLayout(gbl);
		add(Box.createVerticalStrut(100), gbc);
		add(Box.createHorizontalStrut(100), gbc);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 3;
		gbc.fill = GridBagConstraints.BOTH;

		Schild label = new Schild("Neue Aufgabe erstellen");
		label.setForeground(Color.RED);
		add(label, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		label = new Schild("Titel");
		add(label, gbc);

		add(Box.createVerticalStrut(60), gbc);

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		textField = new Texteingabe();
		add(textField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		label = new Schild("Text");
		add(label, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		label = new Schild("Aufgabentext");
		add(label, gbc);

		add(Box.createVerticalStrut(60), gbc);
		add(Box.createHorizontalStrut(20), gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		Knopf button = new Knopf("Löschen");
		add(button, gbc);

		add(Box.createHorizontalGlue(), gbc);
		add(Box.createHorizontalStrut(20), gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		button = new Knopf("Dublizieren");
		add(button, gbc);

		gbc.gridx = 2;
		gbc.gridy = 3;
		button = new Knopf("Speichern");
		add(button, gbc);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				saveInputData();

			}
		});

	}

	private void saveInputData() {
		// TODO Auto-generated method stub

	}

}
