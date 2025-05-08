import { Component } from '@angular/core';
import { Docente } from '../../docente';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-listar-docentes',
  standalone: true,
  imports: [ CommonModule, RouterLink ],
  templateUrl: './listar-docentes.component.html',
  styleUrl: './listar-docentes.component.css'
})
export class ListarDocentesComponent {

  docentes: Docente[]=[]
  
    ngInit():void {
  
      //Lee los nombres
  
    }

}
