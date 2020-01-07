
import { FormatoDTO } from './formatodto';
import { EnvironmentDTO } from './environmentdto';
import { ValutazioneDTO } from './valutazionedto';
import { CategoryDTO } from './categorydto';


export class PacchettoDTO {

    id : number;
    nome: string;
    versione:string;
    
    categoryDTO :CategoryDTO;
    formatoDTO : FormatoDTO;
    environmentDTO: EnvironmentDTO;
    valutazioneDTO: ValutazioneDTO;
} 