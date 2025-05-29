import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Periodo } from '../../modelos/periodo';

@Injectable({
  providedIn: 'root'
})
export class PeriodoService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = 'http://localhost:8079/api/cursos';

  constructor(private http: HttpClient) { }

  getPeriodos(): Observable<Periodo[]>
  {
    console.log("Listando periodos desde el servicio...");
    return this.http.get<Periodo[]>(this.urlEndPoint);
  }

}
