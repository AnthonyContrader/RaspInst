package it.contrader.model;

public class Pacchetto {
	
	private int id;
	
	private String nome;
	
	private String categoria;
	
	private String data;
	
	private String versione;
	
	public Pacchetto() {
		
	}
	
	public Pacchetto (String nome, String categoria, String data, String versione){
		this.nome=nome;
		this.categoria=categoria;
		this.data=data;
		this.versione=versione;
	}
	
	public Pacchetto (int id,String nome, String categoria, String data,String Versione) {
		this.id=id;
		this.nome=nome;
		this.categoria=categoria;
		this.data=data;
		this.versione=versione;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public int getId() {
		return this.id;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setCategoria(String categoria) {
		this.categoria=categoria;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	public void setData(String data) {
		this.data=data;
	}
	
	public String getData() {
		return this.data;
	}
	public void setVersione(String versione) {
		this.versione=versione;
	}
	
	public String getVersione() {
		return this.versione;
	}
	@Override
	public String toString() {
		return id + "\t" + nome + "\t" + categoria +"\t"+data+ "\t" + versione+"\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pacchetto other = (Pacchetto) obj;
		if (id != other.id)
			return false;
		if (nome==null && other.nome!=null || nome != null && other.nome == null) {
				return false;
		}
		else if(!nome.equals(other.nome))
			return false;
		if (categoria==null && other.categoria!=null || categoria != null && other.categoria == null) {
			return false;
		}
		else if(!categoria.equals(other.categoria))
		return false;
		
		if (data==null && other.data!=null || data != null && other.data == null) {
			return false;
		}
	else if(!data.equals(other.data))
		return false;
		
		if (versione==null && other.versione!=null || versione != null && other.versione == null) {
			return false;
		}
	else if(!versione.equals(other.versione))
		return false;
	return true;		
	}
}
