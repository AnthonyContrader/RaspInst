package it.contrader.dto;

public class PrezzoDTO {
	private int id;
	private float costo;
	
	public PrezzoDTO () {
		
	}
	
	public PrezzoDTO (float costo) {
		this.costo = costo;
	}
	
	public PrezzoDTO (int id, float costo) {
		this.id = id;
		this.costo = costo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	@Override
	public String toString() {
		return "PrezzoDTO [id=" + id + ", costo=" + costo + "]";
	}
	
	
}
