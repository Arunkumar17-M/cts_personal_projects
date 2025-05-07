import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JwtserviceService } from '../service/jwtservice.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
    private jwtService: JwtserviceService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.jwtService.logout();
    setTimeout(() => {
      this.router.navigate(['login','Login']);
    },
      1200);
  }
}
