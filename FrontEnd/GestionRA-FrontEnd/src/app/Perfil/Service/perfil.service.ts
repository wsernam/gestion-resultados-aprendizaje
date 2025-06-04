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
      // Cambiado: ahora se usa getDocenteByEmail
      return this.docenteService.getDocenteByEmail(correo!).pipe(
        map(docente => {
          console.log('Docente encontrado:', docente);
          return docente;
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
