import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, catchError, throwError } from 'rxjs';
import { Curso } from '../../modelos/curso';
import { CrearCurso } from '../../modelos/crear-curso';
import { ConsultarCurso } from '../../modelos/consultar-curso';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class CursoService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
  private urlEndPoint: string = 'http://localhost:8079/api/cursos';
  private cursoCreadoSource = new Subject<void>();
  cursoCreado$ = this.cursoCreadoSource.asObservable();

  constructor(private http: HttpClient) { }

  getCursosDocente(cedula: number): Observable<ConsultarCurso[]> {
    console.log("Listando cursos del docente con cédula: " + cedula + " desde el servicio...");
    return this.http.get<ConsultarCurso[]>(`${this.urlEndPoint}/buscar-cursos/cedula/${cedula}`);
  }

  create(curso: CrearCurso): Observable<CrearCurso> {
    console.log("Creando curso desde el servicio...");
    return this.http.post<CrearCurso>(`${this.urlEndPoint}/guardar`, curso, { headers: this.httpHeaders }).pipe(
      catchError(this.handleError)
    );
  }

  getAllCursos(): Observable<Curso[]> {
    console.log("Listando cursos desde el servicio...");
    return this.http.get<Curso[]>(this.urlEndPoint)
  }

  getCursoById(id: string): Observable<ConsultarCurso> {
    console.log("Obteniendo curso por ID desde el servicio...");
    return this.http.get<ConsultarCurso>(`${this.urlEndPoint}/buscar/${id}`);
  }

  notifyCursoCreado(): void {
    this.cursoCreadoSource.next();
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 400 || error.status === 404) {
      const codigoError = error.error.codigoError;
      const mensajeError = error.error.mensaje;
      const codigoHttp = error.error.codigoHttp;
      const url = error.error.url;
      const metodo = error.error.metodo;

      console.log(`Error ${codigoHttp} en ${metodo} ${url}: ${mensajeError} (Código: ${codigoError})`);

      Swal.fire({
        icon: 'error',
        title: '!Error!',
        text: mensajeError,
        confirmButtonText: 'Cerrar'
      });

      return throwError(() => new Error(mensajeError));
    } else {
      return throwError(() => new Error('Ocurrió un error inesperado.'));
    }
  }
}
