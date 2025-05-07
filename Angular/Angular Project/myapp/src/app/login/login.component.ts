import { Component} from '@angular/core';
import { Router } from '@angular/router';
import { BasicAuthenticationService } from '../service/basic-authentication.service';
import { HardcodedAuthenticationService } from '../service/hardcoded-authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent {

  userName: string = '';
  password: string = '';
  errorMessage = 'Invalid Credentials';
  invalidLogin = false;
  constructor(private route: Router,
    public hardercodedAuthenticationservice: HardcodedAuthenticationService,
    public basicAuthendicationService: BasicAuthenticationService) { }
  todo() {
    this.invalidLogin = !this.hardercodedAuthenticationservice.authendicate(this.userName,this.password);
    if (!this.invalidLogin) this.route.navigate(['welcome', this.userName]);
  }

  basicAuthtodo() {
    this.basicAuthendicationService.executeAuthenticationService(this.userName,this.password)
    .subscribe(
      data => {
        console.log(data);
        this.route.navigate(['welcome', this.userName]);
        this.invalidLogin=false;
      },
      error =>{
        console.log(error);
        this.invalidLogin=true;
      }
    );
  }

  handelJWTAuthLogin() {
    this.basicAuthendicationService.executeJWTAuthenticationService(this.userName,this.password)
    .subscribe(
      data => {
        console.log(data);
        this.route.navigate(['welcome', this.userName]);
        this.invalidLogin=false;
      },
      error =>{
        console.log(error);
        this.invalidLogin=true;
      }
    );
  }
}
