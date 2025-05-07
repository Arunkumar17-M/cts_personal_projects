import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

export class HelloWorldBean{
  constructor(public message:string){}
}

@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(
    public http: HttpClient
  ) { }

  executeHelloWorldBean(){
    return this.http.get<HelloWorldBean>('http://localhost:9090/hello-world/');
  }

  executeHelloWorldWithPathVariable(name : any){
    // let basicAuthHeaderString=this.createBasicAuthenticateHttpHeader();
    // let header= new HttpHeaders({
    //   Authorization : basicAuthHeaderString
    // })
    return this.http.get<HelloWorldBean>(`http://localhost:9090/hello-world/path-variable/${name}`,
    // {headers: header}
    );
  }

  // createBasicAuthenticateHttpHeader(){
  //   let username='user';
  //   let password='password';
  //   let basicAuthHeaderString='Basic '+window.btoa(username+':'+password);
  //   return basicAuthHeaderString;
  // }
}
