import { Component } from '@angular/core';
import { JwtserviceService } from '../service/jwtservice.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent {

  constructor(
    public jwtService : JwtserviceService
  ){}
}
