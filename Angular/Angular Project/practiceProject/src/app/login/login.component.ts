import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { JwtserviceService } from '../service/jwtservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  headername!: string;
  public username!: any;
  public password!: any;
  errorMessage = 'Invalid Username and Password';
  invalid = false;
  registered = 'Successfully Registered! Go Back to Login Page';
  register = false;

  constructor(
    private jwtService: JwtserviceService,
    public route: ActivatedRoute,
    private router : Router
  ) { }

  ngOnInit(): void {
    this.headername = this.route.snapshot.params['name'];
    if (typeof this.headername === 'undefined')
      this.headername = 'Login';
  }

  validate() {
    //Login
    if (this.headername === 'Login') {
      if (typeof this.username === 'undefined' || typeof this.password === 'undefined'
        || this.username === '' || this.password === '') {
        this.invalid = true;
      }
      else {
        this.invalid = false;
        this.jwtService.executeAuthenticateJwtBackend(this.username, this.password)
          .subscribe(
            data => {
              this.jwtService.getLogin().subscribe(
                value=> {
                  sessionStorage.setItem('id',value.id);
                  this.router.navigate(['home']);
                }
              )
            },
            error => {
              this.invalid = true;
              console.log(error);
            }
          )
      }
    }

    //Register
    if(this.headername === 'Register'){
      if (typeof this.username === 'undefined' || typeof this.password === 'undefined'
        || this.username === '' || this.password === '') {
        this.invalid = true;
      }
      else {
        this.jwtService.executeRegisterJwtBackend(this.username, this.password)
        .subscribe(
          data => {
              this.register = true;
              this.invalid = false;
            },
            error => {
              this.invalid = true;
              this.register = false;
              console.log(error);
            }
          )
      }
    }
  }
}
