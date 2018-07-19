import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { HeroesComponent } from './heroes/heroes.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ChickensComponent } from './chickens/chickens.component';

import { ChickenService } from './chicken.service';
import { ChickenEditComponent } from './chicken-edit/chicken-edit.component';
import { ChickenCreateComponent } from './chicken-create/chicken-create.component';

import { ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';  


import { Globals } from './globals'
//import { TanComponent } from './tan/tan.component';


@NgModule({
  declarations: [
  AppComponent,
  HeroesComponent,
  HeroDetailComponent,
  DashboardComponent,
  ChickensComponent,
  ChickenEditComponent,
  ChickenCreateComponent,
  LoginComponent
    //TanComponent
    ],
    imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    HttpModule,
    ],
    providers: [ChickenService, Globals],
    bootstrap: [AppComponent]
  })
export class AppModule { }
