import { Injectable } from '@angular/core';
import { Hero } from './hero';
import { HEROES } from './mock-heros';
import { MessageService } from './message.service';

import { Observable, of } from "rxjs";

import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class HeroService {

  constructor(
  private http: HttpClient,
  private messageService: MessageService) { }
  
  private log(message: string) {
    this.messageService.add('HeroService: ' + message);
  }
  
  private heroesUrl = 'api/heroes';  // URL to web api
  
  
getHeroes(): Observable<Hero[]> {
  // Todo: send the message _after_ fetching the heroes
  this.messageService.add('HeroService: fetched heroes');
  //return of(HEROES);
  return this.http.get<Hero[]>(this.heroesUrl)
}

getHero(id: number): Observable<Hero> {
	const url = `${this.heroesUrl}/${id}`;
  // Todo: send the message _after_ fetching the hero
  this.messageService.add(`HeroService: fetched hero id=${id}`);
  return of(HEROES.find(hero => hero.id === id));
}
}
