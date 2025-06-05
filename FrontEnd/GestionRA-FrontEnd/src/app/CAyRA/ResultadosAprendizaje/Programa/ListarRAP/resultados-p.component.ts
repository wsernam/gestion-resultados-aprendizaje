import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ResultadoP } from '../../../Modelos/resultado-p';
import { ResultadoPService } from '../../service/resultados-p.service';

@Component({
  selector: 'app-resultados-p',
  standalone: true,
  imports: [ CommonModule, RouterLink ],
  templateUrl: './resultados-p.component.html',
  styleUrl: './resultados-p.component.css'
})

export class ResultadosPComponent {
  resultadop: ResultadoP[] = []
  public title: String = 'Crear Resultado de Aprendizaje de Programa'
  constructor(private RPservice: ResultadoPService) {}
  ngOnInit():void{
    this.RPservice.getResultadoP().subscribe(
      resultadosP => {
        console.log("Listando resultados de aprendizaje de programa");
        this.resultadop = resultadosP;
      },
      error => {
        console.log("Ha ocurrido un error", error);
      }
    );
  }
}
