import { Component } from '@angular/core';

@Component({
  selector: 'app-directives',
  templateUrl: './directives.component.html',
  styleUrls: ['./directives.component.css'],
  styles:[`
    .online{
      color: white;
    }
  `]
})
export class DirectivesComponent {

  serverStatus!: boolean;
  serverName!:String;

  getcolour(){
    this.serverStatus=(Math.random() > 0.5);
    this.serverName= this.serverStatus ? 'Online' : 'Offline';
    return (this.serverStatus) ? 'green' : 'red';
  }
}
