import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearRubricaComponent } from './crear-rubrica.component';

describe('CrearRubricaComponent', () => {
  let component: CrearRubricaComponent;
  let fixture: ComponentFixture<CrearRubricaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CrearRubricaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CrearRubricaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
