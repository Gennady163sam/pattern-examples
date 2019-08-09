package com.genius.controllers;

import com.genius.domain.dto.TaskDTO;
import com.genius.domain.purposes.Task;
import com.genius.domain.transfer.Create;
import com.genius.services.TaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @ResponseBody
    public ResponseEntity<Task> createTask(@Validated(Create.class) @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskService.createTask(modelMapper.map(taskDTO, Task.class)));
    }

    @GetMapping("/{taskId}")
    @ResponseBody
    public ResponseEntity<Task> getTask(@PathVariable Long taskId) {
        return ResponseEntity.ok(taskService.getById(taskId));
    }
}
