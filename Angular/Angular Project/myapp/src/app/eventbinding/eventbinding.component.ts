import { Component } from '@angular/core';

@Component({
  selector: 'app-eventbinding',
  templateUrl: './eventbinding.component.html',
  styleUrls: ['./eventbinding.component.css']
})
export class EventbindingComponent {

  name:string = "";
  dis:string ="";

  updatedata(event:any){
    this.name=event.target.value;
  }

  displaydata(){
    this.dis=this.name;
  }
}
