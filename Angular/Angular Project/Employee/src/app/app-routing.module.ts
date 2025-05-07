import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { DisplayComponent } from './display/display.component';
import { ShowEmployeeComponent } from './show-employee/show-employee.component';

const routes: Routes = [
  { path: '', component: DisplayComponent },
  { path: 'home', component: DisplayComponent },
  { path: 'show/:id', component: ShowEmployeeComponent },
  { path: 'add', component: AddEmployeeComponent },
  { path: 'update/:id', component: AddEmployeeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
