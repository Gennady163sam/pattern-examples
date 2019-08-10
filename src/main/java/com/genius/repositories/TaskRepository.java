package com.genius.repositories;

import com.genius.domain.proections.SimpleTask;
import com.genius.domain.purposes.Purpose;
import com.genius.domain.purposes.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<SimpleTask> findAllByPurpose(Purpose purpose);
}
