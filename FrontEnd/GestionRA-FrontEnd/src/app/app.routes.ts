import { Routes } from '@angular/router';
import { ListarDocentesComponent } from './DocentesyEvaluadores/listarDocente/listar-docentes/listar-docentes.component';
import { FormComponent } from './DocentesyEvaluadores/registrar-docente/form.component';
import { CompetenciasAprendizajePComponent } from './CAyRA/CompetenciasAprendizaje/listarCompetenciasAprendizajeP/competencias-aprendizaje-p.component';
import { FormCAPComponent } from './CAyRA/CompetenciasAprendizaje/crearCompetenciasAprendizajeP/form-cap.component';

export const routes: Routes = [
    //{path: '', redirectTo: '/docentes/listarDocentes', pathMatch: 'full'},
    {path: 'docentes/listarDocentes', component: ListarDocentesComponent},
    {path: 'docentes/registrarDocentes', component: FormComponent},
    //{path: '', redirectTo: '/CompetenciasAprendizaje/listarCompetenciasAprendizajeP', pathMatch: 'full'},
    {path: 'CompetenciasAprendizaje/listarCompetenciasAprendizajeP', component: CompetenciasAprendizajePComponent},
    {path: 'CompetenciasAprendizaje/crearCompetenciasAprendizajeP', component: FormCAPComponent},
];
