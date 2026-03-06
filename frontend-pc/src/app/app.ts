import { Component } from '@angular/core';
import { ListaPc } from './components/lista-pc/lista-pc';
import { FormularioPc } from './components/formulario-pc/formulario-pc';
import { RouterOutlet, RouterLink } from '@angular/router'; // Importamos las herramientas de ruteo
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ListaPc, FormularioPc, RouterOutlet, RouterLink], // Importamos el componente de la lista
  template: `
    <div style="max-width: 800px; margin: 0 auto; font-family: sans-serif;">
      <h1>Gestión de Hardware</h1>

      <nav
        style="margin-bottom: 20px; padding: 15px; background-color: #f2f2f2; border-radius: 8px;"
      >
        <a routerLink="/inventario"
          style="margin-right: 20px; text-decoration: none; color: #007bff; font-weight: bold;"
          >📦 Ver Inventario</a>
        <a routerLink="/cargar" style="text-decoration: none; color: #007bff; font-weight: bold;">➕ Cargar Nueva Pieza</a>
      </nav>
      <router-outlet></router-outlet>
    </div>
  `,
})
export class AppComponent {
  // app.ts ahora solo sirve como contenedor principal, ya no hace peticiones
}
