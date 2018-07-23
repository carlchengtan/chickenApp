import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { ChickenService } from '../chicken.service';
import { Router } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { CookiesStorageService } from 'ngx-store';


@Component({
	selector: 'app-login',
	templateUrl: './login.component.html',
	styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

	@Input() credential:any;

  // // it will be stored in a cookie named ${prefix}user_workspaces for 24 hours
  // @CookieStorage({key: 'token', expires: 
  // 	new Date(new Date().getTime() + 24 * 60 * 60 * 1000)}) 
  // userWorkspaces = [];

  constructor(
  	private route: ActivatedRoute,
  	private location: Location,
  	private chickenService: ChickenService,
  	private router: Router,
  	private cookieService: CookiesStorageService,
  	) { }

  ngOnInit() {
  	this.credential = {};
  }

  login(): void{
  	this.chickenService.login(this.credential)
  	.subscribe((response: HttpResponse<any>) => 
  		{	this.cookieService.set("token", response.headers.get("Authorization"), 
  			new Date(new Date().getTime() + 24 * 60 * 60 * 1000)); 
      console.log(this.cookieService.get("token"));
  		this.router.navigate(['/chickens']);
  	} );

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
