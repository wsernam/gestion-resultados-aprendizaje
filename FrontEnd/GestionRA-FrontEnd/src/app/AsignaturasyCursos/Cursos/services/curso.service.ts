import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../../../Modelos/curso';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  private urlEndPoint: string = 'http://localhost:5000/api/cursos';

  constructor(private http: HttpClient) { }

  getCursos(): Observable<Curso[]>
  {
    console.log("Listando cursos desde el servicio...");
    return this.http.get<Curso[]>(this.urlEndPoint);
  }

  create(curso: Curso): Observable<Curso>
  {
    console.log("Creando curso desde el servicio...");
    return this.http.post<Curso>(this.urlEndPoint, curso, {headers: this.httpHeaders});
  }
}
