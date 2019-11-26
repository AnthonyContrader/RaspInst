package it.contrader.model;

public class Formato {
	private int id;
	private String tipoFormato;
	
	public Formato() {
		
	}
	
	public Formato(String tipoFormato) {
		this.tipoFormato = tipoFormato;
	}
	
	public Formato(int id, String tipoFormato) {
		this.id = id;
		this.tipoFormato = tipoFormato;
	}
	
	@Override
	public String toString() {
		return "Formato [id=" + id + ", tipoFormato=" + tipoFormato + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipoFormato() {
		return tipoFormato;
	}
	public void setTipoFormato(String tipoFormato) {
		this.tipoFormato = tipoFormato;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formato other = (Formato) obj;
		if (id != other.id)
			return false;
		if (tipoFormato == null) {
			if (other.tipoFormato != null)
				return false;
		} else if (!tipoFormato.equals(other.tipoFormato))
			return false;
		return true;
	}

}
