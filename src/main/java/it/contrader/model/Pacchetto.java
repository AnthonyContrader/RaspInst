package it.contrader.model;

public class Pacchetto {
	
	private int id;
	private String nome;
	private String categoria;
	private String versione;
	private String data;
	public Pacchetto() {
		
	}
	public Pacchetto(int id, String nome, String categoria, String versione, String data) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.versione = versione;
		this.data = data;
	}
	public Pacchetto(String nome, String categoria, String versione, String data) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.versione = versione;
		this.data = data;
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
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacchetto other = (Pacchetto) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (versione == null) {
			if (other.versione != null)
				return false;
		} else if (!versione.equals(other.versione))
			return false;
		return true;
	}
	
}
