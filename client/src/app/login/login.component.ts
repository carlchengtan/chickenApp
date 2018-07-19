import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ChickenService } from '../chicken.service';
import { Router } from '@angular/router';
import { Globals } from '../globals';
import { HttpResponse } from '@angular/common/http';
import { finalize } from 'rxjs/operators/';

@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	@Input() credential:any;

	constructor(
		private route: ActivatedRoute,
		private location: Location,
		private chickenService: ChickenService,
		private router: Router,
		private globals: Globals
		) { }

	ngOnInit() {
		this.credential = {};
	}

	login(): void{
		this.chickenService.login(this.credential)
		.subscribe((response: HttpResponse<any>) => 
			{ this.globals.token = response.headers.get("Authorization"); 
			console.log(this.globals.token); this.router.navigate(['/chickens']) } );
		}


		// login(): void {
		// 	new Promise((resolve, reject) => {
		// 		this.chickenService.login(this.credential)
		// 		.subscribe((data: HttpResponse<any>) => {
		// 			this.globals.token = data.headers.get("Authorization");
		// 			resolve(data);
		// 		}, error => reject(error));
		// 	}).then(response => this.router.navigate(['/chickens']));
		// }

	}
