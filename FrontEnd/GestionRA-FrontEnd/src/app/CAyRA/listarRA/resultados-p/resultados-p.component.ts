import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ResultadoP } from '../../resultado-p';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-compentecias-p',
  standalone: true,
  imports: [ CommonModule, RouterLink ],
  templateUrl: './resultados-p.component.html',
  styleUrl: './resultados-p.component.css'
})

export class CompenteciasPComponent {
  resultadop: ResultadoP[] = []

  ngOnInit():void {

  }
}
