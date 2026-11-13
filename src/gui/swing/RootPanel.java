package gui.swing;

import java.awt.Color;

import gui.swing.appComponents.AppPanel;

public class RootPanel extends AppPanel {

	private static final Color BG_COLOR = new Color(200, 200, 200);
	
	public RootPanel() {
		super();
		setBackground(BG_COLOR);
	}

	@Override
	protected void initComponents() {
		
		OverviewPanel lp = new OverviewPanel();
		addComponent(lp, 0, 0, 100, 100);
		
		FormularPanel fp = new FormularPanel();
		addComponent(fp, 1, 0, 100, 100);
	}
}
