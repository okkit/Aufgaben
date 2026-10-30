package data.objekte.tests;

import data.objekte.Aufgabe;

public class TestA {

	public static void main(String[] args) {
		
		Aufgabe a = new Aufgabe();
		a.setThema("Klasse");
		a.setText("Schreibe eine Klasse, die ein Haustier beschreibt");

		IO.println(a);
		
		String msg;
		msg = a.save();
		IO.println(msg);
	}

}
