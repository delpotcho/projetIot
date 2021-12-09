import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BookElement, BookService } from '../service/book.service';
@Component({
  selector: 'app-form-book',
  templateUrl: './form-product.component.html',
  styleUrls: ['./form-product.component.css'],
})
export class FormBookComponent implements OnInit {
  idBook: String;
  bookForm: FormGroup;
  book:BookElement;
  bookData = {
    id: new FormControl(''),
    code: new FormControl(''),
    title: new FormControl('', [Validators.minLength(4), Validators.required]),
    userId: new FormControl('', [ Validators.required]),
    description: new FormControl('', [Validators.required]),
    price: new FormControl(0, [Validators.min(1), Validators.required]),
  };
  constructor(
    private formBuilder: FormBuilder,
    private bookService: BookService,
    private router: Router,
    private activeRoute: ActivatedRoute
  ) {}
  ngOnInit(): void {
    console.log('load child ');
    this.activeRoute.paramMap.subscribe((params) => {
      this.idBook = params.get('id');
      
      if (this.idBook != null) {
        this.bookService.getBookById(this.idBook).subscribe((data) => {
          console.log(data);
          return (this.book = data);
        },error=>{
          return console.log(error);
        },()=>{
        console.log(this.book);
          this.bookData = {
            id: new FormControl(this.book.id),
            code: new FormControl(this.book.code),
            title: new FormControl(this.book.title, [
              Validators.minLength(4),
              Validators.required,
            ]),
            userId: new FormControl(this.book.authorId, [
              Validators.required,
            ]),
            description: new FormControl(this.book.description, [Validators.required]),
            price: new FormControl(this.book.price, [
              Validators.min(1),
              Validators.required,
            ]),
          };
         this.bookForm = new FormGroup(this.bookData);
         return;
        });
        
      }
      this.bookForm = new FormGroup(this.bookData);
    });
  }
  // @Input() books; //get books table from parent component
  // @Output() bookCreated = new EventEmitter<{code:string,title: string ,description:string,author:string,price:number}>(); //send new data to parent component
  onSubmit(): void {
    
    if(this.bookForm.valid){
      if(this.idBook==null ){
        let numberItemInArray=this.bookService.getBooks().subscribe(data=>data.length);
        //let partOfNameAuthor=this.bookForm.value.author.slice(0,3);
        this.bookForm.value.code="author-"+(+numberItemInArray+1);
        this.bookService.newBook(this.bookForm.value).subscribe(data=>console.log(data));
       }
       else{
         this.bookService.editBook(this.bookForm.value);
       }
       this.bookForm.reset();
       this.returnToListBooks();
    }
    //this.bookCreated.emit(this.bookForm.value); // send data to function  located in  component parent , in  this example function is onBookAdded()
  }

  returnToListBooks() {
    this.router.navigate(['/admin/book']);
  }
}
