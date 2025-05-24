import { Criterio } from "../Rubricas/Modelos/criterio";

export class Rubrica {

   id!: String;
   id_curso!: String;
   descripcion!: String;
   ponderado!: number;
   id_raAsignatura!: String;
   
   listaCriterios!: Criterio[];

   public constructor()
   {
    this.listaCriterios = [];
   }

}
