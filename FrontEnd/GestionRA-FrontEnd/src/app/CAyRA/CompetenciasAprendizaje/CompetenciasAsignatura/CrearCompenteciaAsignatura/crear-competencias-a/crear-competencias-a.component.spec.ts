import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearCompetenciasAComponent } from './crear-competencias-a.component';

describe('CrearCompetenciasAComponent', () => {
  let component: CrearCompetenciasAComponent;
  let fixture: ComponentFixture<CrearCompetenciasAComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CrearCompetenciasAComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CrearCompetenciasAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
