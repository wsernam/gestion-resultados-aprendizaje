import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ResultadoP } from '../../../Modelos/resultado-p';

@Component({
  selector: 'app-resultados-p',
  standalone: true,
  imports: [ CommonModule, RouterLink ],
  templateUrl: './resultados-p.component.html',
  styleUrl: './resultados-p.component.css'
})

export class ResultadosPComponent {
  resultadop: ResultadoP[] = []
  public title: String = 'Crear Resultado de Aprendizaje'

  ngOnInit():void {

  }
}
