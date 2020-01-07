import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminLayoutComponent } from '../layout/admin-layout/admin-layout.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { UsersComponent } from './users/users.component';
import { WorkInProgressComponent } from './work-in-progress/work-in-progress.component';
import { EnvironmentComponent } from 'src/Environment/environment.component';
import { FormatoComponent } from '../formato/formato.component';
import { CategoryComponent } from '../category/category.component';
import { ValutazioneComponent } from '../valutazione/valutazione.component';
import { PacchettoComponent } from '../pacchetto/pacchetto.component';

/**
 * Modulo di routing dell'admin. Qui ci sono i percorsi che un admin può seguire:
 * appena fa il login viene caricato nel <router-outlet> di app-component il layout e nel 
 * <router-outlet> del layout (come percorsi "children") vengono visualizzati gli altri 
 * (qui sotto sono indentati).
 * 
 * @author Vittorio Valent
 * 
 * @see AdminLayoutComponent
 * 
 * @see layout
 */
const routes: Routes = [
  { path: 'admin-dashboard', component: AdminLayoutComponent, children:[
    { path: '', component: AdminDashboardComponent},
    { path: 'users', component: UsersComponent},
    { path: 'environment', component: EnvironmentComponent},
    { path: 'formato', component: FormatoComponent},
    { path: 'category', component:CategoryComponent},
    {path: 'valutazione', component:ValutazioneComponent},
    {path:'pacchetto', component:PacchettoComponent},
    { path: 'work-in-Progress', component: WorkInProgressComponent}
  ]}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }