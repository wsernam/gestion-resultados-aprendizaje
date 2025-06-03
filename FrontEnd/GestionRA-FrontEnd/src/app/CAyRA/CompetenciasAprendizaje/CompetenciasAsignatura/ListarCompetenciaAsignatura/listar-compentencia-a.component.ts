import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { CompetenciaAprendizajeA } from '../../../Modelos/competencia-aprendizaje-a';
import { CompetenciaAsignaturaService } from '../ServiceCompetenciaAsignatura/competencia-asignatura.service';

@Component({
  selector: 'app-listar-compentencia-a',
  standalone: true,
  imports: [CommonModule, RouterLink, HttpClientModule],
  templateUrl: './listar-compentencia-a.component.html',
  styleUrl: './listar-compentencia-a.component.css'
})
export class ListarCompentenciaAComponent {

  competenciasA: CompetenciaAprendizajeA[] = [];

  constructor(private objCAAService: CompetenciaAsignaturaService, private router: Router) { }

  ngOnInit(): void {
    this.objCAAService.getCompetenciasAsignatura().subscribe(
      competenciasA => {
        console.log("Listando competencias de asignatura...");
        this.competenciasA = competenciasA;
      },
      error => {
        console.log("Ha ocurrido un error");
        console.error(error);
      }
    );
  }
}
