import { Component, OnInit } from '@angular/core';
import { CategoryDTO } from 'src/dto/categorydto';
import { CategoryService } from 'src/service/category.service';


@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
category: CategoryDTO[];
  categorytoinsert: CategoryDTO = new CategoryDTO();
     
      constructor(private service: CategoryService) { }
    
      ngOnInit() {
        this.getCategory();
      
      }
    
      getCategory() {
        this.service.getAll().subscribe(category => this.category = category);
      }
    
      
      
    
      delete(category: CategoryDTO) {
        this.service.delete(category.id).subscribe(() => this.getCategory());
      }
    
      update(category: CategoryDTO) {
        
        this.service.update(category).subscribe(() => this.getCategory());
      }
    
      insert(category  : CategoryDTO) {
        
       this.service.insert(category).subscribe(() => this.getCategory());
        
      }
    
      clear(){
        this.categorytoinsert = new CategoryDTO();
      }
    }
    
  


