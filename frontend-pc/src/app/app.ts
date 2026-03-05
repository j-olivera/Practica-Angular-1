import { Component, OnInit } from '@angular/core';
import { PcService } from './services/pc.service';
import { JsonPipe } from '@angular/common'; // Importamos esto para ver el JSON crudo

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [JsonPipe], // Lo declaramos acá
  template: `
    <h1>Prueba de conexión al Backend</h1>

    <h3 style="color: green">{{ mensajeEstado }}</h3>

    <pre style="background: #eee; padding: 10px;">{{ listaComponentes | json }}</pre>
  `,
})
export class AppComponent implements OnInit {
  mensajeEstado = 'Cargando datos...';
  listaComponentes: any = []; // Acá vamos a guardar lo que llegue

  constructor(private pcService: PcService) {}

  ngOnInit() {
    this.pcService.getAllComponents().subscribe({
      next: (datos) => {
        this.mensajeEstado = '¡Conexión Exitosa con Spring Boot! 🚀';
        this.listaComponentes = datos; // Pasamos los datos a la variable visual
      },
      error: (error) => {
        this.mensajeEstado = 'Error al conectar (mirá la consola F12)';
        console.error(error);
      },
    });
  }
}
