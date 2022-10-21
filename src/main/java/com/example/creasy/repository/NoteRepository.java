package com.example.creasy.repository;

import com.example.creasy.repository.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

    //List<Note> findNoteByNameContaining(String name);
}
