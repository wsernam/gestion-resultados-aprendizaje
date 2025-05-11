import { Component } from '@angular/core';
import { CompetenciasAprendizajeP } from '../listarCompetenciasAprendizajeP/competencias-aprendizaje-p';
import { CommonModule } from '@angular/common';
import { CompetenciasAprendizajePService } from '../serviciosCAP/competencias-aprendizaje-p.service';
import { Router, RouterLink } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-competencias-aprendizaje-p',
  standalone: true,
  imports: [CommonModule, RouterLink, HttpClientModule],
  templateUrl: './competencias-aprendizaje-p.component.html',
  styleUrl: './competencias-aprendizaje-p.component.css'
})
export class CompetenciasAprendizajePComponent {
  competenciasAprendizajeP: CompetenciasAprendizajeP[] = [];

  constructor(private objCAPService: CompetenciasAprendizajePService, private router: Router) {}

  ngOnInit():void{
    this.objCAPService.getCompetenciasAprendizajeP().subscribe(
      competenciasAprendizajeP => {
        console.log("Listando competencias de aprendizaje");
        this.competenciasAprendizajeP = competenciasAprendizajeP;
      }
    );
  }
}
