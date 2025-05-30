import { Injectable } from '@angular/core';
import { DocenteService } from '../../DocentesyEvaluadores/servicios/docente.service';
import { EvaluadorService } from '../../DocentesyEvaluadores/Evaluadores/Service/evaluador.service';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PerfilService {

  constructor(private docenteService: DocenteService, private evaluadorService: EvaluadorService) { }

  getPerfil(): Observable<any> {
    const tipo = sessionStorage.getItem('tipo');
    console.log('Tipo de usuario:', tipo);
    const correo = sessionStorage.getItem('correo');
    console.log('Correo del usuario:', correo);

    if (tipo === 'DOCENTE') {
      return this.docenteService.getDocentes().pipe(
        map(docentes => {
          console.log('Docentes:', docentes);
          console.log('Buscando correo:', correo);
          return docentes.find(d => d.correo.trim().toLowerCase() === correo!.trim().toLowerCase());
        })
      );
    } else if (tipo === 'EVALUADOR') {
      console.log('Buscando evaluador con correo:', correo);
      return this.evaluadorService.getEvaluadores().pipe(
        map(evaluadores => evaluadores.find(e => e.correo === correo))
      );
    } else {
      console.error('Tipo de usuario no reconocido:', tipo);
      return of(null);
    }
  }

}
