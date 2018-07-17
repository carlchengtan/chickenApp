import { Injectable } from '@angular/core';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
	providedIn: 'root'
})
export class ChickenService {

	public API = '//localhost:8080';
	public CHICKEN_API = this.API + '/chickens';

	constructor(private http:HttpClient) { }

	getAll(): Observable<any> {
		return this.http.get(this.CHICKEN_API);
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
