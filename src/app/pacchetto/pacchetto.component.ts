import { Component, OnInit } from '@angular/core';
import { FormatoDTO } from 'src/dto/formatodto';
import { PacchettoService } from 'src/service/pacchetto.service';
import { EnvironmentDTO } from 'src/dto/environmentdto';
import { ValutazioneDTO } from 'src/dto/valutazionedto';
import { FormatoService } from 'src/service/formato.service';
import { EnvironmentService } from 'src/service/environment.service';
import { ValutazioneService } from 'src/service/valutazione.service';
import { PacchettoDTO } from 'src/dto/pacchettodto';
import { CategoryDTO } from 'src/dto/categorydto';
import { CategoryService } from 'src/service/category.service';

@Component({
  selector: 'app-pacchetto',
  templateUrl: './pacchetto.component.html',
  styleUrls: ['./pacchetto.component.css']
})
export class PacchettoComponent implements OnInit {

  pacchetto: PacchettoDTO[];
  pacchettotoinsert: PacchettoDTO = new PacchettoDTO();
 category : CategoryDTO;
 categories:CategoryDTO[];
  //constructor(private service: PacchettoService, private categoryService: CategoryService) { }
  formato : FormatoDTO;
  formati : FormatoDTO[];
  environment : EnvironmentDTO;
  environments : EnvironmentDTO[];
  valutazione : ValutazioneDTO;
  valutazioni : ValutazioneDTO[];
  constructor(private service: PacchettoService, private categoryService: CategoryService, private formatoService: FormatoService, private environmentService : EnvironmentService, private valutazioneService: ValutazioneService) { }
  ngOnInit() {
    this.getPacchetto();
  
  }

  getPacchetto() {
    this.service.getAll().subscribe(pacchetto => this.pacchetto = pacchetto);
  }

  getCategory(){
  this.categoryService.getAll().subscribe(categories => this.categories = categories);
  
  }

  getFormato(){
    this.formatoService.getAll().subscribe(formati => this.formati = formati);

  }

  getEnvironment(){
    this.environmentService.getAll().subscribe(environments => this.environments = environments);

  }

  getValutazione(){
    this.valutazioneService.getAll().subscribe(valutazioni => this.valutazioni = valutazioni);
  }

  delete(pacchetto: PacchettoDTO) {
    this.service.delete(pacchetto.id).subscribe(() => this.getPacchetto());
  }

  update(pacchetto : PacchettoDTO) {
    //pacchetto.userDTO=JSON.parse(localStorage.getItem('currentUser'));
    this.service.update(pacchetto).subscribe(() => this.getPacchetto());
  }

  insert(pachetto: PacchettoDTO) {
    //environment.userDTO=JSON.parse(localStorage.getItem('currentUser'));
   this.service.insert(pachetto).subscribe(() => this.getPacchetto());
    
  }

  clear(){
    this.pacchettotoinsert = new PacchettoDTO();
  }
}
