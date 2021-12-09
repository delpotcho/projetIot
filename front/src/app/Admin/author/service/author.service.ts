import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

export interface Author {
  id: number;
  username: string;
  firstName: string;
  lastName: string;
  birthDay: Date;
  email: string;
}

@Injectable({
  providedIn: 'root',
})
export class AuthorService {
  private url: string = 'http://localhost:8080';
  constructor(private http: HttpClient) {}
  getAuthors():Observable<Author[]>{
    return this.http.get<Author[]>(this.url+"/author/");
  }

  getAuthorByUsername(username:string):Observable<Author>{
    return this.http.get<Author>(this.url+"/author/"+username);
  }
  
  newAuthor(author:Author):Observable<string>{
    return this.http.post<string>(this.url+"/author/new",author);
  }
  editAuthor(author:Author):Observable<string>{
    return this.http.put<string>(this.url+"/author/edit/"+author.id,author);
  }
}
