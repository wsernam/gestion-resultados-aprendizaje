import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompetenciasAprendizajePComponent } from '../CAyRA/CompetenciasAprendizaje/listarCompetenciasAprendizajeP/competencias-aprendizaje-p.component';
import { FormCAPComponent } from '../CAyRA/CompetenciasAprendizaje/crearCompetenciasAprendizajeP/form-cap.component';
import { ListarCompentenciaAComponent } from '../CAyRA/CompetenciasAprendizaje/CompetenciasAsignatura/ListarCompetenciaAsignatura/listar-compentencia-a.component';
import { CrearCompetenciasAComponent } from '../CAyRA/CompetenciasAprendizaje/CompetenciasAsignatura/CrearCompenteciaAsignatura/crear-competencias-a/crear-competencias-a.component';
import { ResultadosPComponent } from '../CAyRA/ResultadosAprendizaje/ListarRAP/resultados-p.component';

@Component({
  selector: 'app-competencias-ra',
  standalone: true,
  imports: [
    CommonModule,
    CompetenciasAprendizajePComponent,
    FormCAPComponent,
    ListarCompentenciaAComponent,
    CrearCompetenciasAComponent,
    ResultadosPComponent
  ],
  templateUrl: './competencias-ra.component.html',
  styleUrl: './competencias-ra.component.css'
})
export class CompetenciasRaComponent {}
