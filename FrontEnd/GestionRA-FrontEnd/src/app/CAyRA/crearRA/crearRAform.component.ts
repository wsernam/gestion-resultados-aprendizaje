import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { ResultadoP } from '../resultado-p';
import { ResultadoPService } from '../serviciosCa/resultados-p.service';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [ FormsModule, SweetAlert2Module, HttpClientModule],
  templateUrl: './crearRAform.component.html',
  styleUrl: './crearRAform.component.css'
})
export class FormComponent {
  public competenciaP: ResultadoP = new ResultadoP();
  public title: String = 'Crear compentencia de aprendizaje';

  constructor(private competenciaPService: ResultadoPService, private router: Router) {}

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
    );
  }
}
