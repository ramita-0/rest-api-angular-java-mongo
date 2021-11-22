import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-ingreso-stock',
  templateUrl: './ingreso-stock.component.html',
  styleUrls: ['./ingreso-stock.component.sass']
})
export class IngresoStockComponent implements OnInit {
  tipo: any = "nada"
  constructor(
    private RestService:RestService
  ) { }

  public updateStock(bebida:any){
    this.RestService.patchBebida(bebida);
  }

  public insertBebida(bebida:any){
    console.log(bebida);
    this.RestService.postBebida(bebida);
  }

  ngOnInit(): void {
  }
}