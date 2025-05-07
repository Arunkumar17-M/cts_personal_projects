package com.demo.project.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	private TodoRepository todoRepository;

	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {

		List<Todo> todos = todoRepository.findByUsername(getLoggedInUsername());
		model.put("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.GET)
	public String showNewTodos(ModelMap model) {

		Todo todo = new Todo(0, getLoggedInUsername(), "", LocalDate.now(), false);
		model.put("todo", todo);
		return "todo";
	}

	@RequestMapping(value = "add-todos", method = RequestMethod.POST)
	public String addNewTodos(ModelMap model, @Valid Todo todo, BindingResult error) {

		if (error.hasErrors()) {

			return "todo";
		}

		String username = getLoggedInUsername();
		todo.setUsername(username);
		
		todoRepository.save(todo);
		return "redirect:list-todos";
	}


	@RequestMapping(value = "delete-todo")
	public String deleteTodo(@RequestParam int id) {

		todoRepository.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value = "update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {

		Todo todo = todoRepository.findById(id).get();
		model.addAttribute("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value = "update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, Todo todo, BindingResult error) {
		
		if(error.hasErrors()) {
			return "todo";
		}
		
		todo.setUsername(getLoggedInUsername());
		
		todoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
