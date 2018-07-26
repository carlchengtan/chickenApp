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
  	.subscribe((response) => 
  		{	const tempToken = (JSON.parse(response.text())).token;
        this.cookieService.set("token", "Bearer " + tempToken,
  			new Date(new Date().getTime() + 24 * 60 * 60 * 1000)); 
      console.log(this.cookieService.get("token"));
  		this.router.navigate(['/chickens']);
  	} );
  }


	}
