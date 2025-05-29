import { Routes } from '@angular/router';
import { ListarDocentesComponent } from './DocentesyEvaluadores/listarDocente/listar-docentes/listar-docentes.component';
import { FormComponent } from './DocentesyEvaluadores/registrar-docente/form.component';
import { CompetenciasAprendizajePComponent } from './CAyRA/CompetenciasAprendizaje/listarCompetenciasAprendizajeP/competencias-aprendizaje-p.component';
import { FormCAPComponent } from './CAyRA/CompetenciasAprendizaje/crearCompetenciasAprendizajeP/form-cap.component';
import { CrearCursosComponent } from './AsignaturasyCursos/Cursos/crear-cursos/crear-cursos.component';
import { LoginComponent } from './Login/login.component';
import { CrearRubricaComponent } from './Rubricas/CrearRubrica/crear-rubrica.component';
import { ListarCursoComponent } from './AsignaturasyCursos/Cursos/ListarCursos/listar-curso.component';
import { CompetenciaAprendizajeA } from './CAyRA/Modelos/competencia-aprendizaje-a';
import { ListarCompentenciaAComponent } from './CAyRA/CompetenciasAprendizaje/CompetenciasAsignatura/ListarCompetenciaAsignatura/listar-compentencia-a.component';
import { CrearCompetenciasAComponent } from './CAyRA/CompetenciasAprendizaje/CompetenciasAsignatura/CrearCompenteciaAsignatura/crear-competencias-a/crear-competencias-a.component';
import { authGuard } from './Guardia/auth.guard';
import { RegistrarEvaluadorComponent } from './DocentesyEvaluadores/Evaluadores/RegistrarEvaluadores/registrar-evaluador.component';
import { ListarEvaluadoresComponent } from './DocentesyEvaluadores/Evaluadores/ListarEvaluadores/listar-evaluadores.component';
import { RegistrarComponent } from './Registrar/registrar.component';
import { CompetenciasRaComponent } from './components/competencias-ra.component';

export const routes: Routes = [
    {path: '', redirectTo: 'Login', pathMatch: 'full'},
    { path: 'registro', component: RegistrarComponent },
    {path: 'docentes/listarDocentes', component: ListarDocentesComponent, canActivate: [authGuard]},
    {path: 'docentes/registrarDocentes', component: FormComponent},
    {path: 'evaluador/registrarEvaluador', component: RegistrarEvaluadorComponent},
    {path: 'evaluador/listarEvaluador', component: ListarEvaluadoresComponent},
    {path: 'competenciasAprendizaje/listarCompetenciasAprendizajeP', component: CompetenciasAprendizajePComponent, canActivate: [authGuard]},
    {path: 'competenciasAprendizaje/crearCompetenciasAprendizajeP', component: FormCAPComponent, canActivate: [authGuard]},
    {path: 'compentenciasAprendizaje/listarCompetenciasAprendizajeA', component: ListarCompentenciaAComponent, canActivate: [authGuard]},
    {path: 'compentenciasAprendizaje/crearCompetenciasAprendizajeA', component: CrearCompetenciasAComponent, canActivate: [authGuard]},
    {path: 'cursos/listarCursos', component: ListarCursoComponent, canActivate: [authGuard]},
    {path: 'cursos/crearCursos', component: CrearCursosComponent, canActivate: [authGuard]},
    {path: 'Login', component: LoginComponent},
    {path: 'rubricas/crearRubricas', component: CrearRubricaComponent, canActivate: [authGuard]},
    {path: 'competencias-ra', component: CompetenciasRaComponent, canActivate: [authGuard]}
];
