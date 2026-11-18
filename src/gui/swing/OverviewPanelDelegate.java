package gui.swing;

import data.objekte.Aufgabe;
import data.objekte.Thema;

public interface OverviewPanelDelegate {
	
	public void aufgabeWasSelected(Aufgabe a);
	public void handleThema(Thema th);
}
