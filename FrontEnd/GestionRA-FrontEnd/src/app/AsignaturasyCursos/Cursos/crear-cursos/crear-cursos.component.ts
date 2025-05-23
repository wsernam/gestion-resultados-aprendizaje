import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormComponent } from '../../../DocentesyEvaluadores/registrar-docente/form.component';
import { FormsModule, NgForm } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CursoService } from '../services/curso.service';
import { Router, RouterLink } from '@angular/router';
import Swal from 'sweetalert2';
import { Docente } from '../../../DocentesyEvaluadores/Modelos/docente';
import { Periodo } from '../../modelos/periodo';
import { AsignaturaService } from '../services/asignatura.service';
import { DocenteService } from '../../../DocentesyEvaluadores/servicios/docente.service';
import { PeriodoService } from '../services/periodo.service';
import { Curso } from '../../modelos/curso';
import { Asignatura } from '../../modelos/asignatura';

@Component({
  selector: 'app-crear-cursos',
  standalone: true,
  imports: [FormsModule, CommonModule, SweetAlert2Module, HttpClientModule, RouterLink],
  templateUrl: './crear-cursos.component.html',
  styleUrl: './crear-cursos.component.css'
})
export class CrearCursosComponent {

  public curso: Curso = new Curso();
  public title: String = 'Crear curso';
  asignaturas: Asignatura[] = []
  docentes: Docente[] = []
  periodos: Periodo[] = []

  constructor(private cursoService: CursoService, private asignaturaService: AsignaturaService, private docenteService: DocenteService, private periodoService: PeriodoService, private router: Router) { }

  ngOnInit(): void
  {
    /*
     * Cargar asignaturas
     */
    this.asignaturaService.getAsignaturas().subscribe(
      (data) => {
        this.asignaturas = data;
      },
      (error) => {
        console.error('Error cargando asignaturas', error);
      }
    );

    /**
     * Cargar docentes
     */
    this.docenteService.getDocentes().subscribe(
      (data) => {
        this.docentes = data;
      },
      (error) => {
        console.error('Error cargando docentes', error);
      }
    );

    /**
     * Cargar peridos
     */
    this.periodoService.getPeriodos().subscribe(
      (data) => {
        this.periodos = data;
      },
      (error) => {
        console.error('Error cargando periodos', error);
      }
    );
  }

  public crearCurso(form: NgForm) {

    if (form.invalid) {
      Swal.fire('Formulario incompleto', 'Por favor completa todos los campos.', 'warning');
      return;
    }

    console.log("Creando curso...");

    this.cursoService.create(this.curso).subscribe
      (
        response => {
          console.log("Resultado de aprendizaje creado exitosamente");
          console.log(this.curso);
          this.router.navigate(['cursos/listarCursos']);
          Swal.fire('Nuevo curso', `Curso ${response.id} creado con éxito`, 'success')
            .then(() => {
              this.router.navigate(['/cursos/listarCursos']);
            });
        },
        error => {
          console.log("Error al crear curso");
          Swal.fire('Error al crear Curso', `Ha ocurrido un error al crear el curso`, 'warning');
        }
      );

  }

}
