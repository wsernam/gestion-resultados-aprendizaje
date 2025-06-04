import { Component, EventEmitter, Output } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DocenteService } from '../../servicios/docente.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import Swal from 'sweetalert2';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';

@Component({
  selector: 'app-iniviar-evaluador',
  standalone: true,
  imports: [CommonModule, FormsModule, SweetAlert2Module],
  templateUrl: './invitar-evaluador.component.html',
  styleUrl: './invitar-evaluador.component.css'
})
export class InvitarEvaluadorComponent {

  mostrarModalInvitar = false;
  correoEvaluador = '';
  cursoIdSeleccionado = '';

  constructor(private http: HttpClient, private docenteService: DocenteService) { }

  abrirModalInvitar(cursoId: string) {
    this.cursoIdSeleccionado = cursoId;
    this.mostrarModalInvitar = true;
    this.correoEvaluador = '';
  }

  cerrarModalInvitar() {
    this.mostrarModalInvitar = false;
    this.correoEvaluador = '';
  }

  invitarEvaluador() {
    if (!this.correoEvaluador) return;
    this.docenteService.invitarEvaluador(this.correoEvaluador, this.cursoIdSeleccionado).subscribe({
      next: res => {
        Swal.fire('Éxito', 'Evaluador invitado correctamente', 'success');
        this.cerrarModalInvitar();
      },
      error: err => {
        Swal.fire('Error', 'Error al invitar evaluador', 'error');
      }
    });
  }
}
