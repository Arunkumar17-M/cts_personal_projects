import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { URL } from '../jwtservice.service';

@Injectable({
  providedIn: 'root'
})
export class ListfilmServiceService {
  constructor(private http : HttpClient
    ) { }

  getListofFilm(id : any){
    return this.http.get<Film[]>(`${URL}/user/${id}/film`);
  }

  getSpecificFilmBackend(id : any, filmid : any){
    return this.http.get<Film>(`${URL}/user/${id}/film/${filmid}`);
  }

  postData(id : any, film : Film){
    return this.http.post<Film>(`${URL}/user/${id}/film`,film);
  }

  updateData(id: any, filmid : any, film : Film){
    return this.http.put(`${URL}/user/${id}/film/${filmid}`,film);
  }

  deleteData(id: any, filmid : any){
    return this.http.delete(`${URL}/user/${id}/film/${filmid}`);
  }
}

export class Film{
    public id!: number;
    public customerId! : number;
    public filmName! : string;
    public filmDuration! : string;
    public amount! : number;
    public watched! : boolean;
    public releaseDate! : Date
}