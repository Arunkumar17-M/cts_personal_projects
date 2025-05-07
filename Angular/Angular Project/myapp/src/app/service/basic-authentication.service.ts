import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})

export class BasicAuthenticationService {

  constructor(
    public http: HttpClient
  ) { }

  executeJWTAuthenticationService(username: any, password : any){

    return this.http.post<any>(`http://localhost:9090/authenticate`,
    {
      username,
      password
    }).pipe(
      map(
        data => {
          sessionStorage.setItem("authenticaterUser", username);
          sessionStorage.setItem("token", `Bearer ${data.token}`);
          return data;
        }
      )
    );
  }

  authendicate(userName: any, password: any) {
    // console.log('before',this.isUserLoggedIn());
    if (userName === 'kumar' && password === 'dummy') {
      sessionStorage.setItem("authenticaterUser", userName);
      // console.log('after',this.isUserLoggedIn());
      return true;
    }
    return false;
  }

  executeAuthenticationService(username: any, password : any){
    let basicAuthHeaderString='Basic '+window.btoa(username+':'+password);
    let header= new HttpHeaders({
      Authorization : basicAuthHeaderString
    })
    return this.http.get<authenticationBean>(`http://localhost:9090/basicauth`,
    {headers: header}).pipe(
      map(
        data => {
          sessionStorage.setItem("authenticaterUser", username);
          sessionStorage.setItem("token", basicAuthHeaderString);
          return data;
        }
      )
    );
  }

  getAuthenticatedUser(){
    return sessionStorage.getItem('authenticaterUser');
  }

  getAuthenticatedToken() : any{
    if(this.getAuthenticatedUser())
      return sessionStorage.getItem('token');
  }

  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticaterUser');
    return !(user === null);
  }

  logout(){
    sessionStorage.removeItem('authenticaterUser');
    sessionStorage.removeItem('token');
  }
}

export class authenticationBean{
  constructor(
    public message : string
  ){}
}