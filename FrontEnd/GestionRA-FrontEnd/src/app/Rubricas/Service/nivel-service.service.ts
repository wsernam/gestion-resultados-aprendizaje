import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Nivel } from '../Modelos/nivel';

@Injectable({
  providedIn: 'root'
})
export class NivelService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = 'http://localhost:5000/api/rubricas';

  constructor(private http: HttpClient) { }

  getNiveles(): Observable<Nivel[]> {
    console.log("Obteniendo niveles desde el servicio...");
    return this.http.get<Nivel[]>(this.urlEndPoint);
  }

  createNivel(nivel: Nivel): Observable<Nivel> {
    console.log("Creando nivel desde el servicio...");
    return this.http.post<Nivel>(this.urlEndPoint, nivel, { headers: this.httpHeaders });
  }
}
