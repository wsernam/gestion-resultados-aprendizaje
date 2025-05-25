import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { Rubrica } from '../Modelos/rubrica';
import { RubricaService } from '../Service/rubrica.service';
import { Router, RouterLink } from '@angular/router';
import Swal from 'sweetalert2';
import { Criterio } from '../Modelos/criterio';
import { Nivel } from '../Modelos/nivel';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-crear-rubrica',
  standalone: true,
  imports: [CommonModule, FormsModule, SweetAlert2Module, HttpClientModule, RouterLink],
  templateUrl: './crear-rubrica.component.html',
  styleUrl: './crear-rubrica.component.css'
})
export class CrearRubricaComponent {

  public rubrica: Rubrica = new Rubrica();
  public title: String = "Crear rúbrica";
  
  constructor(private rubricaService: RubricaService, private router: Router) { }

  public agregarCriterio()
  {
    const nuevoCriterio = new Criterio();
    this.rubrica.listaCriterios.push(nuevoCriterio);
  }

  public eliminarCriterio(index: number)
  {
    this.rubrica.listaCriterios.splice(index, 1);
  }

  public agregarNivel(index: number)
  {
    const nuevoNivel = new Nivel();
    this.rubrica.listaCriterios[index].listaNiveles.push(nuevoNivel);
  }

  public eliminarNivel(criterioIndex: number, nivelIndex: number)
  {
    this.rubrica.listaCriterios[criterioIndex].listaNiveles.splice(nivelIndex, 1);
  }


  public guardarRubrica()
  {
    this.rubricaService.createRubrica(this.rubrica).subscribe(
      response => {
        console.log("Creando Rúbrica...");
        console.log(this.rubrica);
        this.router.navigate(['/']);
        Swal.fire('Rúbrica creada', `Rubrica creada con éxito`, 'success');
      },
      error => {
        console.log("Ha ocurrido un error: ", error);
        Swal.fire('Error', `Ha ocurrido un error al crear la rúbrica ${error}`, 'error');
      }
    )

  }

}
