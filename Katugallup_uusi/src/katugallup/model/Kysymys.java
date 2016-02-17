
package katugallup.model;


public class Kysymys {

	private int id;
	private String kysymysteksti;

	public Kysymys() {
		this.id=0;
		this.kysymysteksti=null;
	}

	public Kysymys(int id, String kysymysteksti) {
		this.id=id;
		this.kysymysteksti = kysymysteksti;
		
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setKysymysteksti(String kysymysteksti) {
		this.kysymysteksti = kysymysteksti;
	}
	
	public int getId() {
		return id;
	}
	
	public String getKysymysteksti() {
		return kysymysteksti;
	}

	@Override
	public String toString() {
		return "Katugallup [kysymysteksti=" + kysymysteksti
				+ "]";
	}

	
}
