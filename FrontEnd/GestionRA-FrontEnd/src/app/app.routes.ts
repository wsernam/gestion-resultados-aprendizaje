import { Routes } from '@angular/router';
import { ListarDocentesComponent } from './DocentesyEvaluadores/listarDocente/listar-docentes/listar-docentes.component';
import { FormComponent } from './DocentesyEvaluadores/registrar-docente/form.component';

export const routes: Routes = [
    {path: '', redirectTo: '/docentes/listarDocentes', pathMatch: 'full'},
    {path: 'docentes/listarDocentes', component: ListarDocentesComponent},
    {path: 'docentes/registrarDocentes', component: FormComponent}
];
