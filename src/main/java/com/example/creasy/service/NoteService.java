package com.example.creasy.service;

import com.example.creasy.exception.NoteNotFoundException;
import com.example.creasy.controller.dto.CreateNoteDto;
import com.example.creasy.controller.dto.EditNoteDto;
import com.example.creasy.repository.NoteRepository;
import com.example.creasy.model.Note;
import com.example.creasy.model.Partner;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes(){

        return (List<Note>) this.noteRepository.findAll();
    }

    public List<Note> getAllNotesByPartner(Partner partner){
        return (List<Note>) this.noteRepository.getAllByPartnerOrderByRegisterDateDesc(partner);

    }

    public Note getNoteById(Long id) throws NoteNotFoundException {
        return this.noteRepository
                .findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    public void addNote(CreateNoteDto createNote, Partner partner){

        Note note = new Note();
        note.setExchange(createNote.getExchange());
        note.setRegisterDate(LocalDateTime.now());
        note.setPartner(partner);

        this.noteRepository.save(note);
    }

    public void deleteNote(Note note){
        this. noteRepository.delete(note);
    }

    public Note editNote(Long id, EditNoteDto editNote){

        Note note = this.noteRepository
                .findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));

        note.setExchange(editNote.getExchange());
       // note.setRegisterDate(LocalDateTime.now());
       // note.setPartner(editNote.getPartner());

        return this.noteRepository.save(note);

    }

}
