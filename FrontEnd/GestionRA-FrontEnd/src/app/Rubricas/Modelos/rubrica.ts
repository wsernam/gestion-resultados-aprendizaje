import { Criterio } from "./criterio";

export class Rubrica {

   idCurso!: string;
   descripcion!: string;   
   ponderado!: number;
   idRaAsignatura!: string;
   criterios!: Criterio[];

   public constructor() {
      this.descripcion = '';
      this.ponderado = 0;
      this.idCurso = '';
      this.idRaAsignatura = '';
      this.criterios = [];
   }
}
