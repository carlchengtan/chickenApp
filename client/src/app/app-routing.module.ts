import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { ChickensComponent } from './chickens/chickens.component';
import { ChickenCreateComponent } from './chicken-create/chicken-create.component'
import { ChickenEditComponent } from './chicken-edit/chicken-edit.component'

import { LoginComponent } from './login/login.component'
import { RegisterComponent } from './register/register.component';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
//import { TanComponent } from './tan/tan.component';

const routes: Routes = [
		{ path: '', redirectTo: 'login', pathMatch: 'full' },
		{ path: 'login', component: LoginComponent },
		{ path: 'register', component: RegisterComponent },
		{ path: 'chickens', component: ChickensComponent },
		{ path: 'chicken-create', component: ChickenCreateComponent },
		{ path: 'chicken-edit/:id', component: ChickenEditComponent },
	];

@NgModule({
  imports: [ FormsModule, RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
})

export class AppRoutingModule {}
