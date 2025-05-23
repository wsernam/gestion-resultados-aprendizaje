import { Component } from '@angular/core';
import { LoginService } from './Servicio/login.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Login } from '../Modelos/login';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  public login: Login = new Login();
  public titulo: string = 'Login';

  constructor(private loginService: LoginService, private router: Router) { }

  public ingresar() {
    this.loginService.login(this.login).subscribe(
      (response) => {
        console.log('Login successful:', response);
        // Aquí puedes redirigir al usuario a otra página después de un inicio de sesión exitoso
        this.router.navigate(['docentes/listarDocentes']);
      },
      (error) => {
        console.error('Login failed:', error);
        // Aquí puedes manejar el error de inicio de sesión
      }
    );
  }
}
