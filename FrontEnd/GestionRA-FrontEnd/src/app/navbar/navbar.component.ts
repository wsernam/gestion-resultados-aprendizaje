import { Component } from '@angular/core';
import { RouterModule, Router, NavigationEnd } from '@angular/router';
import { CommonModule } from '@angular/common';
import { filter } from 'rxjs';
import { LoginService } from '../Login/Servicio/login.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterModule, CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  public isCoordinador: boolean = false;

  constructor(private loginService: LoginService, private router: Router) {}

  ngOnInit() {
    this.verificarRol();
    this.router.events.pipe(
      filter(event => event instanceof NavigationEnd)
    ).subscribe(() => this.verificarRol());
  }

  private verificarRol() {
    if (typeof window !== 'undefined') {
      const token = sessionStorage.getItem('token');
      if (token) {
        const payload = this.parseToken(token);
        this.isCoordinador = payload && Array.isArray(payload.roles) && payload.roles.includes('COORDINADOR');
        console.log('isCoordinador:', this.isCoordinador);
      } else {
        this.isCoordinador = false;
        console.log('isCoordinador:', this.isCoordinador);
      }
    }
  }
  private parseToken(token: string): any {
    try {
      return JSON.parse(atob(token.split('.')[1]));
    }
    catch (error) {
      console.error('Error parsing token:', error);
      return null;
    }
  }

  public logOut(): void{
    this.loginService.logout();
    this.router.navigate(['/Login']);
  }

}
