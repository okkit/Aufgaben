package data.dataHandling;

import data.objekte.Aufgabe;

public class TestDataManager {
	
	public static void main(String[] args) {
		
		Aufgabe a = null;
		
//		DataManager mng = new SCVDataManager(); --> viele Instanzen möglich
		DataManager mng = SCVDataManager.getInstance(); // nur eine Instanz möglich
		IO.println(mng);
		mng.save(a);
		
	}

}
