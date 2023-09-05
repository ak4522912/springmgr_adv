package com.basic.springmgr_adv.repositories;

import com.basic.springmgr_adv.entities.TaskEntity;
import com.basic.springmgr_adv.respositories.TasksRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

    @Test
    public void addTwoTasks(){
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("Test Task");
        task1.setDescription("Test Descr");
        task1.setCompleted(false);
        var savedTask1 = tasksRepository.save(task1);
        TaskEntity task2 = new TaskEntity();
        task2.setTitle("Test Task");
        task2.setDescription("Test Descr");
        task2.setCompleted(false);
        var savedTask2 = tasksRepository.save(task2);
        var tasks = tasksRepository.findAll();
        assertNotNull(tasks);
        assertEquals(2,tasks.size());
    }

    @Test
    public void findByCompletedWorks(){
        TaskEntity task1 = new TaskEntity();
        task1.setTitle("Test Task");
        task1.setDescription("Test Descr");
        task1.setCompleted(false);
        var savedTask1 = tasksRepository.save(task1);
        TaskEntity task2 = new TaskEntity();
        task2.setTitle("Test Task");
        task2.setDescription("Test Descr");
        task2.setCompleted(true);
        var savedTask2 = tasksRepository.save(task2);
        var completedTasks = tasksRepository.findAllByCompleted(true);
        var nonCompletedTasks = tasksRepository.findAllByCompleted(false);
        assertEquals(1,completedTasks.size());
        assertEquals(1,nonCompletedTasks.size());
    }
}
