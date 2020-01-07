package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class PacchettoDTO {
	private Long id;
	private String nome;
 // private String categoria;
	private String versione;
	private CategoryDTO categoryDTO;
	private FormatoDTO formatoDTO;
	private EnvironmentDTO environmentDTO;
	private ValutazioneDTO valutazioneDTO;
}
