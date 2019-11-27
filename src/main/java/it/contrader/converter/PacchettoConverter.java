package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PacchettoDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Pacchetto;
import it.contrader.model.User;


public class PacchettoConverter {
	public PacchettoDTO toDTO(Pacchetto pacchetto) {
			PacchettoDTO pacchettoDTO = new PacchettoDTO(pacchetto.getId(),pacchetto.getNome(),pacchetto.getCategoria(),pacchetto.getData(),pacchetto.getVersione());
			return pacchettoDTO;
	}
	public Pacchetto toEntity(PacchettoDTO pacchettoDTO) {
		Pacchetto pacchetto=new Pacchetto(pacchettoDTO.getId(),pacchettoDTO.getNome(),pacchettoDTO.getCategoria(),pacchettoDTO.getData(),pacchettoDTO.getVersione());
		return pacchetto;
	}
	public List<PacchettoDTO> toDTOList(List<Pacchetto> pacchettoList){
		List<PacchettoDTO> pacchettoDTOList = new ArrayList<PacchettoDTO>();

		for(Pacchetto pacchetto : pacchettoList) {
			pacchettoDTOList.add(toDTO(pacchetto));
		}
		return pacchettoDTOList;
	}
}