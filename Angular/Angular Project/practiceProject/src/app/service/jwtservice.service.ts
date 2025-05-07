import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class JwtserviceService {

  constructor(
    private http : HttpClient
  ) { }

  executeAuthenticateJwtBackend(username: string, password : string){
    return this.http.post<any>(`${URL}/authenticate`,{
      username,
      password
    }).pipe(
      map(
        data=>{
          sessionStorage.setItem(AUTHORIZED_USER,username);
          sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
          return data;
        }
      )
    )
  }
  
  executeRegisterJwtBackend(username: string, password : string){
    return this.http.post<any>(`${URL}/register`,{
      username,
      password
    });
  }

  getLogin(){
    return this.http.get<Login>(`${URL}/getlogin/${this.getAuthorizedUser()}`);
  }

  getAuthorizedUser(){
    return sessionStorage.getItem(AUTHORIZED_USER);
  }

  getAuthenticationToken() : any{
    if(this.getAuthorizedUser())
      return sessionStorage.getItem(TOKEN);
  }

  isUserLoggedIn(){
    let user=sessionStorage.getItem(AUTHORIZED_USER);
    return !(user == null);
  }

  logout(){
    sessionStorage.removeItem(AUTHORIZED_USER);
    sessionStorage.removeItem(TOKEN);
    sessionStorage.removeItem('id');
  }
}
export const AUTHORIZED_USER = 'authorizedUser';
export const URL = 'http://localhost:9090';
export const TOKEN = 'token';
export class Login{
  constructor(
    public id : any,
    public username : string
  ){}
}