import { TestBed } from '@angular/core/testing';

import { RubricaServiceService } from './rubrica-service.service';

describe('RubricaServiceService', () => {
  let service: RubricaServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RubricaServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
