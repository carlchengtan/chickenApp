import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeroesComponent } from './heroes/heroes.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';

import { ChickensComponent } from './chickens/chickens.component';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
//import { TanComponent } from './tan/tan.component';

const routes: Routes = [
		{ path: '', redirectTo: 'dashboard', pathMatch: 'full' },
		{ path: 'heroes', component: HeroesComponent },
		{ path: 'dashboard', component: DashboardComponent },
		{ path: 'chickens', component: ChickensComponent },
		{ path: 'detail/:id', component: HeroDetailComponent },
		//{ path: 'tan', component: TanComponent },
	];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ],
})

export class AppRoutingModule {}
