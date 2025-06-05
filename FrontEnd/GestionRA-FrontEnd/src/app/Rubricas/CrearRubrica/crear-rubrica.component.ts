import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { Rubrica } from '../Modelos/rubrica';
import { RubricaService } from '../Service/rubrica.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import Swal from 'sweetalert2';
import { Criterio } from '../Modelos/criterio';
import { Nivel } from '../Modelos/nivel';
import { CommonModule } from '@angular/common';
import { ResultadosAService } from '../../CAyRA/ResultadosAprendizaje/service/resultados-a.service';
import { ResultadoA } from '../../CAyRA/Modelos/resultado-a';
import { CursoService } from '../../AsignaturasyCursos/Cursos/services/curso.service';
import { AsignaturaService } from '../../AsignaturasyCursos/Cursos/services/asignatura.service';

@Component({
  selector: 'app-crear-rubrica',
  standalone: true,
  imports: [CommonModule, FormsModule, SweetAlert2Module, HttpClientModule, RouterLink],
  templateUrl: './crear-rubrica.component.html',
  styleUrl: './crear-rubrica.component.css'
})
export class CrearRubricaComponent {

  public rubrica: Rubrica = new Rubrica();
  public title: String = "Crear rúbrica";
  resultadosAprendizaje: ResultadoA[] = [];
  idAsignatura: string = '';
  idCurso: string = '';

  constructor(private raaService: ResultadosAService, private cursoService: CursoService, private asignaturaService: AsignaturaService, private rubricaService: RubricaService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.idCurso = this.route.snapshot.paramMap.get('idCurso') || '';
    console.log("ID del curso recibido: ", this.idCurso);

    // Obtén el curso y luego la asignatura asociada
    this.cursoService.getCursoById(this.idCurso).subscribe(
      curso => {
        const nombreAsignatura = curso.asignatura.nombre;
        // Busca la asignatura por nombre para obtener el id
        this.asignaturaService.getAsignaturaByName(nombreAsignatura).subscribe(
          asignatura => {
            this.idAsignatura = asignatura.id;
            this.cargarResultadosAprendizaje();
          },
          error => {
            console.log("No se pudo obtener la asignatura por nombre.");
          }
        );
      },
      error => {
        console.log("No se pudo obtener el curso para extraer la asignatura.");
      }
    );
  }

  cargarResultadosAprendizaje() {
    this.raaService.getResultadosAPorAsignatura(this.idAsignatura).subscribe(
      resultados => {
        this.resultadosAprendizaje = resultados;
        console.log("Resultados de Aprendizaje cargados: ", resultados);
      }
    );
  }

  public agregarCriterio() {
    const nuevoCriterio = new Criterio();
    this.rubrica.criterios.push(nuevoCriterio);
  }

  public eliminarCriterio(index: number) {
    this.rubrica.criterios.splice(index, 1);
  }

  public agregarNivel(index: number) {
    const nuevoNivel = new Nivel();
    this.rubrica.criterios[index].niveles.push(nuevoNivel);
  }

  public eliminarNivel(criterioIndex: number, nivelIndex: number) {
    this.rubrica.criterios[criterioIndex].niveles.splice(nivelIndex, 1);
  }


  public guardarRubrica() {
    this.rubricaService.createRubrica(this.rubrica).subscribe(
      response => {
        console.log("Creando Rúbrica...");
        this.rubrica.idCurso = this.idCurso; //Asignar el ID del curso a la rúbrica
        this.rubricaService.noficarRubricaCreada(response); //Notificar a otros componentes que se ha creado una rúbrica
        console.log("Rúbrica creada con éxito");
        this.router.navigate(['/rubricas', this.idCurso]); //Redirigir a la lista de rúbricas del curso
        Swal.fire('Rúbrica creada', `Rubrica creada con éxito`, 'success');
      },
      error => {
        console.log("Ha ocurrido un error: ", error);
        Swal.fire('Error', `Ha ocurrido un error al crear la rúbrica ${error}`, 'error');
      }
    )
  }

  public cancelarCreacion() {
    this.router.navigate(['/rubricas', this.idCurso]); //Redirigir a la lista de rúbricas del curso
  }

}
