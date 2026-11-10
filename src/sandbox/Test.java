package sandbox;

public class Test {

	public static void main(String[] args) {
		
		String nummer = IO.readln("Eingabe Nummer: ");
		String text = IO.readln("Plan: ");
		
		int intNummer = Integer.valueOf(nummer);
		Tagesplan plan = new Tagesplan(intNummer, text);
		
		plan.save();
	}
	
	

}
