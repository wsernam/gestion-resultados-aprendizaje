import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { CompetenciaAprendizajeA } from '../../../../Modelos/competencia-aprendizaje-a';
import { CompetenciaAsignaturaService } from '../../ServiceCompetenciaAsignatura/competencia-asignatura.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { CompetenciasAprendizajePService } from '../../../serviciosCAP/competencias-aprendizaje-p.service';
import { CompetenciasAprendizajeP } from '../../../../Modelos/competencias-aprendizaje-p';
import { Asignatura } from '../../../../../AsignaturasyCursos/modelos/asignatura';
import { CommonModule } from '@angular/common';
import { AsignaturaService } from '../../../../../AsignaturasyCursos/Cursos/services/asignatura.service'
@Component({
  selector: 'app-crear-competencias-a',
  standalone: true,
  imports: [CommonModule, FormsModule, SweetAlert2Module, HttpClientModule],
  templateUrl: './crear-competencias-a.component.html',
  styleUrl: './crear-competencias-a.component.css'
})
export class CrearCompetenciasAComponent {
  public competenciaA: CompetenciaAprendizajeA = new CompetenciaAprendizajeA();
  public competenciasPrograma: CompetenciasAprendizajeP[] = [];
  public asignaturas: Asignatura[] = [];
  public title: string = "Crear Competencia de Asignatura";

  constructor(private asignaturaService: AsignaturaService, private competenciaPService: CompetenciasAprendizajePService, private competenciaAService: CompetenciaAsignaturaService, private router: Router) { }

  public crearCAA() {
    this.competenciaAService.create(this.competenciaA).subscribe({
      next: response => {
        console.log("Creando compentencia de aprendizaje de asignatura");
        console.log(this.competenciaA);
        // this.router.navigate(['/compentenciasAprendizaje/listarCompetenciasAprendizajeA']);
        Swal.fire('Nueva competencia de aprendizaje de programa', `Competencia de asignatura creada con éxito`, 'success');
      },
      error: error => {
        console.log("Error al crear competencia de aprendizaje de programa", error.message);
        //Swal.fire('Error', `Ha ocurrido un error`, 'error');
      }
    });
  }

  ngOnInit(): void {
    this.competenciaPService.getCompetenciasAprendizajeP().subscribe(
      competenciasP => this.competenciasPrograma = competenciasP
    )
    this.asignaturaService.getAsignaturas().subscribe(
      asignaturas_response => this.asignaturas = asignaturas_response
    )
  }
}
