import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';

import { CarouselModule } from 'ngx-bootstrap/carousel';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './/app-routing.module';

import { HeroesComponent } from './component/heroes/heroes.component';
import { HeroDetailComponent } from './component/hero-detail/hero-detail.component';
import { MessagesComponent } from './component/messages/messages.component';
import { DashboardComponent } from './component/dashboard/dashboard.component';
import { LoginComponent } from './component/login/login.component';
import { ProjectsComponent } from './component/projects/projects.component';
import { ProjectDetailComponent } from './component/project-detail/project-detail.component';
import { NewsComponent } from './component/news/news.component';
import { NewsDetailComponent } from './component/news-detail/news-detail.component';
import { ProductsComponent } from './component/products/products.component';
import { ProductDetailComponent } from './component/product-detail/product-detail.component';
import { EmployeesComponent } from './component/employees/employees.component';
import { EmployeeDetailComponent } from './component/employee-detail/employee-detail.component';

import { HeroService } from './service/hero.service';
import { MessageService } from './service/message.service';
import { InMemoryDataService }  from './service/in-memory-data.service';
import { ProductService } from './service/product.service';


@NgModule({
  declarations: [
    AppComponent,
    HeroesComponent,
    HeroDetailComponent,
    MessagesComponent,
    DashboardComponent,
    LoginComponent,
    ProjectsComponent,
    ProjectDetailComponent,
    NewsComponent,
    NewsDetailComponent,
    ProductsComponent,
    ProductDetailComponent,
    EmployeesComponent,
    EmployeeDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
	HttpClientModule,
	CarouselModule.forRoot()
  ],
  providers: [
	HeroService,
	MessageService,
	ProductService,
	InMemoryDataService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
