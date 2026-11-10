package sandbox;

public class CallByValue {

	public static void main(String[] args) {

		CallByValue cbv = new CallByValue();

		int b = 17;
		cbv.changeInt(b);
		IO.println(b);

		String s = "Hallo";
		cbv.changeString(s);
		IO.println(s);

		int[] arr = { 1, 2 };
		cbv.changeIntArr(arr);
		IO.println(arr[0]);

		Mini m = new Mini();
		IO.println(m);
		cbv.changeMini(m);
		IO.println(m == null ? "Nullik" : (m.i < 0 ? "i ist negativ" : "i ist positiv"));

	}

	private void changeString(String s) {
		s = "Tschüss";
	}

	void changeMini(Mini m) {

		m.i = 100;
	}

	void changeIntArr(int[] a) {
		a[0] = 100;

	}

	void changeInt(int a) {
		a = 100;
	}

}
