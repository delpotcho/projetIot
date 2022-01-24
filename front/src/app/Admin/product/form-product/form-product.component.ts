import { Component, OnInit, EventEmitter, Output, Input } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Environment, EnvironmentService } from '../../Environment/Service/environment.service';
import { ProductElement, ProductService } from '../service/product.service';
@Component({
  selector: 'app-form-book',
  templateUrl: './form-product.component.html',
  styleUrls: ['./form-product.component.css'],
})
export class FormProductComponent implements OnInit {
  idProduct: String;
  productForm: FormGroup;
  product: ProductElement;
  environments:Environment[]=[];
  productData = {
    id: new FormControl(''),
    name: new FormControl(''),
    environmentId:new FormControl('',[Validators.required]),
    maxTemperature: new FormControl('', [ Validators.required]),
    minTemperature: new FormControl('', [Validators.required]),
    maxHumidity: new FormControl('', [Validators.required]),
    minHumidity: new FormControl(0, [Validators.min(1), Validators.required]),
  };
  constructor(
    private formBuilder: FormBuilder,
    private productService: ProductService,
    private environmentService:EnvironmentService,
    private router: Router,
    private activeRoute: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.environmentService.getEnvironments().subscribe(data=>{
      this.environments=data;
    })
    this.activeRoute.paramMap.subscribe((params) => {
      this.idProduct = params.get('id');

      if (this.idProduct != null) {
        this.productService.getProductById(this.idProduct).subscribe(
          (data) => {
            console.log(data);
            return (this.product = data);
          },
          (error) => {
            return console.log(error);
          },
          () => {
            this.productData = {
              id: new FormControl(this.product.id),
              name: new FormControl(this.product.name),
              environmentId:new FormControl(this.product.environment.id,[Validators.required]),
              maxTemperature: new FormControl(this.product.maxTemperature, [
              
                Validators.required,
              ]),
              minTemperature: new FormControl(this.product.minTemperature, [
                Validators.required,
              ]),
              maxHumidity: new FormControl(this.product.maxHumidity, [
                Validators.required,
              ]),
              minHumidity: new FormControl(this.product.minHumidity, [
                Validators.min(1),
                Validators.required,
              ]),
            };
            this.productForm = new FormGroup(this.productData);
            return;
          }
        );
      }
      this.productForm = new FormGroup(this.productData);
    });
  }
  // @Input() books; //get books table from parent component
  // @Output() bookCreated = new EventEmitter<{code:string,title: string ,description:string,author:string,price:number}>(); //send new data to parent component
  onSubmit(): void {
    console.log(this.productForm.value);
    
    if (this.productForm.valid) {
      if (this.idProduct == null) {
        let numberItemInArray = this.productService
          .getProducts()
          .subscribe((data) => data.length);
        //let partOfNameAuthor=this.bookForm.value.author.slice(0,3);
        this.productForm.value.code = 'author-' + (+numberItemInArray + 1);
        this.productService
          .newProduct(this.productForm.value)
          .subscribe((data) => console.log(data));
      } else {
        this.productService.editProduct(this.productForm.value);
      }
      this.productForm.reset();
      this.returnToListProducts();
    }
    //this.bookCreated.emit(this.bookForm.value); // send data to function  located in  component parent , in  this example function is onBookAdded()
  }

  returnToListProducts() {
    this.router.navigate(['/product']).then(()=>window.location.reload());
  }
}
