package com.magadiflo.todoapp.persistence.repository;

import com.magadiflo.todoapp.persistence.entity.Task;
import com.magadiflo.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying //Es una query de actualización y en el servicio lo marcamos como transaccional
    @Query(value = "UPDATE tasks AS t SET t.finished = true WHERE t.id = :id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);

}
