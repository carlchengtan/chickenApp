import { Component, OnInit } from '@angular/core';
import { Chicken } from '../chicken';
import { ChickenService } from '../chicken.service';
import { Observable } from 'rxjs';


@Component({
	selector: 'app-chickens',
	templateUrl: './chickens.component.html',
	styleUrls: ['./chickens.component.css']
})
export class ChickensComponent implements OnInit {

	chickens: Array<any>;
	
	constructor(private chickenService: ChickenService) { }

	ngOnInit() { 
		this.getChickens();
	}

	getChickens(): void{
		// this.chickens = this.chickenService.getChickens();
		this.chickenService.getAll().subscribe(data => {
			this.chickens = data;
		});
	}

}