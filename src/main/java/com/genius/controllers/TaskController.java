package com.genius.controllers;

import com.genius.domain.dto.TaskDTO;
import com.genius.domain.proections.SimpleTask;
import com.genius.domain.purposes.Task;
import com.genius.domain.transfer.Create;
import com.genius.domain.transfer.Update;
import com.genius.exceptions.ApiException;
import com.genius.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private TaskService taskService;
    private ModelMapper modelMapper;

    @Autowired
    public TaskController(TaskService taskService, ModelMapper modelMapper) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Validated(Create.class) @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.createTask(modelMapper.map(taskDTO, Task.class)));
    }

    @PutMapping
    public ResponseEntity<Task> updateTask(@Validated(Update.class) @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.updateTask(modelMapper.map(taskDTO, Task.class)));
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.getById(taskId).orElseThrow(() -> new ApiException(HttpStatus.BAD_REQUEST)));
    }

    @GetMapping
    public ResponseEntity<List<SimpleTask>> getTasksByPurpose(@RequestParam Long purposeId) {
        return ResponseEntity.ok(taskService.getTasksByPurpose(purposeId));
    }
}
