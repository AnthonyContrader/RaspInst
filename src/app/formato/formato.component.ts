import { Component, OnInit } from '@angular/core';
import { FormatoDTO } from 'src/dto/formatodto';
import { FormatoService } from 'src/service/formato.service';

@Component({
  selector: 'app-formato',
  templateUrl: './formato.component.html',
  styleUrls: ['./formato.component.css']
})
export class FormatoComponent implements OnInit {
formato: FormatoDTO[];
  formatotoinsert: FormatoDTO = new FormatoDTO();
     
      constructor(private service: FormatoService) { }
    
      ngOnInit() {
        this.getFormato();
      
      }
    
      getFormato() {
        this.service.getAll().subscribe(formato => this.formato = formato);
      }
    
      
      
    
      delete(formato: FormatoDTO) {
        this.service.delete(formato.id).subscribe(() => this.getFormato());
      }
    
      update(formato: FormatoDTO) {
        
        this.service.update(formato).subscribe(() => this.getFormato());
      }
    
      insert(formato  : FormatoDTO) {
        
       this.service.insert(formato).subscribe(() => this.getFormato());
        
      }
    
      clear(){
        this.formatotoinsert = new FormatoDTO();
      }
    }
    
  


