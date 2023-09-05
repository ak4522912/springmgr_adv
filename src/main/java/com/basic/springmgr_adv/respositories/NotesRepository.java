package com.basic.springmgr_adv.respositories;

import com.basic.springmgr_adv.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepository extends JpaRepository<NoteEntity,Integer> {
}
