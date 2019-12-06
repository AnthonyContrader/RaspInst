package it.contrader.converter;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import it.contrader.dto.PacchettoDTO;
import it.contrader.model.Pacchetto;

@Component
public class PacchettoConverter extends AbstractConverter<Pacchetto,PacchettoDTO> {

	@Autowired
	private UserConverter userConverter;
	@Autowired
	private EnvironmentConverter environmentConverter;
	@Autowired
	private CategoryConverter categoryConverter;
	@Autowired
	private FormatoConverter formatoConverter;
	@Autowired
	private ValutazioneConverter valutazioneConverter;
	

	@Override
	public Pacchetto toEntity(PacchettoDTO pacchettoDTO) {
		Pacchetto pacchetto=null;
		if(pacchettoDTO != null) {
		pacchetto=new Pacchetto();
		pacchetto.setId(pacchettoDTO.getId());
		pacchetto.setNome(pacchettoDTO.getNome());
		pacchetto.setCategoria(pacchettoDTO.getCategoria());
		pacchetto.setVersione(pacchettoDTO.getVersione());	
		
			if(pacchettoDTO.getUserDTO()!=null) {
				pacchetto.setUser(userConverter.toEntity(pacchettoDTO.getUserDTO()));
				if(pacchettoDTO.getEnvironmentDTO()!=null) {
					pacchetto.setEnvironment(environmentConverter.toEntity(pacchettoDTO.getEnvironmentDTO()));
				}	
				if(pacchettoDTO.getCategoryDTO()!=null) {
					pacchetto.setCategory(categoryConverter.toEntity(pacchettoDTO.getCategoryDTO()));
				}
				if(pacchettoDTO.getFormatoDTO()!=null) {
					pacchetto.setFormato(formatoConverter.toEntity(pacchettoDTO.getFormatoDTO()));
				}
				if(pacchettoDTO.getValutazioneDTO()!=null) {
					pacchetto.setValutazione(valutazioneConverter.toEntity(pacchettoDTO.getValutazioneDTO()));				
				}
				
			}
		}
		return pacchetto;
	}
			
		
	@Override
	public PacchettoDTO toDTO(Pacchetto pacchetto) {
		PacchettoDTO pacchettoDTO=null;
		if(pacchetto != null) {
		pacchettoDTO=new PacchettoDTO();
		pacchettoDTO.setId(pacchetto.getId());
		pacchettoDTO.setNome(pacchetto.getNome());
		pacchettoDTO.setCategoria(pacchetto.getCategoria());
		pacchettoDTO.setVersione(pacchetto.getVersione());	
		
			if(pacchetto.getUser()!=null) {
				pacchettoDTO.setUserDTO(userConverter.toDTO(pacchetto.getUser()));
				if(pacchetto.getEnvironment()!=null) {
					pacchettoDTO.setEnvironmentDTO(environmentConverter.toDTO(pacchetto.getEnvironment()));
				}	
				if(pacchetto.getCategory()!=null) {
					pacchettoDTO.setCategoryDTO(categoryConverter.toDTO(pacchetto.getCategory()));
				}
				if(pacchetto.getFormato()!=null) {
					pacchettoDTO.setFormatoDTO(formatoConverter.toDTO(pacchetto.getFormato()));
				}
				if(pacchetto.getValutazione()!=null) {
					pacchettoDTO.setValutazioneDTO(valutazioneConverter.toDTO(pacchetto.getValutazione()));				
				}
				
			}
		}
		return pacchettoDTO;
	}
}
