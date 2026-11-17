package gui.swing.example.delegate;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Eine sehr einfache Klasse für ein Panel mit einem TextField und einem
 * Button.<br>
 * 
 * Die Klasse besitzt einen Delegate, an den nach dem Klicken des Buttons<br>
 * weiter deligiert wird.
 */
public class PanelWithForm extends JPanel {

	private JTextField textField;
	private JButton button;
	
	private SaveButtonDelegate delegate;
	public void setSaveButtonDelegate(SaveButtonDelegate delegate) {
		this.delegate = delegate;
	}

	public PanelWithForm() {
		super();
		setLayout(new GridLayout(0, 1));

		add(new JLabel("Geben Sie Ihren Namen ein"));
		add(textField = new JTextField());

		button = new JButton("Speichern");
		button.addActionListener(_ -> delegate.save(textField.getText()));
		add(button);
	}

	public void setText(String text) {
		textField.setText(text);
	}

}
