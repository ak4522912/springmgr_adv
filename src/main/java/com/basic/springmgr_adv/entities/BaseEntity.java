package com.basic.springmgr_adv.entities;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;

@MappedSuperclass
@Getter
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id",nullable = false)
    private Integer id;

    @CreatedDate
    @Column(name="created_at",columnDefinition = "timestamp default current_timestamp")
    private Date createdAt;
}
