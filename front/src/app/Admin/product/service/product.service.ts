import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface ProductElement {
  id:number;
  code: string;
  title: string;
  description: string;
  price: number;
  numberOfPage:string;
  verified:boolean;
  createdAt:Date;
  updatedAt:Date;
  authorUsername: string;
  authorId:number;
}
const server="http://localhost:8080";
@Injectable({
  providedIn: 'root'
})
export class BookService {
  constructor(private http:HttpClient) { }
  books: ProductElement[] = JSON.parse(localStorage.getItem('books'));

  getBooks():Observable<ProductElement[]>{
    
    return this.http.get<ProductElement[]>(server+"/products/");
  }
  getBookById(id:String):Observable<ProductElement>{
    return this.http.get<ProductElement>(server+"/book/"+id);
  }
  newBook(data:ProductElement):Observable<ProductElement>{
     return this.http.post<ProductElement>(server+"/book/new",data);
  }
  getBookByCode(code:string):ProductElement{
    let book=this.books.find(b=>{return b.code==code});
    return book;
  }
  editBook(newBook:ProductElement):void{
    let book=this.books.find(b=>{return b.code==newBook.code});
    book.authorUsername=newBook.authorUsername;
    book.description=newBook.description;
    book.title=newBook.title;
    book.price=newBook.price;
    this.saveBooksInLocalStorage();
  }
  delteBook(code:string){
    this.books.forEach((b,index)=> {
      if(b.code==code)
        this.books.splice(index,1);
    });
    this.saveBooksInLocalStorage();

  }

  saveBooksInLocalStorage(){
    localStorage.setItem('books',JSON.stringify(this.books));
  }
}
