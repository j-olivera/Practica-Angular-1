import { Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

// esto es para decirle a Angular que datos viajan
export interface ComponentPc{
  id?:number; // (?) significa opcional
  piece_name:string;
  marca:string;
  price:number;
}

@Injectable({
  providedIn: 'root',
})
export class PcService {
  //la ruta a la que se va a conectar
  private apiUrl = 'http://localhost:8080/api/components';
  constructor(private http: HttpClient) {}

  // metodo para traer toda la lista
  getAllComponents(): Observable<ComponentPc[]> {
    return this.http.get<ComponentPc[]>(this.apiUrl);
  }

  //metodo para guardar uno nuevo
  saveComponent(componente: ComponentPc): Observable<ComponentPc> {
    return this.http.post<ComponentPc>(this.apiUrl, componente);
  }
}
