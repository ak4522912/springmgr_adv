package com.basic.springmgr_adv.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name="tasks")
@Table(indexes = @Index(columnList = "title"))
@Getter
@Setter
public class TaskEntity extends BaseEntity{
    @Column(name="title",nullable = false,length = 150)
    String title;
    @Column(name="description",nullable = true,length = 500)
    String description;
    @Column(name="completed")
    Boolean completed = false;
    @Column(name="due_date")
    Date dueDate;
    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY)
    List<NoteEntity> notes;

}
