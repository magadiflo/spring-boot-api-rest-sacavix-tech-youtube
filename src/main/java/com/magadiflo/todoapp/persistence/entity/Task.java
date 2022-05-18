package com.magadiflo.todoapp.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //Habilita Setter y Getter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String description;

    private LocalDateTime createdDate;

    private LocalDateTime eta; //Siglas: Fecha de finalización estimada

    private Boolean finished;

    private TaskStatus taskStatus;

}
