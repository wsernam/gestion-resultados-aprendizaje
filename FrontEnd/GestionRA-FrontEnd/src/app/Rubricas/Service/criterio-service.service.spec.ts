import { TestBed } from '@angular/core/testing';

import { CriterioServiceService } from './criterio-service.service';

describe('CriterioServiceService', () => {
  let service: CriterioServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CriterioServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
