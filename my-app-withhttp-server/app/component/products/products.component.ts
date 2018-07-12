import { Component, OnInit } from '@angular/core';

import { Product } from '../../model/product'

import { ProductService } from '../../service/product.service'

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  constructor(private productService: ProductService) { }

  ngOnInit() {
	  this.getProducts();
  }

  products : Product[];
  
  getProducts(): void {
	  this.productService.getProducts()
	  .subscribe(products => this.products = products);
  }
  
}
