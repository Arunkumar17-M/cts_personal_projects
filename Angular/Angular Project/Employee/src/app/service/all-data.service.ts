import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../display/display.component';

@Injectable({
  providedIn: 'root'
})
export class AllDataService {

  constructor(
    public http: HttpClient
  ) { }

  liatallData(){
    return this.http.get<Employee[]>('http://localhost:9090/listall');
  }

  deleteData(id : any){
    return this.http.delete(`http://localhost:9090/${id}`);
  }

  showData(id : any){
    return this.http.get<Employee>(`http://localhost:9090/${id}`);
  }

  postData(emp : Employee){
    return this.http.post(`http://localhost:9090/`,emp);
  }

  updateData(emp : Employee){
    return this.http.put(`http://localhost:9090/`,emp);
  }
}
