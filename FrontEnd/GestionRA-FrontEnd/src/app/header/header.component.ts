import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {
  public title: string = 'Universidad del Cauca';
  public facultad: string = 'Facultad de Ingeniería Electrónica y Telecomunicaciones';
  public programa: string = 'Ingeniería de Sistemas';
  public descripcion: string = 'Sistema de gestión de evaluación de resultados de aprendizaje (RA).';
}
