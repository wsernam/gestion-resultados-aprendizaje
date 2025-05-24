import { Nivel } from "./nivel";

export class Criterio {

    descripcion!: String;

    listaNiveles!: Nivel[]

    public constructor()
    {
        this.listaNiveles = [];
    }

}
