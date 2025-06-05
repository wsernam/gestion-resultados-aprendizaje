import { Component } from '@angular/core';
import { Docente } from '../../Modelos/docente';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { DocenteService } from '../../servicios/docente.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-listar-docentes',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './listar-docentes.component.html',
  styleUrl: './listar-docentes.component.css'
})
export class ListarDocentesComponent {

  public filtro: string = '';
  docentes: Docente[] = [];
  docentesOriginal: Docente[] = [];

  constructor(private objDocenteService: DocenteService, private router: Router) { }

  ngOnInit(): void {
    this.objDocenteService.getDocentes().subscribe(docentes => {
      this.docentesOriginal = docentes;
      this.docentes = [...docentes];
      console.log("Listando docentes desde el componente");
    });
    /**
    this.objDocenteService.getDocentes().subscribe
      (
        docentes => {
          console.log("Listando docentes desde el componente");
          this.docentes = docentes;
        }
      );*/
  }

  filtrarDocentes() {
    if (!this.filtro) {
      this.docentes = [...this.docentesOriginal];
    } else {
      const filtroLower = this.filtro.toLowerCase();
      this.docentes = this.docentesOriginal.filter(docente =>
        docente.correo.toLowerCase().includes(filtroLower)
      );
    }
    /**
    const f = this.filtro.toLowerCase();
    this.docentes = this.docentes.filter(doc =>
      doc.correo.toLowerCase().includes(f)
    );*/
  }

}
