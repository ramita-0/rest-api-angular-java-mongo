import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(
    private http: HttpClient,
    ) { }

  getCollectionBebidas(url: string){
    return this.http.get(url)
  }

  // subscribe es obligatorio, sino no llega el objeto a la api


  patchBebida(bebida:any){
    this.http.patch("http://localhost:8080/api/patch/updateStockBebida", bebida).subscribe(res =>{
    })
  }

  postBebida(bebida:any){
    this.http.post("http://localhost:8080/api/post/insertBebida", bebida).subscribe(res =>{
    })
  }

  deleteBebida(bebida:any){
    let nombre = bebida["nombre"];
    let ruta = "http://localhost:8080/api/delete/deleteBebida/";
    let rutaParametro = ruta.concat(nombre);
    this.http.delete(rutaParametro).subscribe(res =>{
    })
  }
}