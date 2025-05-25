import { Component } from '@angular/core';
import { CompetenciasAprendizajeP } from '../../Modelos/competencias-aprendizaje-p';
import { CompetenciasAprendizajePService } from '../serviciosCAP/competencias-aprendizaje-p.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import Swal from 'sweetalert2';
import { HttpClientModule } from '@angular/common/http';
import { response } from 'express';

@Component({
  selector: 'app-form-cap',
  standalone: true,
  imports: [FormsModule, SweetAlert2Module, HttpClientModule],
  templateUrl: './form-cap.component.html',
  styleUrl: './form-cap.component.css'
})
export class FormCAPComponent {
  public competenciasAprendizajeP: CompetenciasAprendizajeP = new CompetenciasAprendizajeP();
  public titulo: string = "Crear Competencias de Aprendizaje";

  constructor(private competenciasAprendizajePService: CompetenciasAprendizajePService,
    private router: Router) { }

  public crearCAP() {
    console.log('Creando Competencias de Aprendizaje de Programa');
    this.competenciasAprendizajePService.create(this.competenciasAprendizajeP).subscribe(
      response => {
        console.log("Creando Competencias de Aprendizaje de Programa");
        console.log(this.competenciasAprendizajeP);
        this.router.navigate(['/CompetenciasAprendizaje/listarCompetenciasAprendizajeP']);
        Swal.fire('Nueva Competencias de Aprendizaje de Programa', `Competencias de Aprendizaje de Programa ${this.competenciasAprendizajeP.id} creado con éxito`, 'success');
      }
    )
  }
}
