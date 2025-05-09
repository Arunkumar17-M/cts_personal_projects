import { Component,OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { EmpAddEditComponent } from './emp-add-edit/emp-add-edit.component';
import { TrackDeliverables } from './services/employee.service';
import {MatPaginator} from '@angular/material/paginator';
import {MatSort} from '@angular/material/sort';
import {MatTableDataSource} from '@angular/material/table';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  

  displayedColumns: string[] = [
    'id', 
    'EmployeeName',
    'EmpRole',
    'DeliverableName', 
    'SubDeliverableName',
    'CurrentStatus',
    'Action',
    
    
  ];
  dataSource!: MatTableDataSource<any>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor
  (private _dialog: MatDialog,
  private _empService:TrackDeliverables )
  {}

   ngOnInit(): void{
    this.getTrackingDetails();
   }
  
  openAddEditEmpForm(){
    const dialogRef = this._dialog.open(EmpAddEditComponent);
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val){
          this.getTrackingDetails();
        }
      },
    });
  }

  getTrackingDetails(){
           this._empService.getTrackingDetails().subscribe ({
            next: (res) => {
               this.dataSource = new MatTableDataSource(res);
               this.dataSource.sort = this.sort;
               this.dataSource.paginator = this.paginator;
            },
            error: console.log,

           });
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  openEditForm(data : any ){
    const dialogRef= this._dialog.open(EmpAddEditComponent,{
      data
    });
    dialogRef.afterClosed().subscribe({
      next: (val) => {
        if (val){
          this.getTrackingDetails();
        }
      },
    });
    
      
     }
      
    
  
}
