import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarCompentenciaAComponent } from './listar-compentencia-a.component';

describe('ListarCompentenciaAComponent', () => {
  let component: ListarCompentenciaAComponent;
  let fixture: ComponentFixture<ListarCompentenciaAComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListarCompentenciaAComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListarCompentenciaAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
