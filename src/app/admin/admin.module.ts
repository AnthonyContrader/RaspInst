import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { EnvironmentComponent } from 'src/Environment/environment.component';
import { FormatoComponent } from '../formato/formato.component';
import { CategoryComponent } from '../category/category.component';
import { ValutazioneComponent } from '../valutazione/valutazione.component';
import { PacchettoComponent } from '../pacchetto/pacchetto.component';

/**
 * Modulo dell'admin, qui vengono dichiarate le component che utilizza 
 * l'admin. Questo modulo importa AdminRoutingModule.
 * 
 * @author Vittorio Valent
 * 
 * @see AdminRoutingModule
 */
@NgModule({
  declarations: [AdminDashboardComponent, UsersComponent, WorkInProgressComponent,EnvironmentComponent,FormatoComponent,CategoryComponent,ValutazioneComponent,PacchettoComponent],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule
  ]
})
export class AdminModule { }
