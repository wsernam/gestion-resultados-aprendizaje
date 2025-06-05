import { Component } from '@angular/core';
import { PerfilService } from './Service/perfil.service';
import { CommonModule } from '@angular/common';
import { StorageServiceService } from '../Servicios/storage-service.service';

@Component({
  selector: 'app-perfil',
  standalone: true,
  imports: [ CommonModule],
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css'
})
export class PerfilComponent {

  perfil: any;
  roles: string[] = [];

  constructor(private perfilService: PerfilService, private storageService: StorageServiceService) { }

  ngOnInit() {
    this.roles = this.storageService.getRoles() || [];    
    console.log('Rol:', this.storageService.getRoles());
    this.perfilService.getPerfil().subscribe(data => {
      console.log('Perfil recibido:', data);
      this.perfil = data;
    });
  }

}
