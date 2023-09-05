package com.basic.springmgr_adv.respositories;

import com.basic.springmgr_adv.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TaskEntity,Integer> {
    List<TaskEntity> findAllByCompleted(boolean completed);
    //ideally this is business logic terminolog(i.e overdue) so should be in service
    @Query(""+
    "Select t from tasks t"+
    "whete t.completed = false"+
    "AND t.dueDate <= CURRENT_DATE")
    List<TaskEntity> findAllOverdue();

    @Query(""+
    "Select t from tasks t where t.title LIKE %?1%")
    List<TaskEntity> findAllByTitle(String title);

    List<TaskEntity> findAllByTitleIsContainingIgnoreCase(String title);
}
