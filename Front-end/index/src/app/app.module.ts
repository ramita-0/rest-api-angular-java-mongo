import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { VentaComponent } from './venta/venta.component';
import { HomeComponent } from './home/home.component';
import { IngresoStockComponent } from './ingreso-stock/ingreso-stock.component';
import { CuadroBebidaCervezaRubiaComponent } from './venta/cuadro-bebida-cerveza-rubia/cuadro-bebida-cerveza-rubia.component';
import { CuadroBebidaCervezaNegraComponent } from './venta/cuadro-bebida-cerveza-negra/cuadro-bebida-cerveza-negra.component';
import { CuadroBebidaCervezaRojaComponent } from './venta/cuadro-bebida-cerveza-roja/cuadro-bebida-cerveza-roja.component';


@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    VentaComponent,
    HomeComponent,
    IngresoStockComponent,
    CuadroBebidaCervezaRubiaComponent,
    CuadroBebidaCervezaNegraComponent,
    CuadroBebidaCervezaRojaComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
