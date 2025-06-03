import { Component } from '@angular/core';
import { Rubrica } from '../Modelos/rubrica';
import { RubricaService } from '../Service/rubrica.service';
import { Router, RouterLink } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { InvitarEvaluadorComponent } from "../../DocentesyEvaluadores/Evaluadores/InvitarEvaluador/invitar-evaluador.component";

@Component({
  selector: 'app-listar-rubrica',
  standalone: true,
  imports: [CommonModule, RouterLink, HttpClientModule, InvitarEvaluadorComponent],
  templateUrl: './listar-rubrica.component.html',
  styleUrl: './listar-rubrica.component.css'
})
export class ListarRubricaComponent {

  rubricas: Rubrica[] = [];

  constructor(private rubricaService: RubricaService, private router: Router) { }

  ngOnInit(): void {
    this.rubricaService.getRubricas().subscribe(
      rubrica => {
        console.log("Listando rúbricas desde el componente...");
        this.rubricas = rubrica;
      },
      error => {
        console.log("Ha ocurrido un error al listar las rúbricas");
        console.error(error);
      }
    );

    this.rubricaService.rubricaCreada$.subscribe(
      nuevaRubrica => {
        this.rubricas.push(nuevaRubrica);
        console.log("Nueva rúbrica añadida a la lista: ", nuevaRubrica);
      }
    )
  }

  mostrarModalInvitar = false;

  abrirModalInvitarEvaluador() {
    this.mostrarModalInvitar = true;
  }

  /*
  invitarEvaluador(correo: string) {
    // Aquí llamas a tu servicio para invitar evaluador
    this.rubricaService.invitarEvaluador(correo, idCurso).subscribe(...);
    this.mostrarModalInvitar = false;
  }
    */

}
