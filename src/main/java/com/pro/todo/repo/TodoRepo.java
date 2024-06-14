package com.pro.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.todo.model.Todo;

public interface TodoRepo extends JpaRepository<Todo,Long>{

}
