package com.pro.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.todo.model.Project;
import com.pro.todo.repo.ProjectRepo;

@RestController
public class ProjectController {

    @Autowired
    ProjectRepo repo;

    
    @GetMapping(path="/project/all")
    public List<Project> projectListView(){
        return repo.findAll();    
    }



    @GetMapping(path="/project/{id}")
    public Optional<Project> projectDetailView(@PathVariable("id") Long id){
        return repo.findById(id);
    }

    @PostMapping("/project/add")
    public Project projectCreateView(@RequestBody Project project){
        repo.save(project);
        return project;
    }

    @PutMapping("/project/change")
    public Project projectUpdateOrSaveView(@RequestBody Project project){
        repo.save(project);
        return project;
    }

    @DeleteMapping("/project/{id}/remove")
    public String projectDeleteView(@PathVariable("id") Long id){
        Project p=repo.getReferenceById(id);
        repo.delete(p);
        return "deleted";

    }



}
