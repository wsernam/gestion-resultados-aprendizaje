import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompenteciasPComponent } from './compentecias-p.component';

describe('CompenteciasPComponent', () => {
  let component: CompenteciasPComponent;
  let fixture: ComponentFixture<CompenteciasPComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompenteciasPComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CompenteciasPComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
