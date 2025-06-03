import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs'
import { Rubrica } from '../Modelos/rubrica';

@Injectable({
  providedIn: 'root'
})
export class RubricaService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = 'http://localhost:8079/api/rubricas';
  private rubricaCreadaSource = new Subject<Rubrica>();
  rubricaCreada$ = this.rubricaCreadaSource.asObservable();

  constructor(private http: HttpClient) { }

  getRubricas(): Observable<Rubrica[]>
  {
     console.log("Obteniendo rúbricas desde el servicio...");
     return this.http.get<Rubrica[]>(this.urlEndPoint);
  }

  createRubrica(rubrica: Rubrica): Observable<Rubrica>
  {
    console.log("Creando rúbrica desde el servicio...");
    return this.http.post<Rubrica>(this.urlEndPoint, rubrica, {headers: this.httpHeaders});
  }

  noficarRubricaCreada(rubrica: Rubrica): void {
    console.log("Notificando creación de rúbrica...");
    this.rubricaCreadaSource.next(rubrica);
  }
}
