import { Nivel } from "./nivel";

export class Criterio {

    descripcion!: String;
    niveles!: Nivel[]

    constructor() {
        this.descripcion = '';
        this.niveles = [];
    }

}
