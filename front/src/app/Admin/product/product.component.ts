import { Component, Input, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductElement, ProductService } from './service/product.service';


@Component({
  selector: 'app-book',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class ProductComponent implements OnInit {
 
  constructor() {}

  ngOnInit(): void {
   
  }


  // onBookAdded(eventData: { code:string,title: string ,description:string,author:string,price:number}) {
  //   this.bookService.newBook(eventData)
  // }
}
