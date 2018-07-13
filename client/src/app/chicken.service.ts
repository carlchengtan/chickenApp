import { Injectable } from '@angular/core';
import { Chicken } from './chicken';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
	providedIn: 'root'
})
export class ChickenService {

	constructor(private http:HttpClient) { }

	getAll(): Observable<any> {
		return this.http.get('//localhost:8080/chickens');
	}

	getHero(id: number): Observable<Chicken> {
		return null;
	}

}
