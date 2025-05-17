import { HttpClientModule } from '@angular/common/http';
import { Component, importProvidersFrom } from '@angular/core';
import { Docente } from '../../Modelos/docente';
import { Router } from '@angular/router';
import { DocenteService } from '../servicios/docente.service';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';
import { error } from 'console';
import { MockDocenteService } from '../servicios/docente.service.mock';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [ CommonModule, FormsModule, HttpClientModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})

export class FormComponent {
  public docente: Docente = new Docente();
  public titulo: String = 'Registrar docente';

  constructor(private docenteService: DocenteService, private router: Router) { }
  //constructor(private docenteService: MockDocenteService, private router: Router) { }  

  public registrarDocente() {
    console.log("Registrando docente : ", this.docente);
    console.log("Docente: ", this.docente);
    this.docenteService.create(this.docente).subscribe(
      response => 
      {
        console.log("Docente creado exitosamente");
        console.log(this.docente);
        this.router.navigate(['docentes/listarDocentes'])
        Swal.fire('Nuevo docente', `Docente ${response.nombres} creado con éxito`, 'success');
      },
      error => {
        console.error("Error al registrar docente: ", error);
        Swal.fire('Error', 'Hubo un problema al registrar el docente', 'error');
      }
    );
  }
}

