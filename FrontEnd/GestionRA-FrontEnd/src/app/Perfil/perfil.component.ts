import { Component } from '@angular/core';
import { PerfilService } from './Service/perfil.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-perfil',
  standalone: true,
  imports: [ CommonModule],
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css'
})
export class PerfilComponent {

  perfil: any;

  constructor(private perfilService: PerfilService) { }

  ngOnInit() {
    this.perfilService.getPerfil().subscribe(data => {
      console.log('Perfil recibido:', data);
      this.perfil = data;
    });
  }

}
