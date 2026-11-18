package gui.swing;

import data.objekte.Aufgabe;

public interface FormularPanelDelegate {

	public void saveAufgabe(Aufgabe a);

	public void deleteAufgabe(Aufgabe a);

	public void newAufgabe();

}
