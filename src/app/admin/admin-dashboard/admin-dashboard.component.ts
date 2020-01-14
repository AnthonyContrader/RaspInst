import { Component, OnInit } from '@angular/core';
import { UserDTO } from 'src/dto/userdto';
import { EnvironmentDTO } from 'src/dto/environmentdto';
import { FormatoDTO } from 'src/dto/formatodto';
import { CategoryDTO } from 'src/dto/categorydto';
import { ValutazioneDTO } from 'src/dto/valutazionedto';
import { PacchettoDTO } from 'src/dto/pacchettodto';

/**
 * Componente della dashboard admin. Nell'ngOnInit recupera
 * l'utente loggato per il messaggio di benvenuto.
 */
@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent implements OnInit {

  user: UserDTO;
  environment: EnvironmentDTO
  formato : FormatoDTO
  category : CategoryDTO
  valutazione : ValutazioneDTO
  pacchetto : PacchettoDTO
  constructor() { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser'));
  
this.environment = JSON.parse(localStorage.getItem('currentEnvironment'));
this.formato = JSON.parse(localStorage.getItem('currentFormato'));
this.category =JSON.parse(localStorage.getItem('currentCategory'));
this.valutazione =JSON.parse(localStorage.getItem('currentValutazione'));
this.pacchetto =JSON.parse(localStorage.getItem('currentPacchetto'));}
  }