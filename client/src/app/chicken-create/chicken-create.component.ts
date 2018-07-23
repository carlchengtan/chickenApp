import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ChickenService } from '../chicken.service';
import { Router } from '@angular/router';


@Component({
	selector: 'app-chicken-create',
	templateUrl: './chicken-create.component.html',
	styleUrls: ['./chicken-create.component.css']
})
export class ChickenCreateComponent implements OnInit {
	
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
		this.chicken = {};

		this.meds = [];
		this.sicknesses = [];
		this.feeds = [];

		this.newMed = {};
		this.newSickness = {};
		this.newFeed = {};
	}

	save(): void{
		this.chicken.medicalRecords = this.meds;
		this.chicken.sicknesses = this.sicknesses;
		this.chicken.feedDetails = this.feeds;
		console.log(this.chicken);

		this.chickenService.save(this.chicken)
		.subscribe((response) => console.log("saved"));
		this.goBack();
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

	goBack(): void{
		this.location.back();
	}

}
