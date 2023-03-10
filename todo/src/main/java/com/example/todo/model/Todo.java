package com.example.todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity /*(name = "TODO_TABLE")*/  //for creating table in database using java in model
public class Todo {
    @Id  //Used to create primary-key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //Auto-increment
    private int id;
//  @Column(name = "todo_title")
    private String title;
    private boolean status;

}
