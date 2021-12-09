import { Component, OnInit } from '@angular/core';
import { BookElement, BookService } from '../service/book.service';

@Component({
  selector: 'admin-list-book',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListBookComponent implements OnInit {
  headers: String[] = ['code', 'title','authorUsername','description','price'];
  books:BookElement[];
  order:number=1;
  constructor(private bookService:BookService) { }

  ngOnInit(): void {
    this.bookService.getBooks().subscribe(data=>{
      console.log(data);
       this.books=data;
    },error=>{
      console.log(error);
    });
  }
  deleteBook(code:string){
    this.bookService.delteBook(code);
  }

  changeOrder(){
    this.order*=-1;
    console.log(this.order);
  }


}
