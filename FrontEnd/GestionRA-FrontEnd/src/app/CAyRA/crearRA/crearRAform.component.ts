import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { ResultadoP } from '../resultado-p';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { ResultadoPService } from '../serviciosRA/resultados-p.service';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [ FormsModule, SweetAlert2Module, HttpClientModule],
  templateUrl: './crearRAform.component.html',
  styleUrl: './crearRAform.component.css'
})

export class FormComponent {
  public resultadoP: ResultadoP = new ResultadoP();
  public title: String = 'Crear resultado de aprendizaje';

  constructor(private resultadoPService: ResultadoPService, private router: Router) {}

  public crearResultadoP() {
    console.log("Creando resultado de aprendizaje de programa");
    this.resultadoPService.create(this.resultadoP).subscribe(
      response =>
      {
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

  ngOnInit() {
    // Implementar combox
  }

}
