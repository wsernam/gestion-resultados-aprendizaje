import { Component, ViewChild } from '@angular/core';
import { Rubrica } from '../Modelos/rubrica';
import { RubricaService } from '../Service/rubrica.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
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

  idCurso: string = '';
  rubricas: Rubrica[] = [];
  rubrica: Rubrica = new Rubrica();

  constructor(private rubricaService: RubricaService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.idCurso = this.route.snapshot.paramMap.get('idCurso') || '';
    console.log("ID del curso recibido: ", this.idCurso);
    
    this.rubricaService.getRubricas(this.idCurso).subscribe(
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

  @ViewChild('invitarEvaluador') invitarEvaluadorComponent!: InvitarEvaluadorComponent;

  abrirModalInvitar(cursoId: string) {
    this.invitarEvaluadorComponent.abrirModalInvitar(cursoId);
    console.log("Abriendo modal para invitar evaluador en curso ID: ", cursoId);
  }

}
