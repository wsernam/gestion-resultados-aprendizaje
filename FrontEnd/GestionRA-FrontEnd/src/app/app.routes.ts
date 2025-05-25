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

export const routes: Routes = [
    //{path: '', redirectTo: '/docentes/listarDocentes', pathMatch: 'full'},
    {path: 'docentes/listarDocentes', component: ListarDocentesComponent},
    {path: 'docentes/registrarDocentes', component: FormComponent},
    //{path: '', redirectTo: '/CompetenciasAprendizaje/listarCompetenciasAprendizajeP', pathMatch: 'full'},
    {path: 'competenciasAprendizaje/listarCompetenciasAprendizajeP', component: CompetenciasAprendizajePComponent},
    {path: 'competenciasAprendizaje/crearCompetenciasAprendizajeP', component: FormCAPComponent},
    {path: 'compentenciasAprendizaje/listarCompetenciasAprendizajeA', component: ListarCompentenciaAComponent},
    {path: 'compentenciasAprendizaje/crearCompetenciasAprendizajeA', component: CrearCompetenciasAComponent},
    {path: 'cursos/listarCursos', component: ListarCursoComponent},
    {path: 'cursos/crearCursos', component: CrearCursosComponent},
    {path: 'Login', component: LoginComponent},
    {path: 'rubricas/crearRubricas', component: CrearRubricaComponent},
];
