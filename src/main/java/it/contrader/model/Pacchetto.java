package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.util.ArrayList;
import java.util.List;
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
	private long id;
	@Column
	private String nome;
	private String categoria;
	private String versione;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private Environment environment;
	@OneToOne
	private Category category;
	@OneToOne
	private Formato formato;
	@OneToOne
	private Valutazione valutazione;
}
