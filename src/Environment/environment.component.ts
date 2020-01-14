import { Component, OnInit } from '@angular/core';
import { EnvironmentService } from 'src/service/environment.service';
import { EnvironmentDTO } from 'src/dto/environmentdto';
import { UserDTO } from 'src/dto/userdto';
import { UserService } from 'src/service/user.service';


@Component({
  selector: 'app-environment',
  templateUrl: './environment.component.html',
  styleUrls: ['./environment.component.css']
})
export class EnvironmentComponent implements OnInit {

  environments: EnvironmentDTO[];
  environmenttoinsert: EnvironmentDTO = new EnvironmentDTO();
 user : UserDTO;
 users:UserDTO[];
  constructor(private service: EnvironmentService, private userService: UserService) { }

  ngOnInit() {
    this.getEnvironment();
  
  }

  getEnvironment() {
    this.service.getAll().subscribe(environments => this.environments = environments);
  }

  getUser(){
  this.userService.getAll().subscribe(users => this.users = users);
  
  }

  delete(environment: EnvironmentDTO) {
    this.service.delete(environment.id).subscribe(() => this.getEnvironment());
  }

  update(environment: EnvironmentDTO) {
    environment.userDTO=JSON.parse(localStorage.getItem('currentUser'));
    this.service.update(environment).subscribe(() => this.getEnvironment());
  }

  insert(environment: EnvironmentDTO) {
    environment.userDTO=JSON.parse(localStorage.getItem('currentUser'));
   this.service.insert(environment).subscribe(() => this.getEnvironment());
    
  }

  clear(){
    this.environmenttoinsert = new EnvironmentDTO();
  }
}
