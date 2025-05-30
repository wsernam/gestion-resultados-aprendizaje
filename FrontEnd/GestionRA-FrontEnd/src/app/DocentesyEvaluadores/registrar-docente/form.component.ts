import { HttpClientModule } from '@angular/common/http';
import { Component, importProvidersFrom } from '@angular/core';
import { Docente } from '../Modelos/docente';
import { Router, RouterLink } from '@angular/router';
import { DocenteService } from '../servicios/docente.service';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { CommonModule } from '@angular/common';
import { error } from 'console';
import { MockDocenteService } from '../servicios/docente.service.mock';

@Component({
  selector: 'app-form',
  standalone: true,
  imports: [ CommonModule, FormsModule, HttpClientModule, RouterLink],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})

export class FormComponent {
  public docente: Docente;
  public titulo: String = 'Registrar docente';
  public repetirContrasenia: string = '';
  public contraseniasCoinciden: boolean = true;

  constructor(private docenteService: DocenteService, private router: Router) { 

    // Inicializar el docente con valores por defecto si es necesario
    this.docente = new Docente();
    this.docente.nombres = '';
    this.docente.apellidos = '';
    this.docente.correo = '';
    this.docente.titulo = '';
    this.docente.tipo = '';
    this.docente.contrasenia = '';

  }
  //constructor(private docenteService: MockDocenteService, private router: Router) { }
  
  public validarContrasenias(){
    this.contraseniasCoinciden = this.docente.contrasenia === this.repetirContrasenia || !this.repetirContrasenia;
  }

  public registrarDocente() {
    this.contraseniasCoinciden = true;
    if(this.docente.contrasenia !== this.repetirContrasenia) {
      this.contraseniasCoinciden = false;
      return;
    }
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

