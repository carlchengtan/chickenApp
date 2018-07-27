import { Component, OnInit, OnDestroy } from '@angular/core';
import { ChickenService } from '../chicken.service';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';

@Component({
	selector: 'app-chickens',
	templateUrl: './chickens.component.html',
	styleUrls: ['./chickens.component.css']
})
export class ChickensComponent implements OnInit {

	chickens: Array<any>;
	title = 'Chickens';

	
	constructor(private chickenService: ChickenService,
		private route: ActivatedRoute,
		private router: Router){
		this.router.routeReuseStrategy.shouldReuseRoute = function() {
			return false;
		};
	}

	ngOnInit() { 
		this.getChickens();
	}

	getChickens(): void{
		// this.chickens = this.chickenService.getChickens();
		this.chickenService.getAll().subscribe(response => {
			console.log(response.text());
			this.chickens = JSON.parse(response.text());
		});
	}

	delete(id: number): void{
		this.chickenService.delete(id)
		.subscribe((response) => { console.log("deleted"); this.ngOnInit(); });
	}

}
