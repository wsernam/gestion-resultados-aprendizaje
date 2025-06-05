import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { ResultadoA } from '../../../Modelos/resultado-a';
import { ResultadosAService } from '../../service/resultados-a.service';
import Swal from 'sweetalert2';
import { CompetenciasAprendizajeP } from '../../../Modelos/competencias-aprendizaje-p';
import { CompetenciaAprendizajeA } from '../../../Modelos/competencia-aprendizaje-a';
import { CompetenciaAsignaturaService } from '../../../CompetenciasAprendizaje/CompetenciasAsignatura/ServiceCompetenciaAsignatura/competencia-asignatura.service';

@Component({
  selector: 'app-crear-raa',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule, RouterLink],
  templateUrl: './crear-raa.component.html',
  styleUrl: './crear-raa.component.css'
})
export class CrearRAAComponent {
  public resultadoA: ResultadoA = new ResultadoA();
  public titulo: String = 'Crear Resultado de Aprendizaje Asignatura';
  public competencias: CompetenciaAprendizajeA[] = [];
  constructor(private competenciaAService: CompetenciaAsignaturaService, private resultadoAService: ResultadosAService, private router: Router) { }

  public registrarResultadoA() {
    console.log("Registrando Resultado de Aprendizaje Asignatura: ", this.resultadoA);
    this.resultadoAService.create(this.resultadoA).subscribe({
      next: response => {
        console.log("Resultado de Aprendizaje Asignatura creado exitosamente");
        console.log(this.resultadoA);
        this.router.navigate(['/competencias-ra'])
        Swal.fire('Nuevo Resultado de Aprendizaje Asignatura', `Resultado de Aprendizaje Asignatura ${response.competenciaAsignaturaId} creado con éxito`, 'success');
      },
      error: error => {
        console.error("Error al registrar Resultado de Aprendizaje Asignatura: ", error.mesage);
        //Swal.fire('Error', 'Hubo un problema al crear Resultado de Aprendizaje Asignatura', 'error');
      }
    });
  }

  ngOnInit(): void {
    this.competenciaAService.getCompetenciasAsignatura().subscribe(
      
      competenciasA_response => {this.competencias = competenciasA_response, console.log(competenciasA_response)}
    )

  }

}
