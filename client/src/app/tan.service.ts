import { Injectable } from '@angular/core';
import { Tan } from './tan';
import { Observable, of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class TanService {

	getTans(): Tan[]{
		/*TODO*/
		return null;
	}

	getTan(id: number): Observable<Tan>{
		/*TODO (ex. )*/
		return null;
	}

  constructor() { }
}
