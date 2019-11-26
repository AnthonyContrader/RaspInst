package it.contrader.dto;

public class EnvironmentDTO {
	private int id;
	private String nome;
	public EnvironmentDTO() {
		
	}
	
	public EnvironmentDTO(String nome) {
		this.nome = nome;
	}

	public EnvironmentDTO(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "EnvironmentDTO [id=" + id + ", nome=" + nome + "]";
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
	

}
