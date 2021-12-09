import { Component, OnInit } from '@angular/core';
import { Author, AuthorService } from '../service/author.service';

@Component({
  selector: 'app-list-author',
  templateUrl: './list-author.component.html',
  styleUrls: ['./list-author.component.css']
})
export class ListAuthorComponent implements OnInit {
  authors:Author[];
  order: number;
  constructor(private authorService:AuthorService) { }

  ngOnInit(): void {
    this.authorService.getAuthors().subscribe(data=>this.authors=data);
  }
  changeOrder(){
    this.order*=-1;
    console.log(this.order);
  }


}
