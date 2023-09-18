import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {GenerationTokenComponent} from '../app/generation-token/generation-token.component';
import { MainComponent } from './main/main.component';
import { HistorialComponent } from './historial/historial.component';

const routes: Routes = [
  {path:'', component : MainComponent},
  {path:'Token', loadChildren:  () => import('./generation-token/generation-token.module').then(m => m.GenerationTokenModule)},
  {path: 'historial', component: HistorialComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
