package com.pro.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.todo.model.Project;

public interface ProjectRepo extends JpaRepository<Project,Long>{

}
