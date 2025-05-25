import { TestBed } from '@angular/core/testing';

import { CompetenciaAsignaturaService } from './competencia-asignatura.service';

describe('CompetenciaAsignaturaService', () => {
  let service: CompetenciaAsignaturaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CompetenciaAsignaturaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
