import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { AllDataService } from '../service/all-data.service';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit{

  emp!: Employee[];
  constructor(
    private route: Router,
    public service: AllDataService
    ){}

    ngOnInit(): void {
      this.refreshPage();
    }

    refreshPage(){
      this.service.liatallData().subscribe(
        response => this.emp=response
      )
    }

    show(id: number){
      this.route.navigate(['show',id]);
    }

    deletefunc(id : any){
      this.service.deleteData(id).subscribe(
        data=> 
        this.refreshPage()
      );
    }

    updatefunc(id: any){
      this.route.navigate(['update',id]);
    }
}

export class Employee{
  public id!: number;
  public empid!:number;
  public empname!:string;
}