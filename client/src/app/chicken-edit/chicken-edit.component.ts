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
	
	constructor(
		private route: ActivatedRoute,
		private location: Location,
		private chickenService: ChickenService,
		private router: Router
		) {}

	ngOnInit() {
		this.getChicken();
	}

	getChicken(): void{
		const id = +this.route.snapshot.paramMap.get('id');
		this.chickenService.getOne(id).subscribe(response => {
			this.chicken = JSON.parse(response.text());
		});
	}

	delete(): void{
		this.chickenService.delete(this.chicken.id)
		.subscribe((response) => { console.log("deleted"); this.goBack(); });
	}

	update(): void{
		this.chickenService.update(this.chicken.id, this.chicken)
		.subscribe((response) => { console.log("updated"); this.goBack(); } );
	}

	goBack(): void{
		this.router.navigate(['/chickens']);
		//this.location.back();
	}
}
