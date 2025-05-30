import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { ResultadoA } from '../../../Modelos/resultado-a';
import { ResultadosAService } from '../../service/resultados-a.service';

@Component({
  selector: 'app-listar-raa',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './listar-raa.component.html',
  styleUrl: './listar-raa.component.css'
})
export class ListarRAAComponent {
  
  resultadosA: ResultadoA[] = [];

  constructor(private objResultadosAService: ResultadosAService, private router: Router) {}

  ngOnInit(): void {
    this.objResultadosAService.getResultadosA().subscribe(
      resultadosA => {
        console.log("Listando resultados de aprendizaje de asignatura desde el componente");
        this.resultadosA = resultadosA;
      }
    );
  }
}
