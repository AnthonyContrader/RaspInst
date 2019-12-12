package it.contrader.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pacchetto {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String versione;
	
	@ManyToOne
	@JoinColumn(name="id_category", referencedColumnName="id")
	private Category category;
	@ManyToOne
	@JoinColumn(name="id_formato", referencedColumnName="id")
	private Formato formato;
	@ManyToOne
	@JoinColumn(name="id_environment", referencedColumnName="id")
	private Environment environment;
	@ManyToOne
	@JoinColumn(name="id_valutazione", referencedColumnName="id")
	private Valutazione valutazione;

	
}
