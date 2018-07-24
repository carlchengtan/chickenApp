import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ChickenService } from '../chicken.service';
import { Router } from '@angular/router';

@Component({
	selector: 'app-chicken-edit',
	templateUrl: './chicken-edit.component.html',
	styleUrls: ['./chicken-edit.component.css']
})
export class ChickenEditComponent implements OnInit {

	@Input() chicken: any;

	private meds: Array<any>;
	private sicknesses: Array<any>;
	private feeds: Array<any>

	private newMed: any;
	private newSickness: any;
	private newFeed: any;
	
	constructor(
		private route: ActivatedRoute,
		private location: Location,
		private chickenService: ChickenService,
		private router: Router
		) {}

	ngOnInit() {
		this.getChicken();

		this.meds = [];
		this.sicknesses = [];
		this.feeds = [];

		this.newMed = {};
		this.newSickness = {};
		this.newFeed = {};
	}

	getChicken(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.chickenService.getOne(id).subscribe(response => {
			this.chicken = JSON.parse(response.text());
			this.chicken.medicalRecords.forEach(element => {
				this.meds.push(element);
			});

			this.chicken.sicknesses.forEach(element => {
				this.sicknesses.push(element);
			});

			this.chicken.feedDetails.forEach(element => {
				this.feeds.push(element);
			});
		});
	}

	delete(): void{
		this.chickenService.delete(this.chicken.id)
		.subscribe((response) => { console.log("deleted"); this.goBack(); });
	}

	update(): void{
		this.chicken.medicalRecords = this.meds;
		this.chicken.sicknesses = this.sicknesses;
		this.chicken.feedDetails = this.feeds;
		this.chickenService.update(this.chicken.id, this.chicken)
		.subscribe((response) => { console.log("updated"); this.goBack(); } );
	}

	goBack(): void{
		this.router.navigate(['/chickens']);
		//this.location.back();
	}

	addField(type) {
		switch(type) { 
			case "med": { 
				this.meds.push(this.newMed)
				this.newMed = {};
				break; 
			} 
			case "sickness": {
				this.sicknesses.push(this.newSickness)
				this.newSickness = {};
				break; 
			}
			case "feed": {
				this.feeds.push(this.newFeed)
				this.newFeed = {};
				break; 
			}
		} 
	}

	deleteField(type, index) {
		switch(type) { 
			case "med": { 
				this.meds.splice(index, 1);
				break; 
			} 
			case "sickness": {
				this.sicknesses.splice(index, 1);
				break; 
			}
			case "feed": {
				this.feeds.splice(index, 1);
				break; 
			}
		} 
	}

}
