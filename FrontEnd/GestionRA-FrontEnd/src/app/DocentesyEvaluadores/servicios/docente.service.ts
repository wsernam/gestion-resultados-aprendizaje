import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Docente } from '../docente';

@Injectable({
  providedIn: 'root'
})

export class DocenteService {

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  private urlEndPoint: string = "http://localhost:5000/api/docentes";

  constructor (private http: HttpClient) { }

  getDocentes(): Observable<Docente[]> {
    console.log("Listando Docentes desde el servicio");
    return this.http.get<Docente[]>(this.urlEndPoint);
  }

  create(docente: Docente): Observable<Docente> {
    console.log("Creando docente desde servicio");
    return this.http.post<Docente>(this.urlEndPoint, docente, {headers: this.httpHeaders});
  }
}
