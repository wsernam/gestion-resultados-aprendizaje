import { Docente } from "../../DocentesyEvaluadores/Modelos/docente";
import { AsignaturaCurso } from "./asignatura-curso";
import { Curso } from "./curso";
import { Periodo } from "./periodo";

export class ConsultarCurso {

    id!: string;
    asignatura!: AsignaturaCurso;
    docente!: Docente;
    periodo!: Periodo;


}
