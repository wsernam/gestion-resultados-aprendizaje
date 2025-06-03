import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-iniviar-evaluador',
  standalone: true,
  imports: [],
  templateUrl: './invitar-evaluador.component.html',
  styleUrl: './invitar-evaluador.component.css'
})
export class InvitarEvaluadorComponent {

  @Output() cerrar = new EventEmitter<void>();
  @Output() enviarInvitacion = new EventEmitter<string>();

  correoEvaluador: string = '';

  enviar() {
    this.enviarInvitacion.emit(this.correoEvaluador);
  }

  cancelar() {
    this.cerrar.emit();
  }

}
