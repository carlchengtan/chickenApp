import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HeroesComponent } from './heroes/heroes.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { ChickensComponent } from './chickens/chickens.component';

import { ChickenService } from './chicken.service';
import { ChickenEditComponent } from './chicken-edit/chicken-edit.component';
import { ChickenCreateComponent } from './chicken-create/chicken-create.component';

import { ReactiveFormsModule } from '@angular/forms';  
//import { TanComponent } from './tan/tan.component';


@NgModule({
  declarations: [
  AppComponent,
  HeroesComponent,
  HeroDetailComponent,
  DashboardComponent,
  ChickensComponent,
  ChickenEditComponent,
  ChickenCreateComponent
    //TanComponent
    ],
    imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
    ],
    providers: [ChickenService],
    bootstrap: [AppComponent]
  })
export class AppModule { }
