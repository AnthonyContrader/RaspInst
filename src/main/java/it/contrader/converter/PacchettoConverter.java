package it.contrader.converter;
import org.springframework.stereotype.Component;
import it.contrader.dto.PacchettoDTO;
import it.contrader.model.Pacchetto;

@Component
public class PacchettoConverter extends AbstractConverter<Pacchetto,PacchettoDTO> {
//ho tolto l'override perchè non esistevano metodi nelle classi precedenti
	@Override
	public Pacchetto toEntity(PacchettoDTO pacchettoDTO) {
		Pacchetto pacchetto=null;
		if(pacchettoDTO != null) {
			pacchetto=new Pacchetto(pacchettoDTO.getId(),pacchettoDTO.getNome(),pacchettoDTO.getCategoria(),pacchettoDTO.getVersione());
		}
		return pacchetto;
	}
	@Override
	public PacchettoDTO toDTO(Pacchetto pacchetto) {
		PacchettoDTO pacchettoDTO = null;
		if (pacchetto != null) {
			pacchettoDTO = new PacchettoDTO(pacchetto.getId(), pacchetto.getNome(), pacchetto.getCategoria(), pacchetto.getVersione());

		}
		return pacchettoDTO;
	}
}
