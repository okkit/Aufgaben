package data.objekte;

public class PleaseNotUseException extends Exception {

	private static final long serialVersionUID = 1L;

	public PleaseNotUseException() {
		super("Please Not Use this ");
	}
}
