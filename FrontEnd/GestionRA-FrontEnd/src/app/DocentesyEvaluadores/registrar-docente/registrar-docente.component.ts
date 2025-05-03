import { Component } from '@angular/core';
import { Docente } from './docente';

@Component({
  selector: 'app-registrar-docente',
  standalone: true,
  imports: [],
  templateUrl: './registrar-docente.component.html',
  styleUrl: './registrar-docente.component.css'
})
export class RegistrarDocenteComponent {
  docentes: Docente[] = []

  ngOnInit():void{
  }
}
