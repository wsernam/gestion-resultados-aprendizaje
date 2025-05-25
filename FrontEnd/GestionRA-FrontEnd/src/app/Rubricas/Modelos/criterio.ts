import { Nivel } from "./nivel";

export class Criterio {

    descripcion!: String;
    listaNiveles!: Nivel[]

    constructor() {
        this.descripcion = '';
        this.listaNiveles = [];
    }

}
