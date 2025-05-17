import { Component } from '@angular/core';
import { Docente } from '../../../Modelos/docente';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { DocenteService } from '../../servicios/docente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-docentes',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './listar-docentes.component.html',
  styleUrl: './listar-docentes.component.css'
})
export class ListarDocentesComponent {

  docentes: Docente[] = [];

  constructor(private objDocenteService: DocenteService, private router: Router) { }

  ngOnInit(): void {
    this.objDocenteService.getDocentes().subscribe
    (
      docentes => {
        console.log("Listando docentes desde el componente");
        this.docentes = docentes;
      }
    );
  }

}
