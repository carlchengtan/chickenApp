import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ChickenService } from '../chicken.service';
import { Router } from '@angular/router';

@Component({
	selector: 'app-change-owner',
	templateUrl: './change-owner.component.html',
	styleUrls: ['./change-owner.component.css']
})
export class ChangeOwnerComponent implements OnInit {

	@Input() chicken: any;
	private users: Array<any>;
	private newOwner: any;

	constructor(
		private route: ActivatedRoute,
		private location: Location,
		private chickenService: ChickenService,
		private router: Router
		) { }

	ngOnInit() {
		this.users = [];
		this.newOwner = {};
		this.getOwners();
	}

	getOwners(): void{
		this.chickenService.getOwners().subscribe(response => {
			this.users = JSON.parse(response.text());
		});
	}
	
	goBack(): void{
		this.location.back();
	}

	save(){
		const chickenId = +this.route.snapshot.paramMap.get('id');
		console.log("CHICKEN ID: " + chickenId);
		console.log("OWNER ID: " + this.newOwner.id);
		this.chickenService.changeOwner(chickenId, this.newOwner.id)
		.subscribe(response => {
			console.log(response.text());
		});
	}

}
