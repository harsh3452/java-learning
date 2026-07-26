package com.harsh.notesapp.service;

import com.harsh.notesapp.model.Notes;
import com.harsh.notesapp.model.User;
import com.harsh.notesapp.config.UserPrincipal;
import com.harsh.notesapp.repo.NotesRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    private final NotesRepo notesRepo;

    public NotesService(NotesRepo notesRepo){
        this.notesRepo=notesRepo;
    }

    public List<Notes> getAllNotes() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        User user = principal.getUser();
        return notesRepo.findByOwner(user);
    }

    public Notes createNote(Notes note) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        User user = principal.getUser();
        note.setOwner(user);
        LocalDateTime now = LocalDateTime.now();
        note.setCreatedAt(now);
        note.setLastEditedAt(now);
        return notesRepo.save(note); // id will be used later for checking it exists already.
    }

    public Optional<Notes> updateNote(int noteId, Notes updatedNote) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        User user = principal.getUser();
        Optional<Notes> existingNote  = notesRepo.findByNoteIdAndOwner(noteId,user);
       if(existingNote .isPresent()){
           Notes note = existingNote .get();
           note.setBody(updatedNote.getBody());
           note.setTitle(updatedNote.getTitle());
           note.setLastEditedAt(LocalDateTime.now());
           return Optional.of(notesRepo.save(note));
       } else {
           return Optional.empty();
       }
    }

    public Optional<Notes> getNoteById(int noteId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        User user = principal.getUser();
        Optional<Notes> note = notesRepo.findByNoteIdAndOwner(noteId, user);
        if(note.isPresent()) {
            return note;
        } else {
            return Optional.empty();
        }
    }

    public boolean deleteNoteById(int noteId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        User user = principal.getUser();
        Optional<Notes> existingNote = notesRepo.findByNoteIdAndOwner(noteId, user);
        if(existingNote.isPresent()){
            Notes note = existingNote.get();
            notesRepo.delete(note);
            return true;
       } else {
           return false;
       }
    }
}
