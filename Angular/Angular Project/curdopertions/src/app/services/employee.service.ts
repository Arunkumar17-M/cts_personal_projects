import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrackDeliverables {

  constructor(private _http:HttpClient ) { }
  addDeliverabletrack(data: any): Observable<any>{ 
    return this._http.post(' http://localhost:3000/Employee',data);
  }

  updateDeliverabletrack(id: number, data: any): Observable<any>{ 
    return this._http.put(` http://localhost:3000/Employee/${id}`,data);
  }

  getTrackingDetails(): Observable<any>{ 
    return this._http.get(' http://localhost:3000/Employee');
  }

  

}
