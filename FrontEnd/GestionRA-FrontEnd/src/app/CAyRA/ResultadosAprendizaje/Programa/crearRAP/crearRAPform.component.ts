import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { Router, RouterLink } from '@angular/router';
import Swal from 'sweetalert2';
import { ResultadoP } from '../../../Modelos/resultado-p';
import { CompetenciasAprendizajeP } from '../../../Modelos/competencias-aprendizaje-p';
import { CompetenciasAprendizajePService } from '../../../CompetenciasAprendizaje/serviciosCAP/competencias-aprendizaje-p.service';
import { ResultadoPService } from '../../service/resultados-p.service';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [FormsModule, SweetAlert2Module, HttpClientModule, RouterLink],
  templateUrl: './crearRAPform.component.html',
  styleUrl: './crearRAPform.component.css'
})

export class FormComponent {
  public resultadoP: ResultadoP = new ResultadoP();
  public title: String = 'Crear resultado de aprendizaje';
  public competencias: CompetenciasAprendizajeP[] = []

  constructor(private resultadoPService: ResultadoPService, private competenciaService: CompetenciasAprendizajePService, private router: Router) { }

  ngOnInit() {
    this.competenciaService.getCompetenciasAprendizajeP().subscribe(
      (data) => {
        this.competencias = data;
      },
      (error) => {
        console.error('Error cargando competencias de aprendizaje', error);
      }
    );
  }

  public crearResultadoP(form: NgForm) {

    if (form.invalid) {
      Swal.fire('Formulario incompleto', 'Por favor completa todos los campos.', 'warning');
      return;
    }

    console.log("Creando resultado de aprendizaje de programa");
    this.resultadoPService.create(this.resultadoP).subscribe(
      response => {
        console.log("Resultado de aprendizaje creado exitosamente");
        console.log(this.resultadoP);
        this.router.navigate(['CAyRA/listarCa']),
          Swal.fire('Nuevo resultado de aprendizaje', `Resultado: ${this.resultadoP.descripcion} creado con éxito`, 'success');
      },
      error => {
        console.error("Error al registrar el resultado de aprendizaje", error);
        Swal.fire('Error', 'Hubo un problema al registrar el resultado de aprendizaje', 'error');
      }
    );
  }

}
