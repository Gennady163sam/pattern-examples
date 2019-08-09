package com.genius.services;

import com.genius.domain.purposes.Task;
import com.genius.repositories.PurposeRepository;
import com.genius.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    private PurposeRepository purposeRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository, PurposeRepository purposeRepository) {
        this.taskRepository = taskRepository;
        this.purposeRepository = purposeRepository;
    }

    public Task createTask(Task task) {
        Task createdTask = taskRepository.save(task);
        createdTask.setPurpose(purposeRepository.getOne(createdTask.getPurpose().getPurposeId()));
        return createdTask;
    }

    public Task getById(Long id) {
        return taskRepository.getOne(id);
    }
}
