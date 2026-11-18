package gui.swing.example.twoPannels;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOne extends JPanel {
	
	JButton button;

//	PanelTwo reagierender;
	AufButtonReagierender reagierender;
	
	public PanelOne() {
		super();
		button = new JButton("Button of the PanelOne");
		add(button);
		
		button.addActionListener(_-> derButtonWurdeGeklickt());
	}

	private void derButtonWurdeGeklickt() {
//		button.setBackground(Color.BLACK);
		reagierender.reagiere();
	}

}
