import { Criterio } from "./criterio";

export class ListarRubrica {

    id!: string;
   idCurso!: string;
   descripcion!: string;   
   ponderado!: number;
   idRaAsignatura!: string;
   criterios!: Criterio[];

   public constructor() {
    this.id = '';
      this.descripcion = '';
      this.ponderado = 0;
      this.idCurso = '';
      this.idRaAsignatura = '';
      this.criterios = [];
   }
}