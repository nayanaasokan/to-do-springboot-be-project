package com.pro.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.todo.model.Todo;
import com.pro.todo.repo.TodoRepo;

@RestController
public class TodoController {

    @Autowired
    TodoRepo repo;

    @GetMapping(path="/todo/all")
    public List<Todo> TodoListView(){
        return repo.findAll();       
    }

    @GetMapping(path="/todo/{id}")
    public Optional<Todo> TodoDetailView(@PathVariable("id") long id){
        return repo.findById(id);
    }

    @PostMapping(path="/todo/add",consumes={"application/json"})
    public Todo TodoCreateView(@RequestBody Todo todo){
        repo.save(todo);
        return todo;
    }

    @PutMapping(path="/todo/change")
    public Todo TodoUpdateOrSaveView(@RequestBody Todo todo){
        repo.save(todo);
        return todo;
    }
   
    @DeleteMapping(path="/todo/{id}/remove")
    public String TodoDeleteView(@PathVariable("id") long id){
        Todo t=repo.getReferenceById(id);
        repo.delete(t);
        return "deleted";

    }

}
