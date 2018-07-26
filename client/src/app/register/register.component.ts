import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ChickenService } from '../chicken.service';
import { Router } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { CookiesStorageService } from 'ngx-store';


@Component({
	selector: 'app-register',
	templateUrl: './register.component.html',
	styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

	@Input() user:any;

	constructor(
		private route: ActivatedRoute,
		private location: Location,
		private chickenService: ChickenService,
		private router: Router,
		private cookieService: CookiesStorageService,
		) { }

	ngOnInit() {
		this.user = {};
	}

	register(): void{
		this.chickenService.register(this.user)
		.subscribe((response: HttpResponse<any>) => 
			{	console.log(response);
		} );

	}
}
