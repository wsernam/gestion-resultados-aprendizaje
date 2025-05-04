import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {
  public proyecto: any = {anio: '2025', nombreProyecto: 'Proyecto de Clase'};
  public autores: String = 'Desarrollado por Ashlee Campaz, Lina Díaz, Ana Quira, William Serna';
}
