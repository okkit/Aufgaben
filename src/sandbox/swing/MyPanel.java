package sandbox.swing;

import javax.swing.JPanel;

import sandbox.GuiConstants;

public abstract class MyPanel extends JPanel {

	public MyPanel() {
		super();
		setFont(GuiConstants.FONT);
		initLayout();
		initComponents();
	}
	
	protected abstract void initLayout();
	protected abstract void initComponents();

}
