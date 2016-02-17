package katugallup.model;

public class Vastaus {
	
	private int id;
	private String vastausteksti;
	private String vastausaika;
	private String vastaaja;

	public Vastaus() {
		this.id=0;
		this.vastausteksti=null;
		this.vastausaika=null;
		this.vastaaja=null;
	}
	
	public Vastaus(int id, String vastausteksti, String vastausaika,
			String vastaaja) {
		super();
		this.id = id;
		this.vastausteksti = vastausteksti;
		this.vastausaika = vastausaika;
		this.vastaaja = vastaaja;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVastausteksti() {
		return vastausteksti;
	}

	public void setVastausteksti(String vastausteksti) {
		this.vastausteksti = vastausteksti;
	}

	public String getVastausaika() {
		return vastausaika;
	}

	public void setVastausaika(String vastausaika) {
		this.vastausaika = vastausaika;
	}

	public String getVastaaja() {
		return vastaaja;
	}

	public void setVastaaja(String vastaaja) {
		this.vastaaja = vastaaja;
	}

	@Override
	public String toString() {
		return "Vastaus [id=" + id + ", vastausteksti=" + vastausteksti
				+ ", vastausaika=" + vastausaika + ", vastaaja=" + vastaaja
				+ "]";
	}

	
	
	

}
