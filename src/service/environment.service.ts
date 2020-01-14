import { AbstractService } from './abstractservice'
import { Injectable } from '@angular/core';
import { EnvironmentDTO } from 'src/dto/environmentdto';
import { HttpClient } from '@angular/common/http';
import { LoginDTO } from 'src/dto/logindto';
import { Observable } from 'rxjs';
import { UserDTO } from 'src/dto/userdto';

 



@Injectable({

    providedIn: 'root'
})

export class EnvironmentService extends AbstractService<EnvironmentDTO>{

    constructor(http: HttpClient) {
        super(http);
        this.type = 'environment';
      }
      //getAllById(userDTO: UserDTO): Observable<EnvironmentDTO[]>{
        //return this.http.post<EnvironmentDTO[]>('http://localhost:8080/'+ this.type + '/getallbyuser',userDTO);
      login(loginDTO: LoginDTO): Observable<EnvironmentDTO> {
       return this.http.post<any>('http://localhost:8080/' + this.type + '/login', loginDTO)//
      }


}