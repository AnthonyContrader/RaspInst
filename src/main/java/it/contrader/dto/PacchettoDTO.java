package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
