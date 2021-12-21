import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductElement, ProductService } from './service/product.service';


@Component({
  selector: 'app-book',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
 
  products:ProductElement[];
  constructor(private productService:ProductService) {
    this.products=[];
  }

  ngOnInit(): void {
  this.productService.getProducts().subscribe(data=>{
    this.products=data;
  },err=>console.log(err));
  }


  // onBookAdded(eventData: { code:string,title: string ,description:string,author:string,price:number}) {
  //   this.bookService.newBook(eventData)
  // }
}
