package it.contrader.dto;

import it.contrader.model.Valutazione.Voto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ValutazioneDTO {
	
	private Long id;
	
	private Voto voto;

	private float mediaVoto;

	//private PacchettoDTO pacchettoDTO;
}
