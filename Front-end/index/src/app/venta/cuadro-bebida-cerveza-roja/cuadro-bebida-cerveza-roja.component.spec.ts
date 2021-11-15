import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuadroBebidaCervezaRojaComponent } from './cuadro-bebida-cerveza-roja.component';

describe('CuadroBebidaCervezaRojaComponent', () => {
  let component: CuadroBebidaCervezaRojaComponent;
  let fixture: ComponentFixture<CuadroBebidaCervezaRojaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CuadroBebidaCervezaRojaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CuadroBebidaCervezaRojaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
