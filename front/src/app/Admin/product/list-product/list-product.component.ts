import { Component, OnInit } from '@angular/core';
import { ProductElement } from '../service/product.service';
import { ProductService } from '../service/product.service';

@Component({
  selector: 'list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css'],
})
export class ListBookComponent implements OnInit {
  headers: String[] = [
    'name',
    'Max Temperature',
    'Min Temperature',
    'Max Humidity',
    'Min Humidity',
  ];
  products: ProductElement[];
  order: number = 1;
  constructor(private productService: ProductService) {}

  ngOnInit(): void {
    this.productService.getProducts().subscribe(
      (data) => {
        console.log(data);
        this.products = data;
      },
      (error) => {
        console.log(error);
      }
    );
  }
  deleteProduct(code: string) {
    this.productService.delteProduct(code);
  }

  changeOrder() {
    this.order *= -1;
    console.log(this.order);
  }
}
