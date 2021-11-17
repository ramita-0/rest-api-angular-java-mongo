import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarroComponent } from './carro/carro.component';
import { HomeComponent } from './home/home.component';
import { IngresoStockComponent } from './ingreso-stock/ingreso-stock.component';
import { VentaComponent } from './venta/venta.component';

const routes: Routes = [
  {
    path: "",
    component:HomeComponent
  },
  {
    path:"ingreso_stock",
    component:IngresoStockComponent
  },
  {
    path: "venta",
    component:VentaComponent
  },
  {
    path: "carro",
    component:CarroComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
