import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { HttpResponse } from '@angular/common/http';
import { Globals } from './globals';
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
		private globals:Globals,
		private cookieService: CookiesStorageService,) { }

	login(credential: any): Observable<any> {
		const headers = new Headers();
		headers.append('Content-Type', 'application/json');
		const options = new RequestOptions({headers: headers});
		return this.http.post(
			this.API+"/login",
			credential,
			options,
			);
	}

	getAll(): Observable<any> {
		const headers = new Headers();
		headers.append('Authorization', this.cookieService.get("token"));
		const options = new RequestOptions({headers: headers});
		return this.http.get(this.CHICKEN_API, options);
	}

	getOne(id: number): Observable<any> {
		const headers = new Headers();
		headers.append('Authorization', this.cookieService.get("token"));
		const options = new RequestOptions({headers: headers});
		return this.http.get(this.CHICKEN_API + '/' + id, options);
	}

	save(chicken: any) {
		const headers = new Headers();
		headers.append('Authorization', this.cookieService.get("token"));
		const options = new RequestOptions({headers: headers});
		return this.http.post(this.CHICKEN_API, chicken, options);
	}

	delete(id: number) {
		const headers = new Headers();
		headers.append('Authorization', this.cookieService.get("token"));
		const options = new RequestOptions({headers: headers});
		return this.http.delete(this.CHICKEN_API + '/' + id, options);
	}
	
	update(id: number, chicken: any){
		const headers = new Headers();
		headers.append('Authorization', this.cookieService.get("token"));
		const options = new RequestOptions({headers: headers});
		return this.http.put(this.CHICKEN_API + '/' + id, chicken, options);
	}

}
