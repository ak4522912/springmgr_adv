package com.basic.springmgr_adv.repositories;

import com.basic.springmgr_adv.entities.TaskEntity;
import com.basic.springmgr_adv.respositories.TasksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class TasksRepositoryTests {
    @Autowired
    TasksRepository tasksRepository;
@Test
    public void testCreateTask() {
        TaskEntity task = new TaskEntity();
        task.setTitle("Test Task");
        task.setDescription("Test Descr");
        task.setCompleted(false);
        var savedTask = tasksRepository.save(task);
        assertNotNull(savedTask);
    }
}
