package data.manager;

import java.util.List;

import data.objekte.Aufgabe;

public class Test {

	public static void main(String[] args) {
		
		FileDataManager manager = new FileDataManager();
		List<Aufgabe> aufgaben = manager.ladeAlleAufgaben();
		
		for (Aufgabe aufgabe : aufgaben) {
			IO.println(aufgabe);
		}
	}

}
