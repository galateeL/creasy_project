package com.example.creasy.service;

import com.example.creasy.exception.NoteNotFoundException;
import com.example.creasy.repository.CreateNote;
import com.example.creasy.repository.EditNote;
import com.example.creasy.repository.NoteRepository;
import com.example.creasy.repository.entity.Note;
import org.springframework.stereotype.Service;

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

    public Note getNoteById(Long id) throws NoteNotFoundException {
        return this.noteRepository
                .findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }


    public void addNote(CreateNote createNote){

        Note note = new Note();
        note.setExchange(createNote.getExchange());
        note.setRegisterDate(createNote.getRegisterDate());
        note.setPartner(createNote.getPartner());

        this.noteRepository.save(note);
    }


    public void deleteNote(Note note){
        this. noteRepository.delete(note);
    }

    public Note editNote(Long id, EditNote editNote){

        Note note = this.noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));

        note.setExchange(editNote.getExchange());
        note.setRegisterDate(editNote.getRegisterDate());
        note.setPartner(editNote.getPartner());

        return this.noteRepository.save(note);

    }

}
