import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookElement, BookService } from './service/book.service';


@Component({
  selector: 'app-book',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
})
export class BookComponent implements OnInit {
 
 
  constructor() {}

  ngOnInit(): void {
   
  }


  // onBookAdded(eventData: { code:string,title: string ,description:string,author:string,price:number}) {
  //   this.bookService.newBook(eventData)
  // }
}
