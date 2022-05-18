package com.magadiflo.todoapp.service;

import com.magadiflo.todoapp.exceptions.ToDoExceptions;
import com.magadiflo.todoapp.mapper.TaskInDTOToTask;
import com.magadiflo.todoapp.persistence.entity.Task;
import com.magadiflo.todoapp.persistence.entity.TaskStatus;
import com.magadiflo.todoapp.persistence.repository.ITaskRepository;
import com.magadiflo.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    //******* Generando INYECCIÓN DE DEPENDENCIA basada en CONSTRUCTOR *********
    //Es una de las formas de hacer inyección de dependencia, la otra es
    //usando el @Autowired. Pero según el del video esta es la más recomendada
    private final ITaskRepository taskRepository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskInDTOToTask mapper, ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return this.taskRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.taskRepository.findAllByTaskStatus(status);
    }

    @Transactional
    public Task createTask(TaskInDTO taskInDTO) {
        Task task = this.mapper.map(taskInDTO);
        return this.taskRepository.save(task);
    }

    @Transactional
    public void updateTaskAsFinished(Long id){
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if(!optionalTask.isPresent()){
            throw new ToDoExceptions("Task not found!", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.markTaskAsFinished(id);
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if(!optionalTask.isPresent()){
            throw new ToDoExceptions("Task not found!", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }

}
