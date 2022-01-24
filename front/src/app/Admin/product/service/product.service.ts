import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Environment } from '../../Environment/Service/environment.service';

export interface ProductElement {
  id: number;
  name: String;
  maxTemperature: number;
  minTemperature: number;
  maxHumidity: number;
  minHumidity: number;
  environment:Environment
}
const server = 'http://localhost:8080';
@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) {}

  getProducts(): Observable<ProductElement[]> {
    return this.http.get<ProductElement[]>(server + '/product/', {
      withCredentials: true,
    });
  }
  getProductById(id: String): Observable<ProductElement> {
    return this.http.get<ProductElement>(server + '/product/' + id);
  }
  newProduct(data: ProductElement): Observable<ProductElement> {
    return this.http.post<ProductElement>(server + '/product/new', data);
  }
  getProductByCode(code: string): ProductElement {
    return null;
  }
  editProduct(newBook: ProductElement): void {}
  delteProduct(code: string) {}
}
