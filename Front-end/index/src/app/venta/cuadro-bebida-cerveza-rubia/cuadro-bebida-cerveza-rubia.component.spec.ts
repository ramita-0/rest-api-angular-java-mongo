import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuadroBebidaCervezaRubiaComponent } from './cuadro-bebida-cerveza-rubia.component';

describe('CuadroBebidaCervezaRubiaComponent', () => {
  let component: CuadroBebidaCervezaRubiaComponent;
  let fixture: ComponentFixture<CuadroBebidaCervezaRubiaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CuadroBebidaCervezaRubiaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CuadroBebidaCervezaRubiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
