import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistrarEvaluadorComponent } from '../DocentesyEvaluadores/Evaluadores/RegistrarEvaluadores/registrar-evaluador.component';
import { FormComponent } from '../DocentesyEvaluadores/registrar-docente/form.component';
import { Router } from 'express';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-registrar',
  standalone: true,
  imports: [ CommonModule, RegistrarEvaluadorComponent, FormComponent, RouterModule ],
  templateUrl: './registrar.component.html',
  styleUrl: './registrar.component.css'
})
export class RegistrarComponent {

  tipoUsuario: 'docente' | 'evaluador' = 'docente';

  seleccionar(tipo: 'docente' | 'evaluador') {
    this.tipoUsuario = tipo;
  }

}
