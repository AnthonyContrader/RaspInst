import { Injectable } from '@angular/core';
import { ValutazioneDTO } from 'src/dto/valutazionedto';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ValutazioneService extends AbstractService<ValutazioneDTO>{

  constructor(http: HttpClient) {
    super(http);
    this.type = 'valutazione';
  }
}
