package it.contrader.dto;

import it.contrader.model.User.Usertype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PacchettoDTO {
	private Long id;
	private String nome;
	private String categoria;
	private String versione;
}
