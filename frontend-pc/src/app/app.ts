import { Component } from '@angular/core';
import { ListaPc } from './components/lista-pc/lista-pc';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ListaPc], // Importamos el componente de la lista
  template: ` <app-lista-pc></app-lista-pc> `,
})
export class AppComponent {
  // app.ts ahora solo sirve como contenedor principal, ya no hace peticiones
}
