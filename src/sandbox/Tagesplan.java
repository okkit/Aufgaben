package sandbox;

public class Tagesplan {
	
	private int id;
	private int nummer;
	private String plan;
	
	
	public Tagesplan(int nummer, String plan) {
		super();
		this.nummer = nummer;
		this.plan = plan;
	}
	
	public void save() {
		
		String strToSave = id + ";" + nummer + ";" + plan;
		String msg = FileIO.writeIntoFile("Plan.csv", strToSave);
		IO.println(msg);
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	
	
	

}
