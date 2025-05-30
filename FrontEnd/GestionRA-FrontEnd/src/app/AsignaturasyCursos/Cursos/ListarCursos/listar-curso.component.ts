import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Curso } from '../../modelos/curso';
import { CursoService } from '../services/curso.service';
import { CrearCursosComponent } from '../crear-cursos/crear-cursos.component';

@Component({
  selector: 'app-listar-curso',
  standalone: true,
  imports: [ CommonModule, RouterLink, CrearCursosComponent],
  templateUrl: './listar-curso.component.html',
  styleUrl: './listar-curso.component.css'
})
export class ListarCursoComponent {

  cursos: Curso[] = [];
  cedula: number = 0;
  mostrarCrear = false;

  constructor (private objCursoService: CursoService, private router: Router) { }

  ngOnInit(): void {
    this.objCursoService.getCursosDocente(this.cedula).subscribe(
      cursos => {
        console.log("Listando cursos desde el componente...");
        this.cursos = cursos;
      }
    );
  }
  
  toggleCrear() {
    this.mostrarCrear = !this.mostrarCrear;
  }
}
