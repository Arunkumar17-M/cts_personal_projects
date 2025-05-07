import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TodoDataService } from '../service/data/todo-data.service';

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit{
 todos!: Todo[];
 message!: string;

 constructor(
  private todoService: TodoDataService,
  private route : Router
 ){ }

 refreshTodos(){
  this.todoService.retrieveAllTodos('kumar').subscribe(
    response => {
      console.log(response);
      this.todos=response;
    }
   )
 }

 ngOnInit(){
   this.refreshTodos();
 }

 deleteTodo(id :any){
  this.todoService.deleteTodo('kumar',id).subscribe(
    response => {
      this.message=`Deleted of Todo ${id} Successfully`;
      this.refreshTodos();
    }
  );
 }

 updateTodo(id : any){
  console.log(`update ${id}`);
  this.route.navigate(['todo',id]);
 }

 addTodo(){
  this.route.navigate(['todo',-1])
 }
}

export class Todo{
  constructor(
    public id:number,
    public description:string,
    public done: boolean,
    public targetDate: Date
  ){}
}