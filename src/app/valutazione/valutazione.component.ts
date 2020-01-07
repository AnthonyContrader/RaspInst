import { Component, OnInit } from '@angular/core';
import { ValutazioneDTO } from 'src/dto/valutazionedto';
import { ValutazioneService } from 'src/service/valutazione.service';

@Component({
  selector: 'app-valutazione',
  templateUrl: './valutazione.component.html',
  styleUrls: ['./valutazione.component.css']
})
export class ValutazioneComponent implements OnInit {
valutazione: ValutazioneDTO[];
  valutazionetoinsert: ValutazioneDTO = new ValutazioneDTO();
     
      constructor(private service: ValutazioneService) { }
    
      ngOnInit() {
        this.getValutazione();
      
      }
    
      getValutazione() {
        this.service.getAll().subscribe(valutazione => this.valutazione = valutazione);
      }
    
      
      
    
      delete(valutazione: ValutazioneDTO) {
        this.service.delete(valutazione.id).subscribe(() => this.getValutazione());
      }
    
      update(valutazione: ValutazioneDTO) {
        
        this.service.update(valutazione).subscribe(() => this.getValutazione());
      }
    
      insert(valutazione  : ValutazioneDTO) {
        
       this.service.insert(valutazione).subscribe(() => this.getValutazione());
        
      }
    
      clear(){
        this.valutazionetoinsert = new ValutazioneDTO();
      }
    }
    
  


