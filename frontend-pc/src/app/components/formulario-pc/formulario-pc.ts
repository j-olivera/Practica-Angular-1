import { ChangeDetectorRef, Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ComponentPc, PcService } from '../../services/pc.service';

@Component({
  selector: 'app-formulario-pc',
  imports: [FormsModule],
  standalone: true,
  templateUrl: './formulario-pc.html',
  styleUrl: './formulario-pc.css',
})

export class FormularioPc {
  // crear un objeto vacío
  nuevoComponente: ComponentPc = {
    piece_name:'',
    marca :'ASUS',
    price : 0
  };
  mensaje = '';

  constructor(private pcService: PcService, private cdr: ChangeDetectorRef) {}
    guardar(){
      this.pcService.saveComponent(this.nuevoComponente).subscribe({
        next:(res)=>{
          this.mensaje = 'Componente guardado en la base de datos';

          //limpiamos
          this.nuevoComponente = {
              piece_name:'',
              marca:'ASUS',
              price:0,
          };

          //actualiza
          this.cdr.detectChanges();

        },
        error: err => {
          this.mensaje='Ocurrio un error en la base de datos';
          console.error(err);
          this.cdr.detectChanges();
        }
    });
  }
}
