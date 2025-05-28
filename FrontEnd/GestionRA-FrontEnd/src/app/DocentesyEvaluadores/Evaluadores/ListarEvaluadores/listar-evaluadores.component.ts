import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { Evaluador } from '../../Modelos/evaluador';
import { EvaluadorService } from '../Service/evaluador.service';

@Component({
  selector: 'app-listar-evaluadores',
  standalone: true,
  imports: [ CommonModule, RouterLink ],
  templateUrl: './listar-evaluadores.component.html',
  styleUrl: './listar-evaluadores.component.css'
})
export class ListarEvaluadoresComponent {

  evaluadores: Evaluador[] = [];

  constructor(private evaluadorService: EvaluadorService, private router: Router) {}

  ngOnInit(): void
  {
    this.evaluadorService.getEvaluadores().subscribe(
      response => {
        console.log("Listando evaluadores desde el componente");
        this.evaluadores = response;
      },
      error => {
        console.log("Ha ocurrido un error al listar docentes");
        console.log("Error: ", error);
      }
    );
  }

}
