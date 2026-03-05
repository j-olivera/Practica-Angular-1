import { Component, OnInit } from '@angular/core';
import { PcService } from './services/pc.service';

@Component({
  selector: 'app-root',
  standalone: true,
  template: `<h1>Prueba de conexión al Backend</h1>`, // Un HTML mínimo
})
export class AppComponent implements OnInit {
  // Inyectamos tu servicio (igual que inyectás dependencias en Java)
  constructor(private pcService: PcService) {}

  // Este metodo se ejecuta automáticamente cuando la página carga
  ngOnInit() {
    this.pcService.getAllComponents().subscribe({
      next: (datos) => {
        console.log('¡Éxito! Me conecté al puerto 8080. Datos recibidos:', datos);
      },
      error: (error) => {
        console.error('Falló la conexión. Revisá si Spring Boot está encendido o el CORS:', error);
      },
    });
  }
}
