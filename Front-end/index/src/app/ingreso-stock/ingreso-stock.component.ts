import { Component, OnInit, ViewChild } from '@angular/core';
import { RestService } from '../rest.service';


@Component({
  selector: 'app-ingreso-stock',
  templateUrl: './ingreso-stock.component.html',
  styleUrls: ['./ingreso-stock.component.sass']
})
export class IngresoStockComponent implements OnInit {
  tipo: any = "";
  
  //input childs del forms de cerveza
  @ViewChild("nombreCerveza") nombreCerveza:any;
  @ViewChild("marcaCerveza") marcaCerveza:any;
  @ViewChild("artesanalCerveza") artesanalCerveza:any;
  @ViewChild("ibuCerveza") ibuCerveza:any;
  @ViewChild("colorCerveza") colorCerveza:any;
  @ViewChild("graduacionCerveza") graduacionCerveza:any;
  @ViewChild("precioCerveza") precioCerveza:any;
  @ViewChild("cantidadCerveza") cantidadCerveza:any;
  @ViewChild("descripcionCerveza") descripcionCerveza:any;

  constructor(
    private RestService:RestService
    ) { }

  public updateStock(bebida:any){
    this.RestService.patchBebida(bebida);
  }

  public insertCerveza(bebida:any){
    bebida["tipo"] = "Cerveza";
    bebida["alcohol"] = true;
    console.log(bebida);
    this.RestService.postBebida(bebida);

    //limpiamos los campos
    this.nombreCerveza.nativeElement.value = "";
    this.artesanalCerveza.nativeElement.value = "";
    this.descripcionCerveza.nativeElement.value = "";
    this.ibuCerveza.nativeElement.value = "";
    this.colorCerveza.nativeElement.value = "";
    this.graduacionCerveza.nativeElement.value = "";
    this.precioCerveza.nativeElement.value = "";
    this.cantidadCerveza.nativeElement.value = "";
  }

  public insertAperitivo(bebida:any){
    bebida["tipo"] = "Aperitivo";
    bebida["alcohol"] = true;

    this.RestService.postBebida(bebida);
  }

  public insertBebida(bebida:any){
    bebida["tipo"] = "Gaseosa";
    bebida["alcohol"] = false;
    this.RestService.postBebida(bebida);
  }

  ngOnInit(): void {
  }
}