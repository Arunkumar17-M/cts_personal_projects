import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../display/display.component';
import { AllDataService } from '../service/all-data.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit{

  id!: number;
  emp!: Employee;
  temp!: boolean;

  constructor(
    public service: AllDataService,
    public route: ActivatedRoute,
    public router: Router
  ){
    this.emp=new Employee();
    this.id=this.route.snapshot.params['id'];
  }

  ngOnInit(): void {
    if(typeof this.id == 'undefined'){
      this.temp=false;
    }else{
      this.temp=true;
      this.service.showData(this.id).subscribe(
        data=> this.emp=data
      );
    }
  }

  saveEmployee(){
    if(typeof this.id == 'undefined'){
      this.service.postData(this.emp).subscribe(
        data => 
        this.router.navigate(['home']) // always put the line inside subscribe otherwise
        // data will come before the update or post.
      );
    }else{
      this.service.updateData(this.emp).subscribe(
        data=> this.router.navigate(['home'])
      );
    }
  }

}
