import { Component } from '@angular/core';
import { LoginService } from './Servicio/login.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Login } from './Modelo/login';
import { DocenteService } from '../DocentesyEvaluadores/servicios/docente.service';
import { error } from 'console';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule, RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  public login: Login = new Login();
  public titulo: string = 'Login';

  constructor(private loginService: LoginService, private docenteService: DocenteService, private router: Router) {
    this.login.tipo = ''; // Establecer el tipo de usuario por defecto
  }

  public ingresar() {

    this.loginService.login(this.login).subscribe(
      (response) => {
        console.log('Login successful:', response);
        sessionStorage.setItem('token', response.toString());
        sessionStorage.setItem('correo', this.login.nombreUsuario);
        sessionStorage.setItem('tipo', this.login.tipo);
        
        this.docenteService.getDocenteByEmail(this.login.nombreUsuario).subscribe(
          docente => {
            sessionStorage.setItem('cedula', docente.cedula.toString());
          },
          error => {
            console.error('Error fetching docente by email:', error);
          }
        )
        this.router.navigate(['cursos/listarCursos']);
      },
      (error) => {
        console.error('Login failed:', error);
      }
    );
  }

  public logout(): void {
    this.loginService.logout();
    this.router.navigate(['/Login']);
  }
}
