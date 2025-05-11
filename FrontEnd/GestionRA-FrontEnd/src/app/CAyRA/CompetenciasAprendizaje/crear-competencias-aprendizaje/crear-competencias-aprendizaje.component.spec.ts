import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearCompetenciasAprendizajeComponent } from './crear-competencias-aprendizaje.component';

describe('CrearCompetenciasAprendizajeComponent', () => {
  let component: CrearCompetenciasAprendizajeComponent;
  let fixture: ComponentFixture<CrearCompetenciasAprendizajeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CrearCompetenciasAprendizajeComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CrearCompetenciasAprendizajeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
