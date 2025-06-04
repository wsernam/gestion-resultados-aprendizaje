import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Curso } from '../../modelos/curso';
import { CrearCurso } from '../../modelos/crear-curso';
import { ConsultarCurso } from '../../modelos/consultar-curso';


@Injectable({
  providedIn: 'root'
})
export class CursoService {

  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});
  private urlEndPoint: string = 'http://localhost:8079/api/cursos';
  private cursoCreadoSource = new Subject<void>();
  cursoCreado$ = this.cursoCreadoSource.asObservable();

  constructor(private http: HttpClient) { }

  getCursosDocente(cedula: number): Observable<ConsultarCurso[]>
  {
    console.log("Listando cursos del docente con cédula: " + cedula + " desde el servicio...");
    return this.http.get<ConsultarCurso[]>(`${this.urlEndPoint}/buscar-cursos/cedula/${cedula}`);
  }

  create(curso: CrearCurso): Observable<CrearCurso>
  {
    console.log("Creando curso desde el servicio...");
    return this.http.post<CrearCurso>(`${this.urlEndPoint}/guardar`, curso, {headers: this.httpHeaders});
  }

  getAllCursos(): Observable<Curso[]>
  {
    console.log("Listando cursos desde el servicio...");
    return this.http.get<Curso[]>(this.urlEndPoint)
  }

  notifyCursoCreado(): void {
    this.cursoCreadoSource.next();
  }

}
