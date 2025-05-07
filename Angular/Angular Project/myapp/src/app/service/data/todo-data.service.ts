import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Todo } from 'src/app/list-todos/list-todos.component';

@Injectable({
  providedIn: 'root'
})

export class TodoDataService {

  constructor(
    private http: HttpClient
  ) { }

  retrieveAllTodos(username: string){
    return this.http.get<Todo[]>(`http://localhost:9090/user/${username}/todos`);
  }

  deleteTodo(username: any, id :any){
    return this.http.delete(`http://localhost:9090/user/${username}/todos/${id}`);
  }

  retriveTodo(username : any,id: any){
    return this.http.get<Todo>(`http://localhost:9090/user/${username}/todos/${id}`);
  }

  updateTodo(username: any,id :any ,todo : Todo){
    return this.http.put(`http://localhost:9090/user/${username}/todos/${id}`, todo);
  }

  createTodo(username :any,todo : Todo){
    return this.http.post(`http://localhost:9090/user/${username}/todos/`,todo);
  }
}
