
import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { TrackDeliverables } from '../services/employee.service';

import { createInjectableType } from '@angular/compiler';
@Component({
  selector: 'app-emp-add-edit',
  templateUrl: './emp-add-edit.component.html',
  styleUrls: ['./emp-add-edit.component.css']
})
export class EmpAddEditComponent implements OnInit {
       trackDeliverablesForm!: FormGroup;
                
       deliverableList: string[] = [
           'Cloud',
           'Web Development' ,
           'Machine Learning',
           'Data Science'
       ];

       constructor(private _fb:FormBuilder,
        private _empService:TrackDeliverables ,
        private _dialogRef: MatDialogRef< EmpAddEditComponent>,
        @Inject(MAT_DIALOG_DATA)public data: any
         ){
        this.trackDeliverablesForm = this._fb.group({
               EmployeeName: '' ,
               EmpRole: '' ,
               DeliverableName: '',
               SubDeliverableName: '',
               CurrentStatus: '',
               Date:'',
        });
       }

       ngOnInit(): void {
         this.trackDeliverablesForm.patchValue(this.data);
         
       }
       onFormSubmit(){
        if(this.trackDeliverablesForm.valid){
          if(this.data){
            this._empService.updateDeliverabletrack(this.data.id, this.trackDeliverablesForm.value).subscribe({
              next: (val: any) => {
                 alert('Updated Status of Deliverables');
                 this._dialogRef.close(true);
        
              },
              error: (err:any) => {
                console.error(err);
              },
              
            });

          }else{
            this._empService.addDeliverabletrack(this.trackDeliverablesForm.value).subscribe({
              next: (val: any) => {
                 alert('Tracked Status of Employee');
                 this._dialogRef.close(true);
              },
              error: (err:any) => {
                console.error(err);
              },
              
            });

          }
          
        }
       }

}
