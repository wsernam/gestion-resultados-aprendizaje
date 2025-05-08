import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarDocentesComponent } from './listar-docentes.component';

describe('ListarDocentesComponent', () => {
  let component: ListarDocentesComponent;
  let fixture: ComponentFixture<ListarDocentesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarDocentesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarDocentesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
