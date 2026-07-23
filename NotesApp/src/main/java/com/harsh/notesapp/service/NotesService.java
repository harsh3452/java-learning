package com.harsh.notesapp.service;

import com.harsh.notesapp.model.Notes;
import com.harsh.notesapp.repo.NotesRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotesService {

    private final NotesRepo notesRepo;

    public NotesService(NotesRepo notesRepo){
        this.notesRepo=notesRepo;
    }

    public List<Notes> getAllNotes() {
        return notesRepo.findAll();
    }

    public Notes createNote(Notes note) {
        LocalDateTime now = LocalDateTime.now();
        note.setCreatedAt(now);
        note.setLastEditedAt(now);
        return notesRepo.save(note); // id will be used later for checking it exists already.
    }

    public Notes updateNote(int noteId, Notes note) {
        try {
            Notes retrieveNote = notesRepo.getReferenceById(noteId);
            retrieveNote.setBody(note.getBody());
            retrieveNote.setTitle(note.getTitle());
            retrieveNote.setLastEditedAt(LocalDateTime.now());
            return notesRepo.save(retrieveNote);
        } catch (EntityNotFoundException e) {
            return null;
        }
    }

    public Notes getNoteById(int noteId) {
        try {
            return notesRepo.getReferenceById(noteId);
        } catch (EntityNotFoundException e){
            return null;
        }
    }

    public boolean deleteNoteById(int noteId){
        try {
                notesRepo.deleteById(noteId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
