package gui.swing.example.twoPannels;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTwo extends JPanel implements AufButtonReagierender{
	
	JLabel label;
	
	public PanelTwo() {
		super();
		label = new JLabel("Label of the PanelTwo");
		
		add(label);
	}

	@Override
	public void reagiere() {
		
		setBackground(Color.GREEN);
		
	}

}
