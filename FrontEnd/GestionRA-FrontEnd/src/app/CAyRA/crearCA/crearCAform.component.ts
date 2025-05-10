import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { CompetenciaP } from '../competencia-p';
import { CompetenciaPService } from '../serviciosCa/competencia-p.service';
import { Router } from '@angular/router';
import { response } from 'express';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [ FormsModule, SweetAlert2Module, HttpClientModule],
  templateUrl: './crearCAform.component.html',
  styleUrl: './crearCaform.component.css'
})
export class FormComponent {
  public competenciaP: CompetenciaP = new CompetenciaP();
  public title: String = 'Crear compentencia de aprendizaje';

  constructor(private competenciaPService: CompetenciaPService, private router: Router) {}

  public crearCompetenciaP() {
    console.log("Creando compentencia de programa");
    this.competenciaPService.create(this.competenciaP).subscribe(
      response =>
      {
        console.log("Competencia de aprendizaje creada exitosamente");
        console.log(this.competenciaP);
        this.router.navigate(['CAyRA/listarCa']),
        Swal.fire('Nueva compentecia de aprendizaje', `Competencia ${this.competenciaP.descripcion} creada con éxito`, 'success');
      },
      error => {
        console.error("Error al registrar compentencia de aprendizaje", error);
        Swal.fire('Error', 'Hubo un problema al registrar una compentencia de aprendizaje', 'error');
      }
    )
  }

}
