package com.pro.todo.model;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Project {

    @Id
    @GeneratedValue
    private long id;
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> todos;

    public Project() {
        this.createdDate = new Date();
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Todo> getTodos() {
        return todos;
    }

    public void setTodos(List<Todo> todos) {
        this.todos = todos;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", title=" + title + ", createdDate=" + createdDate + ", todos=" + todos + "]";
    }
    

}
