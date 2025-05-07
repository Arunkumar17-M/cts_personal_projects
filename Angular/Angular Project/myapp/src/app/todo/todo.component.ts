import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Todo } from '../list-todos/list-todos.component';
import { TodoDataService } from '../service/data/todo-data.service';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  id !: number;
  todo !: Todo;

  constructor(
    private route: ActivatedRoute,
    private TodoService: TodoDataService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.todo = new Todo(this.id, '', false, new Date());// this line is added because
    //object is not created but we try to insert value so error occur.
    if (this.id != -1) {
      this.TodoService.retriveTodo('kumar', this.id).subscribe(
        data => this.todo = data
      );
    }
  }
  saveTodo() {
    if (this.id === -1) {
      this.TodoService.createTodo('kumar',this.todo).subscribe(
        data=>{ console.log(data);
        this.router.navigate(['todos']);
        }
      );
    } else {
      this.TodoService.updateTodo('kumar', this.id, this.todo).subscribe(
        data => {
          console.log(data);
          this.router.navigate(['todos']);
        }
      );
    }

  }
}
