package com.example.creasy.repository;

import com.example.creasy.repository.entity.Note;
import com.example.creasy.repository.entity.Partner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {


List<Note> getAllByPartner(Partner partner);

}
