package it.contrader.converter;
import java.util.ArrayList;
import java.util.List;
import it.contrader.dto.PrezzoDTO;
import it.contrader.model.Prezzo;
public class PrezzoConverter {
	
	public PrezzoDTO toDTO(Prezzo prezzo) {
		PrezzoDTO prezzodto= new PrezzoDTO(prezzo.getId(),prezzo.getCosto());
		return prezzodto;
	}
	public Prezzo toEntity(PrezzoDTO prezzodto) {
		
		Prezzo prezzo = new Prezzo(prezzodto.getId(),prezzodto.getCosto());
				return prezzo;
	}
	public List<PrezzoDTO> toDTOList(List<Prezzo> prezzodtoList){
		
		   List<PrezzoDTO> prezzodtolist = new ArrayList<PrezzoDTO>();
			
		   for(Prezzo prezzo : prezzodtoList )
			   prezzodtolist.add(toDTO(prezzo));
		
		   return prezzodtolist;
		
	}

}
