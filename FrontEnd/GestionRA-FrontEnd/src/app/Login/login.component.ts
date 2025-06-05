import { Component } from '@angular/core';
import { LoginService } from './Servicio/login.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Login } from './Modelo/login';
import { DocenteService } from '../DocentesyEvaluadores/servicios/docente.service';
import { EvaluadorService } from '../DocentesyEvaluadores/Evaluadores/Service/evaluador.service';

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

  constructor(private loginService: LoginService, private docenteService: DocenteService, private router: Router, private evaluador: EvaluadorService) {
    this.login.tipo = ''; // Establecer el tipo de usuario por defecto
  }

  public ingresar() {
    this.loginService.login(this.login).subscribe({
      next: (response) => {
        console.log('Login successful');
        sessionStorage.setItem('token', response.toString());
        sessionStorage.setItem('correo', this.login.nombreUsuario);
        sessionStorage.setItem('tipo', this.login.tipo);

        if (this.login.tipo === 'DOCENTE') {
          this.docenteService.getDocenteByEmail(this.login.nombreUsuario).subscribe(
            docente => {
              sessionStorage.setItem('cedula', docente.cedula.toString());
              this.router.navigate(['cursos/listarCursos']); // Ruta para docentes
            },
            error => {
              console.error('Error fetching docente by email:', error);
            }
          );
        } else if (this.login.tipo === 'EVALUADOR') {
          this.evaluador.getEvaluadorByEmail(this.login.nombreUsuario).subscribe(
            evaluador => {
              sessionStorage.setItem('correo', evaluador.correo.toString());
              this.router.navigate(['cursos/listarCursos']); // Ruta para evaluadores
            },
            error => {
              console.error('Error fetching evaluador by email:', error);
            }
          );
        } else {
          // Si el tipo no es reconocido, navega a una ruta por defecto
          this.router.navigate(['/']);
        }
      },
      error: (error) => {
        console.error('Login fallido: ', error.message);
      }
    });
  }

  public logout(): void {
    this.loginService.logout();
    this.router.navigate(['/Login']);
  }
}
