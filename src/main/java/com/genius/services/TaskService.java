package com.genius.services;

import com.genius.domain.proections.SimpleTask;
import com.genius.domain.purposes.Purpose;
import com.genius.domain.purposes.Task;
import com.genius.repositories.PurposeRepository;
import com.genius.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Task updateTask(Task task) {
        return taskRepository.save(prepareModel(task));
    }

    public void deleteTask(Long taskId) {
        Optional<Task> deletingTask = taskRepository.findById(taskId);
        deletingTask.ifPresent(task -> taskRepository.delete(task));
    }

    public Optional<Task> getById(Long id) {
        return taskRepository.findById(id);
    }

    public List<SimpleTask> getTasksByPurpose(Long purposeId) {
        Purpose purpose = purposeRepository.getOne(purposeId);
        return taskRepository.findAllByPurpose(purpose);
    }

    private Task prepareModel(Task task) {
        taskRepository.findById(task.getId()).ifPresent(currentTask -> {
            task.setDescription(task.getDescription() != null ? task.getDescription() : currentTask.getDescription());
            task.setDate(task.getDate() != null ? task.getDate() : currentTask.getDate());
            task.setPurpose(task.getPurpose() != null ? task.getPurpose() : currentTask.getPurpose());
        });
        return task;
    }
}
