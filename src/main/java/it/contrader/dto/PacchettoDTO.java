package it.contrader.dto;

public class PacchettoDTO {
	private int id;
	private String nome;
	private String categoria;
	private String versione;
	private String data;
	public PacchettoDTO() {
		
	}
	public PacchettoDTO(int id, String nome, String categoria, String versione, String data) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.versione = versione;
		this.data = data;
	}
	public PacchettoDTO(String nome, String categoria, String versione, String data) {
		this.nome = nome;
		this.categoria = categoria;
		this.versione = versione;
		this.data = data;
	}
	@Override
	public String toString() {
		return "PacchettoDTO [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", versione=" + versione
				+ ", data=" + data + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getVersione() {
		return versione;
	}
	public void setVersione(String versione) {
		this.versione = versione;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

}
