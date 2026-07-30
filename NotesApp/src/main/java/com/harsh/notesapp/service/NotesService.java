package com.harsh.notesapp.service;

import com.harsh.notesapp.dto.notes.CreateNoteRequest;
import com.harsh.notesapp.dto.notes.NoteResponse;
import com.harsh.notesapp.dto.notes.UpdateNoteRequest;
import com.harsh.notesapp.exception.NoteNotFoundException;
import com.harsh.notesapp.mapper.NoteMapper;
import com.harsh.notesapp.model.Notes;
import com.harsh.notesapp.model.User;
import com.harsh.notesapp.config.UserPrincipal;
import com.harsh.notesapp.repo.NotesRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class NotesService {

    private final NotesRepo notesRepo;

    public NotesService(NotesRepo notesRepo){
        this.notesRepo=notesRepo;
    }

    private User getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        return principal.getUser();
    }

    public List<NoteResponse> getAllNotes() {
        User user = getCurrentUser();
        List<Notes> allNotes = notesRepo.findByOwner(user);
        List<NoteResponse> noteResponses = new ArrayList<>();
        for(Notes note : allNotes){ // preparing all the responses and putting them in the lists;
            noteResponses.add(NoteMapper.toResponse(note));
        }
        return noteResponses;
    }

    public NoteResponse createNote(CreateNoteRequest noteRequest) {
        User user = getCurrentUser();

        //preparing entity from RequestNote to save in database
        Notes note = NoteMapper.toEntity(noteRequest); //mapping body and title
        LocalDateTime now = LocalDateTime.now();
        note.setLastEditedAt(now);
        note.setCreatedAt(now);
        note.setOwner(user);

        // save the note to db
        Notes savedNote = notesRepo.save(note);

        // preparing NoteResponse dto to send to client
        return NoteMapper.toResponse(savedNote);
    }

    public NoteResponse updateNote(int noteId, UpdateNoteRequest updatedNote) {
        User user = getCurrentUser();
        Notes existingNote = notesRepo.findByNoteIdAndOwner(noteId,user)
                .orElseThrow(()-> new NoteNotFoundException("Note not found"));

           NoteMapper.applyUpdate(updatedNote,existingNote);
           existingNote.setLastEditedAt(LocalDateTime.now());

           Notes savedNote = notesRepo.save(existingNote);
           return NoteMapper.toResponse(savedNote);
    }

    public NoteResponse getNoteById(int noteId) {
        User user = getCurrentUser();
        Notes note = notesRepo.findByNoteIdAndOwner(noteId, user)
                .orElseThrow(()-> new NoteNotFoundException("Note not found"));
        return NoteMapper.toResponse(note);
    }

    public void deleteNoteById(int noteId){
        User user = getCurrentUser();
        Notes existingNote = notesRepo.findByNoteIdAndOwner(noteId, user)
                .orElseThrow(()-> new NoteNotFoundException("Note not found"));
        notesRepo.delete(existingNote);
    }
}
