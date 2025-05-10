import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompetenciaP } from '../../competencia-p';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-compentecias-p',
  standalone: true,
  imports: [ CommonModule, RouterLink ],
  templateUrl: './compentecias-p.component.html',
  styleUrl: './compentecias-p.component.css'
})

export class CompenteciasPComponent {
  cp: CompetenciaP[] = []

  ngOnInit():void {

  }
}
