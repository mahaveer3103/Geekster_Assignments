package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class TodoService  {

    private static List<Todo> todos = new ArrayList<>(); // In-memory database

//    private static int todoCount=0;
//
//    static {
//
//    }

    @Autowired
    TodoRepository todoRepository;


    public List<Todo> findAll(){  //Business Logic
        return todoRepository.findAll();
    }


    public Todo findById(int id){
//        for(int i=0;i<todos.size();i++){
//            Todo t = todos.get(i);
//            if(id==t.getId()){
//                return t;
//            }
//        }
//        return null;
        return todoRepository.findById(id).get();
    }


    public void addTodo(Todo todo){
        todos.add(todo);
        todoRepository.save(todo);
    }


    public void deleteTodo(int id){
//        for(int i=0;i<todos.size();i++){
//            Todo t = todos.get(i);
//            if(id==t.getId()){
//                todos.remove(id);
//            }
//        }
        todoRepository.deleteById(id);
    }


    public void updateTodo(int id,Todo newtodo){
        //step 1: find todo to be update
        //step 2: Update Todo

        Todo todo = todoRepository.findById(id).get();
        todo.setId(newtodo.getId());
        todo.setStatus(newtodo.isStatus());
        todo.setTitle(newtodo.getTitle());
        todoRepository.save(todo);
    }
}
