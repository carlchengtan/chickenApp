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
	private chickenUsers: Array<any>;
	private newUser: any;
	private chickenId: any;
	private userId: any;

	constructor(
		private route: ActivatedRoute,
		private location: Location,
		private chickenService: ChickenService,
		private router: Router
		) { }

	ngOnInit() {
		this.users = [];
		this.chicken = [];
		this.chickenId = +this.route.snapshot.paramMap.get('id');
		this.chickenUsers = [];
		this.getOwners();
		this.getChicken();
	}

	getOwners(): void{
		this.chickenService.getOwners().subscribe(response => {
			this.users = JSON.parse(response.text());
		});
	}

	getChicken(): void{
		this.chickenService.getOne(this.chickenId)
		.subscribe(response => {
			this.chicken = JSON.parse(response.text());
			
				this.chicken.users.forEach(element => {
					this.chickenUsers.push(element);
				});
				//this.chicken.users = this.chickenUsers;
			
		});
	}
	
	goBack(): void{
		this.location.back();
	}

	save(){
		this.chickenUsers.push(this.users[this.userId]);
		this.chicken.users = this.chickenUsers;
		this.chickenService.changeOwner(this.chicken)
		.subscribe(response => {
			console.log(response.text());
			this.goBack();
		});
	}

}
