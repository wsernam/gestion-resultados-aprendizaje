import { Routes } from '@angular/router';
import { ListarDocentesComponent } from './DocentesyEvaluadores/Docentes/listar-docentes/listar-docentes.component';
import { FormComponent } from './DocentesyEvaluadores/Docentes/registrar-docente/form.component';
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
import { PerfilComponent } from './Perfil/perfil.component';
import { CrearRAAComponent } from './CAyRA/ResultadosAprendizaje/Asignatura/crearRAA/crear-raa.component';
import { FormComponent as CrearRAPFormComponent} from './CAyRA/ResultadosAprendizaje/Programa/crearRAP/crearRAPform.component';
import { ListarRAAComponent } from './CAyRA/ResultadosAprendizaje/Asignatura/listarRAA/listar-raa.component';
import { ResultadosPComponent } from './CAyRA/ResultadosAprendizaje/Programa/ListarRAP/resultados-p.component';
import { ListarRubricaComponent } from './Rubricas/ListarRubricas/listar-rubrica.component';

export const routes: Routes = [
    {path: '', redirectTo: 'Login', pathMatch: 'full'},
    { path: 'registro', component: RegistrarComponent },
    {path: 'perfil', component: PerfilComponent},
    {path: 'docentes/listarDocentes', component: ListarDocentesComponent, canActivate: [authGuard]},
    {path: 'docentes/registrarDocentes', component: FormComponent},
    {path: 'evaluador/registrarEvaluador', component: RegistrarEvaluadorComponent},
    {path: 'evaluador/listarEvaluador', component: ListarEvaluadoresComponent},
    {path: 'competenciasAprendizaje/listarCompetenciasAprendizajeP', component: CompetenciasAprendizajePComponent, canActivate: [authGuard]},
    {path: 'competenciasAprendizaje/crearCompetenciasAprendizajeP', component: FormCAPComponent, canActivate: [authGuard], data: { roles: ['COORDINADOR'] }},
    {path: 'compentenciasAprendizaje/listarCompetenciasAprendizajeA', component: ListarCompentenciaAComponent, canActivate: [authGuard]},
    {path: 'compentenciasAprendizaje/crearCompetenciasAprendizajeA', component: CrearCompetenciasAComponent, canActivate: [authGuard], data: { roles: ['DOCENTE', 'COORDINADOR'] }},
    {path: 'resultadosAprendizaje/listarRAP', component: ResultadosPComponent, canActivate: [authGuard]},
    {path: 'resultadosAprendizaje/listarRAA', component: ListarRAAComponent, canActivate: [authGuard]},
    {path: 'resultadosAprendizaje/crearRAP', component: CrearRAPFormComponent, canActivate: [authGuard], data: { roles: ['COORDINADOR'] }},
    {path: 'resultadosAprendizaje/crearRAA', component: CrearRAAComponent, canActivate: [authGuard], data: { roles: ['DOCENTE', 'COORDINADOR'] }},
    {path: 'cursos/listarCursos', component: ListarCursoComponent, canActivate: [authGuard], },
    {path: 'cursos/crearCursos', component: CrearCursosComponent, canActivate: [authGuard], data: { roles: ['DOCENTE', 'COORDINADOR'] }},
    {path: 'Login', component: LoginComponent},
    {path: 'rubricas/crearRubricas/:idCurso', component: CrearRubricaComponent, canActivate: [authGuard]},
    {path: 'rubricas/:idCurso', component: ListarRubricaComponent, canActivate: [authGuard]},
    {path: 'competencias-ra', component: CompetenciasRaComponent, canActivate: [authGuard]}
];
