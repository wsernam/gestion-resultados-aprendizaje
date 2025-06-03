import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, ViewChild } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Evaluador } from '../../Modelos/evaluador';
import { EvaluadorService } from '../Service/evaluador.service';
import { Router, RouterLink } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-registrar-evaluador',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule, RouterLink ],
  templateUrl: './registrar-evaluador.component.html',
  styleUrl: './registrar-evaluador.component.css'
})
export class RegistrarEvaluadorComponent {
  public evaluador: Evaluador = new Evaluador();
  public title: string = 'Registrar evaluador';
  @ViewChild('formEvaluador') formEvaluador!: NgForm;

  constructor(private evaluadorService: EvaluadorService, private router: Router) { 
  }

  public registrarEvaluador() {
    console.log("Registrando evaluador...");

    if (this.formEvaluador.invalid) {
      Swal.fire('Formulario incorrecto', 'Verifica los campos obligatorios.', 'warning');
      return;
    }

    this.evaluadorService.createEvaluador(this.evaluador).subscribe(
      {
        next: (response) => {
          this.router.navigate(['Login']);
          console.log("Evaluador registrado con éxito: ", this.evaluador);
          Swal.fire('Registro exitoso', `Evaluador ${response.nombres} registrado con éxito`, 'success');
        },
        error: (err) => {
          console.log("Error al registrar evaluador.\n Error: ", err.message);
          Swal.fire('Error', `Hubo un problema al registrar el evaluador`, 'error');
        }
      }
    )
  }
}
