import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { CompetenciaAprendizajeA } from '../../../../Modelos/competencia-aprendizaje-a';
import { CompetenciaAsignaturaService } from '../../ServiceCompetenciaAsignatura/competencia-asignatura.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-crear-competencias-a',
  standalone: true,
  imports: [ FormsModule, SweetAlert2Module, HttpClientModule ],
  templateUrl: './crear-competencias-a.component.html',
  styleUrl: './crear-competencias-a.component.css'
})
export class CrearCompetenciasAComponent {
  public competenciaA: CompetenciaAprendizajeA = new CompetenciaAprendizajeA();
  public title: string = "Crear Competencia de Aprendizaje de Asignatura";

  constructor (private competenciaAService: CompetenciaAsignaturaService, private router: Router) {}

  public crearCAA()
  {    
    this.competenciaAService.create(this.competenciaA).subscribe(
      response => {
        console.log("Creando compentencia de aprendizaje de asignatura");
        console.log(this.competenciaA);
        this.router.navigate(['/compentenciasAprendizaje/listarCompetenciasAprendizajeA']);
        Swal.fire('Nueva competencia de aprendizaje de programa', `Competencia de aprendizaje de programa ${this.competenciaA.id} creada con éxito`, 'success');
      },
      error => {
        console.log("Ha ocurrido un error", error);
        Swal.fire('Error', `Ha ocurrido un error`, 'error');
      }
    )
  }
}
