package it.contrader.dto;

public class PacchettoDTO {
	private int id;
	
	private String nome;
	
	private String categoria;
	
	private String data;
	
	private String versione;
	
public PacchettoDTO() {
		
	}
	
	public PacchettoDTO(String nome, String categoria, String data, String versione){
		this.nome=nome;
		this.categoria=categoria;
		this.data=data;
		this.versione=versione;
	}
	
	public PacchettoDTO(int id,String nome, String categoria, String data,String versione) {
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
	public void setData(String Data) {
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
		return id + "\t" + nome + "\t" + categoria +"\t"+ data+"\t"+ versione+"\n";
	}

}
