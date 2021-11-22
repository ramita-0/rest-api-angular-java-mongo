import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(
    private http: HttpClient,
    ) { }

  get(url: string){
    return this.http.get(url);
  }

  patchBebida(bebida:any){
    // subscribe es obligatorio, sino no llega el objeto a la api
    this.http.patch("http://localhost:8080/api/patch/updateStockBebida", bebida).subscribe(res =>{
    })
  }

  postBebida(bebida:any){
    this.http.post("http://localhost:8080/api/post/insertBebida", bebida).subscribe(res =>{
    })
  }
}