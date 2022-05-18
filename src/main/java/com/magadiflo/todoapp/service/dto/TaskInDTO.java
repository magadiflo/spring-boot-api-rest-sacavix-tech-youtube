package com.magadiflo.todoapp.service.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * DTO, Data Transfer Object. Solo aquellos atributos que
 * pediremos al cliente, el resto de atributos definidos
 * en el Entity Task, los llenaremos nosotros
 */

@Data //Habilita Setter y Getter
public class TaskInDTO {

    private String title;
    private String description;
    private LocalDateTime eta; //Siglas: Fecha de finalización estimada

}
