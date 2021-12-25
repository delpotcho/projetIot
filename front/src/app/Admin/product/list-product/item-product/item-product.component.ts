import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-item-book',
  templateUrl: './item-product.component.html',
  styleUrls: ['./item-product.component.css']
})
export class ItemProductComponent implements OnInit {

  idBook:String;
  constructor(private activedRoute:ActivatedRoute ) { }

  ngOnInit(): void {
    this.activedRoute.paramMap.subscribe(params=>{
      this.idBook=params.get('id');
    
    });
    if(this.idBook!=null){

    }
  }

}
