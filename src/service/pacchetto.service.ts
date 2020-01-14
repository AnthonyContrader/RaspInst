import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AbstractService } from './abstractservice';
import { PacchettoDTO } from 'src/dto/pacchettodto';

@Injectable({

  providedIn: 'root'
})

export class PacchettoService extends AbstractService<PacchettoDTO>{

  constructor(http: HttpClient) {
      super(http);
      this.type = 'pacchetto';
    }
}
