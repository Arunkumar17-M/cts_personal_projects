import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JwtserviceService } from '../jwtservice.service';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterService implements HttpInterceptor{

  constructor(
    private jwtService : JwtserviceService
  ) { }

  intercept(request: HttpRequest<any>, next: HttpHandler){
    let authHeaderString = this.jwtService.getAuthenticationToken();
    let username = this.jwtService.getAuthorizedUser();
    if(authHeaderString && username){
      request = request.clone({
        setHeaders : {
          Authorization : authHeaderString
        }
      })
    }

    return next.handle(request);
  }
}
