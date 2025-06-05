import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Curso } from '../../modelos/curso';
import { CursoService } from '../services/curso.service';
import { CrearCursosComponent } from '../crear-cursos/crear-cursos.component';
import { ConsultarCurso } from '../../modelos/consultar-curso';
import { StorageServiceService } from '../../../Servicios/storage-service.service';

@Component({
  selector: 'app-listar-curso',
  standalone: true,
  imports: [CommonModule, RouterLink, CrearCursosComponent],
  templateUrl: './listar-curso.component.html',
  styleUrl: './listar-curso.component.css'
})
export class ListarCursoComponent {

  cursos: ConsultarCurso[] = [];
  cedula: number = 0;
  mostrarCrear = false;
  isEvaluador = false;

  constructor(private objCursoService: CursoService, private router: Router, private storageService: StorageServiceService) { }

  ngOnInit(): void {
    const roles = this.storageService.getRoles() || [];
    console.log("Roles del usuario:", roles);
    this.isEvaluador = roles.includes('EVALUADOR');
    
    const cedulaGuardada = sessionStorage.getItem('cedula');
    if (cedulaGuardada) {
      this.cedula = Number(cedulaGuardada);
    }
    this.objCursoService.getCursosDocente(this.cedula).subscribe(
      cursos => {
        console.log("Listando cursos desde el componente...");
        this.cursos = cursos;
      }
    );

    this.objCursoService.cursoCreado$.subscribe(() => {
      this.objCursoService.getCursosDocente(this.cedula).subscribe(
        cursos => {
          console.log("Actualizando lista de cursos tras creación...");
          this.cursos = cursos;
        }
      );
    });

  }

  toggleCrear() {
    this.mostrarCrear = !this.mostrarCrear;
  }
}
