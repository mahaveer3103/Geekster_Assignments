package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
    CREATE TODO, DELETE TODO, UPDATE TODO, FETCH TODO (CRUD OPERATIONS)
*/
//RestController = Controller + ResponseBody

//When the user hit an API the api first come to the Controller
@RestController
@RequestMapping("/api/v1/todo-app")
public class TodoController {

    //Field-Injection
    @Autowired // Used to inject dependency
     private TodoService todoService;

    //Constructor-Injection (Optional @Autowired)
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

//    @Autowired //It is mandatory to make object
    public void setTodoService(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/add-todo")  //It is used to save the newTODO
    public void addTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
    }

    @GetMapping("/find-todo/id/{id}")  //It is used to retrieve single todo
    public Todo findTodoById(@PathVariable int id){
        return todoService.findById(id);
    }

    // controller is talking to the service layer
    @GetMapping("find-all")  //It is used to retrieve all todos
    public List<Todo> findAllTodos(){
        return todoService.findAll();
    }

    @PutMapping("update-todo/id/{id}")  //It is used to update the existing todo
    /*@RequestMapping(value = " ",method = RequestMethod.PUT)*/ //Alternate Method! for every type of crud operations
    public void updateTodo(@PathVariable int id, @RequestBody Todo todo){
        todoService.updateTodo(id,todo);
    }

    @DeleteMapping("delete-todo/id/{id}")  //It is used to delete the existing todo
    public void deleteTodo(@PathVariable int id){
        todoService.deleteTodo(id);
    }

//    @RequestMapping("/api/username/{username}")
//    public String pathMethod(@PathVariable String username){
//        return "Hello "+username;
//    }
//
//    @RequestMapping("/api")
//    public String paramMethod(@RequestParam String username){
//        return "Hello "+username;
//    }
}
