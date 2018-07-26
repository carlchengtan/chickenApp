import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { CookiesStorageService } from 'ngx-store';
import { Subscription } from 'rxjs/Subscription';


@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
	private _routerSub = Subscription.EMPTY;

	constructor(
		private cookieService: CookiesStorageService,
		private router: Router,
		) {}

	ngOnInit() {
		this._routerSub = this.router.events.subscribe((val) => {
			this.checkRoute(val);
		});
	}

	ngOnDestroy(){
		this._routerSub.unsubscribe();
	}

	checkRoute(val){
		const url = this.router.url;
		if(url === "/login"){
			this.router.navigate(["/login"]);
		}
		if(url === "/register"){
			this.router.navigate(["/register"]);
		}
		/*logged out user tries to access system*/
		if(val instanceof NavigationEnd && this.cookieService.get("token")==null) {
			this.router.navigate(["/login"]);
			console.log(url);
			this.ngOnDestroy();
		}
	}

	logout(){
		this.cookieService.clear();
		this.router.navigate(["/login"]);
	}
}
