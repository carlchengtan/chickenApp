import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { HttpResponse } from '@angular/common/http';
import { CookiesStorageService } from 'ngx-store';

@Injectable({
	providedIn: 'root'
})
export class ChickenService {

	public API = '//localhost:8080';
	public CHICKEN_API = this.API + '/chickens';
	private token: String;
	private headers: any;

	constructor(private http:Http,
		private cookieService: CookiesStorageService,) { }

	register(credential: any): Observable<any> {
		return this.http.post(
			this.API+"/signup",
			credential
			);
	}

	login(credential: any): Observable<any> {
		return this.http.post(
			this.API+"/token/generate-token",
			credential
			);
	}

	getAll(): Observable<any> {
		return this.http.get(this.CHICKEN_API, 
			this.getOptions(false));
	}

	getOne(id: number): Observable<any> {
		return this.http.get(this.CHICKEN_API + '/' + id, 
			this.getOptions(false));
	}

	save(chicken: any) {
		return this.http.post(this.CHICKEN_API, JSON.stringify(chicken), 
			this.getOptions(true));
	}

	delete(id: number) {
		return this.http.delete(this.CHICKEN_API + '/' + id, 
			this.getOptions(false));
	}
	
	update(id: number, chicken: any){
		console.log(chicken);
		return this.http.put(this.CHICKEN_API + '/' + id, chicken, 
			this.getOptions(true));
	}

	getOwners(): Observable<any> {
		return this.http.get(this.API + "/owners", 
			this.getOptions(false));
	}

	changeOwner(chicken: any){
		// return this.http.put(this.CHICKEN_API + '/' + chickenId + 
		// 	'/' + ownerId, null, this.getOptions(false));
		return this.save(chicken);
	}

	getOptions(withJson: any): RequestOptions{
		const headers = new Headers();
		if(withJson === true){
			headers.append('Content-Type', 'application/json');	
		}
		headers.append('Authorization', this.cookieService.get("token"));
		console.log(this.cookieService.get("token"));
		return new RequestOptions({headers: headers});
	}

}
