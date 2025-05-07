package com.demo.project.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();

	private static int todoCount = 0;
	static {

		todos.add(new Todo(++todoCount, "kumar", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todoCount, "kumar", "Learn DevOps", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++todoCount, "kumar", "Learn Full Stack", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUsername(String username) {
		
		return todos.stream().filter(todo -> todo.getUsername().equalsIgnoreCase(username)).toList();
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {

		Todo todo = new Todo(++todoCount, username, description, targetDate, done);
		todos.add(todo);
	}

	public void deleteTodo(int id) {

		todos.removeIf(todo -> todo.getId() == id);
	}

	public Todo findById(int id) {

		Todo todo = todos.stream().filter(t -> t.getId() == id).findFirst().get();
		return todo;
	}
	
	public void updateById(@Valid Todo todo) {
		
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}
