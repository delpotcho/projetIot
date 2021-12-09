import { Component, Input, OnInit } from '@angular/core';
import { Author } from '../service/author.service';

@Component({
  selector: 'card-author',
  templateUrl: './card-author.component.html',
  styleUrls: ['./card-author.component.css']
})
export class CardAuthorComponent implements OnInit {

  @Input() author:Author;
  constructor() { }

  ngOnInit(): void {
    console.log(this.author);
  }

}
