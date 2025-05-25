import { Criterio } from "./criterio";

export class Rubrica {

   id!: String;
   id_curso!: String;
   descripcion!: String;
   ponderado!: number;
   id_raAsignatura!: String;
   listaCriterios!: Criterio[];

   public constructor() {
      this.descripcion = '';
      this.ponderado = 0;
      this.id = '';
      this.id_curso = '';
      this.id_raAsignatura = '';
      this.listaCriterios = [];
   }

}
