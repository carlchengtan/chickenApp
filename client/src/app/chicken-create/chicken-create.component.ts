import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ChickenService } from '../chicken.service';
import {Router} from '@angular/router';


@Component({
	selector: 'app-chicken-create',
	templateUrl: './chicken-create.component.html',
	styleUrls: ['./chicken-create.component.css']
})
export class ChickenCreateComponent implements OnInit {
	
	@Input() chicken: any;
	@Input() medicalRecord: any;
	@Input() medicalTemp: any;
	medicalRecords: any;
	//ctr: number;

	constructor(
		private route: ActivatedRoute,
		private location: Location,
		private chickenService: ChickenService,
		private router: Router
		) { }

	ngOnInit() {
		this.chicken = {};
		this.chicken.medicalRecords = {};
		this.medicalTemp = {};
		this.medicalRecords = [];
		//this.ctr = 0;
		//this.chicken.medicalRecords = this.medicalRecord;
	}

	save(): void{
		console.log(this.chicken);
		this.chickenService.save(this.chicken)
		.subscribe((response) => console.log("saved"));
		this.goBack();

	}

	goBack(): void{
		this.location.back();
	}

	addMedicalRecord(): void{
		//Object.assign(this.medicalRecords, 
		//	'{"vaccineDate":"'+this.medicalTemp.vaccineDate+'",'
		//	+'"vaccineType":"'+this.medicalTemp.vaccineType+'"}');
		//this.chicken['medicalRecords'][this.ctr].vaccineDate = this.medicalTemp.vaccineDate;
		//this.ctr++;
		//this.chicken.medicalRecords[0] = this.medicalTemp;
		//this.chicken.medicalRecords[1] = this.medicalTemp;
		console.log(this.chicken);
		//console.log(this.medicalRecord);
	}

}
