import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { HeroesComponent } from './heroes/heroes.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';

import { ChickensComponent } from './chickens/chickens.component';
import { ChickenCreateComponent } from './chicken-create/chicken-create.component'
import { ChickenEditComponent } from './chicken-edit/chicken-edit.component'

import { LoginComponent } from './login/login.component'

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
//import { TanComponent } from './tan/tan.component';

const routes: Routes = [
		{ path: '', redirectTo: 'login', pathMatch: 'full' },
		{ path: 'login', component: LoginComponent },
		{ path: 'heroes', component: HeroesComponent },
		{ path: 'dashboard', component: DashboardComponent },
		{ path: 'detail/:id', component: HeroDetailComponent },
		{ path: 'chickens', component: ChickensComponent },
		//{ path: 'chicken-add', component: ChickenEditComponent },
		{ path: 'chicken-create', component: ChickenCreateComponent },
		{ path: 'chicken-edit/:id', component: ChickenEditComponent },

		//{ path: 'tan', component: TanComponent },
	];

@NgModule({
  imports: [ FormsModule, RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
})

export class AppRoutingModule {}
