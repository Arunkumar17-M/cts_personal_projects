import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
// to create this type ng g s service/hardcodedAuthentication
export class HardcodedAuthenticationService {

  constructor() { }

  authendicate(userName: any, password: any) {
    // console.log('before',this.isUserLoggedIn());
    if (userName === 'kumar' && password === 'dummy') {
      sessionStorage.setItem("authenticaterUser", userName);
      // console.log('after',this.isUserLoggedIn());
      return true;
    }
    return false;
  }
  isUserLoggedIn() {
    let user = sessionStorage.getItem('authenticaterUser');
    return !(user === null);
  }

  logout(){
    sessionStorage.removeItem('authenticaterUser');
  }
}
