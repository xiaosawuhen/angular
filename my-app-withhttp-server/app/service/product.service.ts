import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Product } from '../model/product'

import { MessageService } from '../service/message.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(
	  private http: HttpClient,
	  private messageService: MessageService) { }
	  
  private log(message: string) {
    this.messageService.add('HeroService: ' + message);
  }
  
  getProducts(): Observable<Product[]> {
    // Todo: send the message _after_ fetching the heroes
    this.messageService.add('HeroService: fetched heroes');
    //return of(HEROES);
    return this.http.get<Product[]>("http://10.247.237.66:8080/getProducts")
    
  }
  
  getProduct(id: number): Observable<Product> {
    // Todo: send the message _after_ fetching the hero
    this.messageService.add(`HeroService: fetched hero id=${id}`);
    // return of(HEROES.find(hero => hero.id === id));
    return this.http.get<Product>("http://10.247.237.66:8080/getProduct/" + id);
  }
}
