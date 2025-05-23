import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Asignatura } from '../../modelos/asignatura';

@Injectable({
  providedIn: 'root'
})
export class AsignaturaService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = 'http://localhost:5000/api/cursos';

  constructor(private http: HttpClient) { }

  getAsignaturas(): Observable<Asignatura[]>
  {
    console.log("Listando asignaturas desde el servicio...");
    return this.http.get<Asignatura[]>(this.urlEndPoint);
  }

}
