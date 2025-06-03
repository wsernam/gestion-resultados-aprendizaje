import { Periodo } from "./periodo";

export class CrearCurso {
    idAsignatura!: string;
    correoDocente!: string;
    periodo!: Periodo;

    constructor() {
        this.idAsignatura = "";
        this.correoDocente = "";
        this.periodo = new Periodo();
    }

}
