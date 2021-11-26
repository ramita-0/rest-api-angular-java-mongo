import { Component, OnInit } from '@angular/core';
import { RestService } from '../rest.service';

@Component({
  selector: 'app-venta',
  templateUrl: './venta.component.html',
  styleUrls: ['./venta.component.sass']
})
export class VentaComponent implements OnInit {

  // array que almacena todas las bebidas
  bebidas: any = []
      
  // array por cada tipo de bebida
  cervezasArtesanales: {alcohol: any, artesanal: any, cantidad: any, color: any, descripcion: any, graduacion: any, ibu: any, marca: any, nombre: any, precio: any, tipo: any}[] = []
  cervezasComerciales: {alcohol: any, artesanal: any, cantidad: any, color: any, descripcion: any, graduacion: any, ibu: any, marca: any, nombre: any, precio: any, tipo: any}[] = []
  aperitivos: {alcohol: any, artesanal: any, cantidad: any, color: any, descripcion: any, graduacion: any, ibu: any, marca: any, nombre: any, precio: any, tipo: any}[] = []
  gaseosas: {alcohol: any, artesanal: any, cantidad: any, color: any, descripcion: any, graduacion: any, ibu: any, marca: any, nombre: any, precio: any, tipo: any}[] = []

  constructor(
    private RestService:RestService
  ) {}

  ngOnInit(): void {
    this.getBebidas();
  }

  public getBebidas(){
    this.RestService.getCollectionBebidas("http://localhost:8080/api/get/bebidas").subscribe(bebidas =>{
      console.log(bebidas);
    })  
  }
}