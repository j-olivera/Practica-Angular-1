import { Routes } from '@angular/router';
import { ListaPc } from './components/lista-pc/lista-pc';
import { FormularioPc } from './components/formulario-pc/formulario-pc';

export const routes: Routes = [

  {path: 'inventario', component: ListaPc},
  {path: 'cargar', component: FormularioPc},
  {path: '', redirectTo: '/inventario', pathMatch: 'full'},
];
