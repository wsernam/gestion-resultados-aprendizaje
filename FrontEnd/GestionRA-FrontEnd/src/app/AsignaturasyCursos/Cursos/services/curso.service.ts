import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Curso } from '../../modelos/curso';


@Injectable({
  providedIn: 'root'
})
export class CursoService {

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  private urlEndPoint: string = 'http://localhost:8085/api/cursos';

  constructor(private http: HttpClient) { }

  getCursosDocente(cedula: number): Observable<Curso[]>
  {
    console.log("Listando cursos del docente con cédula" + cedula + "desde el servicio...");
    return this.http.get<Curso[]>(`${this.urlEndPoint}/buscar-cursos/cedula/${cedula}`);
  }

  create(curso: Curso): Observable<Curso>
  {
    console.log("Creando curso desde el servicio...");
    return this.http.post<Curso>(this.urlEndPoint, curso, {headers: this.httpHeaders});
  }

  getAllCursos(): Observable<Curso[]>
  {
    console.log("Listando cursos desde el servicio...");
    return this.http.get<Curso[]>(this.urlEndPoint)
  }
}
