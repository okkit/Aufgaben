package data.objekte;

public abstract class AObjectFactory {
	
	public static Aufgabe aufgabeFromData(String[] werte) {

		Aufgabe a = new Aufgabe();
		a.setId(Integer.valueOf(werte[0]));
		a.setNummer(Integer.valueOf(werte[1]));
		a.setThema(werte[2]);
		a.setText(werte[3]);
		
		return a;
	}

}
