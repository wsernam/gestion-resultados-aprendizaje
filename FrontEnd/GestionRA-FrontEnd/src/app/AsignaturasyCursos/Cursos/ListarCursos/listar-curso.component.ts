import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Curso } from '../../modelos/curso';
import { CursoService } from '../services/curso.service';
import { CrearCursosComponent } from '../crear-cursos/crear-cursos.component';
import { ConsultarCurso } from '../../modelos/consultar-curso';
import { StorageServiceService } from '../../../Servicios/storage-service.service';
import { EvaluadorService } from '../../../DocentesyEvaluadores/Evaluadores/Service/evaluador.service';

@Component({
  selector: 'app-listar-curso',
  standalone: true,
  imports: [CommonModule, RouterLink, CrearCursosComponent],
  templateUrl: './listar-curso.component.html',
  styleUrl: './listar-curso.component.css'
})
export class ListarCursoComponent {

  cursos: ConsultarCurso[] = [];
  cursosid: string[] = [];
  cedula: number = 0;
  mostrarCrear = false;
  isEvaluador = false;
  isDocente = false;

  constructor(private objCursoService: CursoService, private router: Router, private storageService: StorageServiceService, private evaluadorService: EvaluadorService) { }

  ngOnInit(): void {
    const roles = this.storageService.getRoles() || [];
    console.log("Roles del usuario:", roles);
    this.isEvaluador = roles.includes('EVALUADOR');
    this.isDocente = roles.includes('DOCENTE');

    if (this.isDocente) {
      const cedulaGuardada = sessionStorage.getItem('cedula');
      if (cedulaGuardada) {
        this.cedula = Number(cedulaGuardada);
        this.objCursoService.getCursosDocente(this.cedula).subscribe(
          cursos => {
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
    } else if (this.isEvaluador) {
      const correo = sessionStorage.getItem('correo');
      if (correo) {
        this.evaluadorService.getCursosEvaluador(correo).subscribe(
          cursos => {
            this.cursosid = cursos;
            for (const cursoId of this.cursosid) {
              this.objCursoService.getCursoById(cursoId).subscribe(
                curso => {
                  this.cursos.push(curso);
                },
                error => {
                  console.error("Error al obtener el curso con ID:", cursoId, error);
                }
              );
            }
          }
        );
        // Si tienes un observable para actualización, agrégalo aquí también
      }
    }
   
  }

  toggleCrear() {
    this.mostrarCrear = !this.mostrarCrear;
  }
}
