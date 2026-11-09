package data.dataHandling;

import java.util.List;

import data.objekte.Aufgabe;
import data.objekte.Thema;

public class TestDataManager {

	public static void main(String[] args) {

		List<Thema> themen = MySqlDataManager.getInstance().leseAlleThemen(true);
		
		for (Thema th : themen) {
			IO.println(th.toString());
			for(Aufgabe a: th.getAufgaben())
				IO.println(a);
		}
	}
}
