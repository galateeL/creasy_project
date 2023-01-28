package com.example.creasy.repository;

import com.example.creasy.model.Note;
import com.example.creasy.model.Partner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {


List<Note> getAllByPartner(Partner partner);

List<Note> getAllByPartnerOrderByRegisterDateDesc(Partner partner);

}
