import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Employee } from '../display/display.component';
import { AllDataService } from '../service/all-data.service';

@Component({
  selector: 'app-show-employee',
  templateUrl: './show-employee.component.html',
  styleUrls: ['./show-employee.component.css']
})
export class ShowEmployeeComponent implements OnInit{

  emp!: Employee;
  id! : number;
  constructor(
    public service: AllDataService,
    private router: ActivatedRoute
  ){}

  ngOnInit(): void {
    this.emp = new Employee();
    this.id=this.router.snapshot.params['id'];
    this.service.showData(this.id).subscribe(
      data=>this.emp=data
    );
  }
}
