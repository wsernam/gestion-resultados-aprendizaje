import { TestBed } from '@angular/core/testing';

import { NivelService } from './nivel-service.service';

describe('NivelServiceService', () => {
  let service: NivelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NivelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
