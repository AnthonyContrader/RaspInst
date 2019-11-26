package it.contrader.dto;

public class FormatoDTO {
	private int id;
	private String tipoFormato;
	
	public FormatoDTO() {
		
	}

	public FormatoDTO(String tipoFormato) {
		this.tipoFormato = tipoFormato;
	}

	public FormatoDTO(int id, String tipoFormato) {
		this.id = id;
		this.tipoFormato = tipoFormato;
	}

	@Override
	public String toString() {
		return "FormatoDTO [id=" + id + ", tipoFormato=" + tipoFormato + "]";
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
}
