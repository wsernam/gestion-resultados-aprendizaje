import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { Docente } from '../Modelos/docente';

@Injectable({
  providedIn: 'root'
})
export class MockDocenteService {
  // Simula la creación de un docente sin necesidad de backend
  create(docente: Docente): Observable<Docente> {
    console.log('Docente simulado creado:', docente);
    return of(docente);  // Simula una respuesta exitosa
  }
}