import { Component, Input, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.sass']
})

export class NavBarComponent implements OnInit {

  pagina: any = {
    nombre: ""
  }

  constructor(
    private route: ActivatedRoute,
  ) {}

  ngOnInit(): void {
    this.pagina = this.route.snapshot.data
  }
}