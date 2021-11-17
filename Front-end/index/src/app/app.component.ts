import { Component, OnInit } from '@angular/core';
import { RestService } from './rest.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {
  title = 'index';

  constructor(private RestService:RestService){
  }

  ngOnInit(): void{
    this.cargarData();
  }

  //cuando carga la pagina home, mapea /api/venta en el localhost
  public cargarData(){
    this.RestService.get("http://localhost:8080/api/get_bebidas")
    .subscribe(respuesta => {
      //logea la respuesta de la api en la consola
      console.log(respuesta)
    })
  }
}

