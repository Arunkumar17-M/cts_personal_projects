package com.cts.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cts.model.Todo;

@Service
public class HardCodedTodoService {

	private static List<Todo> todos = new ArrayList<>();
	private static int idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "kumar", "Learn to Dance", new Date(), false));
		todos.add(new Todo(++idCounter, "kumar", "Become an expert at Angular 2", new Date(), false));
		todos.add(new Todo(++idCounter, "kumar", "Visit India", new Date(), false));
	}

	public List<Todo> findall() {
		return todos;
	}

	public Todo deleteById(long id) {
		Todo todo = findById(id);
		if (todo == null)
			return null;
		if (todos.remove(todo))
			return todo;
		return null;
	}

	public Todo findById(long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id)
				return todo;
		}
		return null;
	}

	public Todo save(Todo todo) {
		if (todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todo.setUsername("kumar");
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}

		return todo;
	}
}
