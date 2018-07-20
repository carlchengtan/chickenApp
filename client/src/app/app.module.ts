import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { WebStorageModule } from 'ngx-store';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ChickenService } from './chicken.service';
import { ChickensComponent } from './chickens/chickens.component';
import { ChickenCreateComponent } from './chicken-create/chicken-create.component';
import { ChickenEditComponent } from './chicken-edit/chicken-edit.component';

@NgModule({
  declarations: [
  AppComponent,
  ChickensComponent,
  ChickenEditComponent,
  ChickenCreateComponent,
  LoginComponent,
  ],
  imports: [
  WebStorageModule,
  BrowserModule,
  FormsModule,
  AppRoutingModule,
  HttpClientModule,
  HttpModule,
  ],
  providers: [ChickenService],
  bootstrap: [AppComponent]
})
export class AppModule { }
