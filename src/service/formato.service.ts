import { Injectable } from '@angular/core';
import { AbstractService } from './abstractservice';
import { HttpClient } from '@angular/common/http';
import { FormatoDTO } from 'src/dto/formatodto';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { UserDTO } from 'src/dto/userdto';

@Injectable({
    providedIn: 'root'
  })
  export class FormatoService extends AbstractService<FormatoDTO>{
  
    constructor(http: HttpClient) {
      super(http);
      this.type = 'formato';
    }
  
    //login(loginDTO: LoginDTO): Observable<UserDTO> {
     // return this.http.post<any>('http://localhost:8080/' + this.type + '/login', loginDTO)
    }
  
 // }
  