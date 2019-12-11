package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EnvironmentDTO {
	
	private Long id;
	private String nome;
	private UserDTO userDTO;
}
