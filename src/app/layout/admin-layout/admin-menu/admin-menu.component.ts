import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-menu',
  templateUrl: './admin-menu.component.html',
  styleUrls: ['./admin-menu.component.css']
})
export class AdminMenuComponent implements OnInit {

  isUserCollapsed = false;
  isClientCollapsed = false;
  isAccountCollapsed = false;
  isEnvironmentCollapsed = false;
  isFormatoCollapsed = false;
  isCategoryCollapsed = false;
  isValutazioneCollapsed = false;
  isPacchettoCollapsed= false;
  constructor(private router: Router) {
  }

  ngOnInit() {
  }

  logout() {
    localStorage.clear();
    this.router.navigateByUrl('');
  }

  userscollapse() {
    if (this.isUserCollapsed === false) {
      this.isUserCollapsed = true;
    } else { this.isUserCollapsed = false; }
  }

  accountcollapse() {
    if (this.isAccountCollapsed === false) {
      this.isAccountCollapsed = true;
    } else { this.isAccountCollapsed = false; }
  }

  environmentcollapse() {
    if (this.isEnvironmentCollapsed === false){
      this.isEnvironmentCollapsed = true;
    } else { this.isEnvironmentCollapsed=false;}
  }
  formatocollapse(){
    if (this.isFormatoCollapsed=== false){
      this.isFormatoCollapsed = true;
    } else { this.isFormatoCollapsed=false;}
  }
  categorycollapse(){
    if (this.isCategoryCollapsed=== false){
      this.isCategoryCollapsed = true;
    } else { this.isCategoryCollapsed = false;}
  }
  valutazionecollapse(){
    if (this.isValutazioneCollapsed=== false){
      this.isValutazioneCollapsed = true;
    } else { this.isValutazioneCollapsed=false;}
  }
  pacchettocollapse(){
    if (this.isPacchettoCollapsed=== false){
      this.isPacchettoCollapsed = true;
    
    } else { this.isPacchettoCollapsed=false;}
  }
}
