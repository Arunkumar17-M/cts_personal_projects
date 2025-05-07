import { Component,OnInit } from '@angular/core';

@Component({
  selector: 'app-time-stamp',
  templateUrl: './time-stamp.component.html',
  styleUrls: ['./time-stamp.component.css']
})
export class TimeStampComponent  implements OnInit{ 

  Date1: Date = new Date();
  constructor(){}
  ngOnInit(): void {
    console.log(this.Date1)
    
  }

}
