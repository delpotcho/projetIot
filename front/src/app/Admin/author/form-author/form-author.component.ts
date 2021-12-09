import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-form-author',
  templateUrl: './form-author.component.html',
  styleUrls: ['./form-author.component.css']
})
export class FormAuthorComponent implements OnInit {

  authorForm:FormGroup;
  constructor() { }

  ngOnInit(): void {
  }

}
