import { Docente } from "../../DocentesyEvaluadores/Modelos/docente";
import { Asignatura } from "./asignatura";
import { Periodo } from "./periodo";

export class Curso {

    /*
    idAsignatura!: string;
    correoDocente!: string;
    periodo!: Periodo;


    constructor () {
        this.idAsignatura = "";
        this.correoDocente = "";
        this.periodo = new Periodo();
    }
        */

    asignatura!: Asignatura;
    docente!: Docente;
    periodo!: Periodo;

}
