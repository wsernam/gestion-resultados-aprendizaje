import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Asignatura } from '../../modelos/asignatura';

@Injectable({
  providedIn: 'root'
})
export class AsignaturaService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = 'http://localhost:8079/api/asignatura';

  constructor(private http: HttpClient) { }

  getAsignaturas(): Observable<Asignatura[]>
  {
    console.log("Listando asignaturas desde el servicio...");
    return this.http.get<Asignatura[]>(`${this.urlEndPoint}/listar`);
  }

  getAsignaturaByName(nombre: string): Observable<Asignatura> {
    console.log("Buscando asignatura por nombre desde el servicio: ", nombre);
    return this.http.get<Asignatura>(`${this.urlEndPoint}/${nombre}`);
  }

}
