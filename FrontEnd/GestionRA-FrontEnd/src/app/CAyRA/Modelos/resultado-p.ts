import { CompetenciasAprendizajeP } from "./competencias-aprendizaje-p";

export class ResultadoP {
    programa!: String;
    descripcion!: String;
    objCompetencia!: CompetenciasAprendizajeP;

    constructor()
    {
        this.objCompetencia = new CompetenciasAprendizajeP();
    }
}
