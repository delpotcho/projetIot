import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface BookElement {
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
  books: BookElement[] = JSON.parse(localStorage.getItem('books'));

  getBooks():Observable<BookElement[]>{
    
    return this.http.get<BookElement[]>(server+"/book/");
  }
  getBookById(id:String):Observable<BookElement>{
    return this.http.get<BookElement>(server+"/book/"+id);
  }
  newBook(data:BookElement):Observable<BookElement>{
     return this.http.post<BookElement>(server+"/book/new",data);
  }
  getBookByCode(code:string):BookElement{
    let book=this.books.find(b=>{return b.code==code});
    return book;
  }
  editBook(newBook:BookElement):void{
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
