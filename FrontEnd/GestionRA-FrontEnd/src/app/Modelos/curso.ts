import { Docente } from "./docente";
import { Asignatura } from "./asignatura";
import { Periodo } from "./periodo";

export class Curso {

    id! : number;
    objAsignatura! : Asignatura;
    objDocente! : Docente;
    objPeriodo! : Periodo;

    constructor () {
        this.objAsignatura = new Asignatura();
        this.objDocente = new Docente();
        this.objPeriodo = new Periodo();
    }

}
