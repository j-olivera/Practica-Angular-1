import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ComponentPc, PcService } from '../../services/pc.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-lista-pc',
  standalone: true,
  imports: [CommonModule], //no muestra los datos sin esto
  templateUrl: './lista-pc.html',
  styleUrl: './lista-pc.css',
})
export class ListaPc implements OnInit {
  componentes: ComponentPc[] = []; // aca vamos a guardar los datos desde la bd
  constructor(private pcService: PcService,
              private cdr : ChangeDetectorRef) {}
  ngOnInit() {
    this.pcService.getAllComponents().subscribe({
      next: (datos) => {
        this.componentes = datos;
        this.cdr.detectChanges();
        },
      error: (err) => {
        console.error('Error cargando los datos', err);
      },
    });
  }
}
