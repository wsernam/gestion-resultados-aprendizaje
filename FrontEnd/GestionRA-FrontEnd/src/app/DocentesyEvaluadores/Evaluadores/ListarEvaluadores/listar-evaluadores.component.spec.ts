import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarEvaluadoresComponent } from './listar-evaluadores.component';

describe('ListarEvaluadoresComponent', () => {
  let component: ListarEvaluadoresComponent;
  let fixture: ComponentFixture<ListarEvaluadoresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarEvaluadoresComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarEvaluadoresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
