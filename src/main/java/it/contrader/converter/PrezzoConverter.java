package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.PrezzoDTO;
import it.contrader.model.Prezzo;
@Component
public class PrezzoConverter extends AbstractConverter<Prezzo,PrezzoDTO> {
	@Override
	public Prezzo toEntity(PrezzoDTO prezzoDTO) {
		Prezzo prezzo=null;
		if(prezzoDTO!=null) {
			prezzo=new Prezzo(prezzoDTO.getId(),prezzoDTO.getCosto());
		}
		return prezzo;
	}
	
	@Override
	public PrezzoDTO toDTO(Prezzo prezzo) {
		PrezzoDTO prezzoDTO = null;
		if (prezzo != null) {
			prezzoDTO = new PrezzoDTO(prezzo.getId(), prezzo.getCosto());
		}
		return prezzoDTO;
	}
}
