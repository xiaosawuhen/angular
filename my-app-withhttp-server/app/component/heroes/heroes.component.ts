import { Component, OnInit } from '@angular/core';

import { Hero } from '../../model/hero';

import { HeroService } from '../../service/hero.service';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {

  constructor(private heroService: HeroService) { }

  ngOnInit() {
	  this.getHeroes();
  }

  hero: Hero = {
	id: 1,
	name: 'Windstorm'
  };

  //heroes = HEROES;
  heroes: Hero[];
  
getHeroes(): void {
  this.heroService.getHeroes()
      .subscribe(heroes => this.heroes = heroes);
}
  
}
