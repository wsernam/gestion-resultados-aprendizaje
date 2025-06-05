import { Component } from '@angular/core';
import { RouterModule, Router, NavigationEnd } from '@angular/router';
import { CommonModule } from '@angular/common';
import { filter } from 'rxjs';
import { LoginService } from '../Login/Servicio/login.service';
import { StorageServiceService } from '../Servicios/storage-service.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  public isCoordinador: boolean = false;
  public isDocente: boolean = false;
  public isEvaluador: boolean = false;

  constructor(private loginService: LoginService, private router: Router, private storageService: StorageServiceService) {}

  ngOnInit() {
    this.verificarRoles();
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => this.verificarRoles());
  }

  private verificarRoles() {
    const roles = this.storageService.getRoles() || [];
    this.isCoordinador = roles.includes('COORDINADOR');
    this.isDocente = roles.includes('DOCENTE');
    this.isEvaluador = roles.includes('EVALUADOR');
  }

  public logOut(): void{
    this.storageService.clean();
    this.router.navigate(['/Login']);
  }

}
