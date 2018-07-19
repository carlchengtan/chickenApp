import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { HttpResponse } from '@angular/common/http';
import { Globals } from './globals';

@Injectable({
	providedIn: 'root'
})
export class ChickenService {

	public API = '//localhost:8080';
	public CHICKEN_API = this.API + '/chickens';
	private token : String;

	constructor(private http:Http,
		private globals:Globals) { }

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
		headers.append('Authorization', this.globals.token);
		const options = new RequestOptions({headers: headers});
		//console.log("##############"+this.globals.token);
		return this.http.get(this.CHICKEN_API, options);
	}

	getOne(id: number) {
		return this.http.get(this.CHICKEN_API + '/' + id);
	}

	save(chicken: any) {
		return this.http.post(this.CHICKEN_API, chicken);
	}

	delete(id: number) {
		return this.http.delete(this.CHICKEN_API + '/' + id);
	}
	
	update(id: number, chicken: any){
		return this.http.put(this.CHICKEN_API + '/' + id, chicken);
	}

}
