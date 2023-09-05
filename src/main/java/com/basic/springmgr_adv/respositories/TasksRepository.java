package com.basic.springmgr_adv.respositories;

import com.basic.springmgr_adv.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<TaskEntity,Integer> {
}
