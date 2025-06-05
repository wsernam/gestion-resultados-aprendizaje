import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ResultadoA } from '../../Modelos/resultado-a';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ResultadosAService {

  private httpHeader = new HttpHeaders({'Content-Type': 'application/json'});
  private urlEndPoint: string = "http://localhost:8079/api/RAAsignatura";

  constructor(private http: HttpClient) { }

  create(resultadoA: ResultadoA): Observable<ResultadoA> {
    console.log("Creando resultado de aprendizaje de asignatura desde el servicio");
    return this.http.post<ResultadoA>(`${this.urlEndPoint}/guardar`, resultadoA, {headers: this.httpHeader});
  }

  getResultadosA(): Observable<ResultadoA[]> {
    console.log("Listando resultados de aprendizaje de asignatura desde el servicio");
    return this.http.get<ResultadoA[]>(`${this.urlEndPoint}/listar`);
  }

  getResultadosAPorAsignatura(asignaturaId: string): Observable<ResultadoA[]> {
    console.log("Listando resultados de aprendizaje de asignatura por asignatura desde el servicio con ID: ", asignaturaId);
    return this.http.get<ResultadoA[]>(`${this.urlEndPoint}/buscar/asignatura/${asignaturaId}`);
  }
}
