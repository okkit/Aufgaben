package data.objekte;

import java.util.ArrayList;
import java.util.List;

public class Thema extends AObject {

	private String titel;
	private List<Aufgabe> aufgaben;
		

	public Thema(String titel) throws PleaseNotUseException{
	}

	public Thema(int id, String titel) {
		super(id);
		this.titel = titel;
	}
	
	public void addAufgabe(Aufgabe aufgabe) {
		if (aufgaben == null)
			aufgaben = new ArrayList<Aufgabe>();
		if (aufgaben.contains(aufgabe)) {
			aufgaben.remove(aufgabe);
			aufgaben.add(aufgabe);
			aufgabe.setThema(this);
		}
	}

	public List<Aufgabe> getAufgaben() {
		return aufgaben;
	}

	@SuppressWarnings("unused")
	private void setAufgaben(List<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

	public String getTitel() {
		return titel;
	}

	@SuppressWarnings("unused")
	private void setTitel(String titel) {
		this.titel = titel;
	}

	@Override
	public String[] getObjectData() {
		return null;
	}

}
