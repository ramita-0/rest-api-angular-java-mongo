import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CarroComponent } from './carro/carro.component';
import { HomeComponent } from './home/home.component';
import { IngresoStockComponent } from './ingreso-stock/ingreso-stock.component';
import { VentaComponent } from './venta/venta.component';

const routes: Routes = [
  {
    path: "",
    component:HomeComponent,
    data: {
      nombre: "Tres Reyes"
    }
  },
  {
    path:"ingreso_stock",
    component:IngresoStockComponent,
    data: {
      nombre: "Stock"
    }
  },
  {
    path: "venta",
    component:VentaComponent,
    data: {
      nombre: "Ventas"
    }
  },
  {
    path: "carro",
    component:CarroComponent,
    data: {
      nombre: "Carrito"
    }
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }