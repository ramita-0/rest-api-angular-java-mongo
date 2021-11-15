import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CuadroBebidaCervezaNegraComponent } from './cuadro-bebida-cerveza-negra.component';

describe('CuadroBebidaCervezaNegraComponent', () => {
  let component: CuadroBebidaCervezaNegraComponent;
  let fixture: ComponentFixture<CuadroBebidaCervezaNegraComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CuadroBebidaCervezaNegraComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CuadroBebidaCervezaNegraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
