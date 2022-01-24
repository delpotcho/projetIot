import { Component, Input, OnInit } from '@angular/core';
import { Environment } from '../../Environment/Service/environment.service';
import { ProductElement } from '../service/product.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css'],
})
export class ListBookComponent implements OnInit {
  headers: String[] = [
    'name',
    'maxTemperature',
    'minTemperature',
    'maxHumidity',
    'minHumidity',
  ];
  products: ProductElement[];
  order: number = 1;
  @Input() environment:Environment=null;
  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    setTimeout(() => {
      if(this.environment==null){
        this.productService.getProducts().subscribe(data=>{
          this.products=data
        })
      }else{
        this.products=this.environment?.products;
      }
    }, 1000);
    
   
    
   
  }
  deleteProduct(code: string) {
    this.productService.delteProduct(code);
  }

  changeOrder() {
    this.order *= -1;
    console.log(this.order);
  }
}
