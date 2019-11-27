package it.contrader.model;

public class Prezzo {
	private int id;
	private float costo;
	
	public Prezzo () {
		
	}
	public Prezzo (float costo) {
		this.costo = costo;
	}
	
	public Prezzo (int id, float costo) {
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
		return "Prezzo [id=" + id + ", costo=" + costo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prezzo other = (Prezzo) obj;
		if (Float.floatToIntBits(costo) != Float.floatToIntBits(other.costo))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
}
