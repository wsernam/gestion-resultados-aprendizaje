import { HttpClientModule } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { SweetAlert2Module } from '@sweetalert2/ngx-sweetalert2';
import { Rubrica } from '../Modelos/rubrica';

@Component({
  selector: 'app-crear-rubrica',
  standalone: true,
  imports: [FormsModule, SweetAlert2Module, HttpClientModule],
  templateUrl: './crear-rubrica.component.html',
  styleUrl: './crear-rubrica.component.css'
})
export class CrearRubricaComponent {

  public rubrica: Rubrica = new Rubrica();
  public title: String = "Crear rúbrica";
  
  

}
