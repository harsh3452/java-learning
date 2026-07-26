package com.harsh.notesapp.service;

import com.harsh.notesapp.dto.CreateNoteRequest;
import com.harsh.notesapp.dto.NoteResponse;
import com.harsh.notesapp.dto.UpdateNoteRequest;
import com.harsh.notesapp.model.Notes;
import com.harsh.notesapp.model.User;
import com.harsh.notesapp.config.UserPrincipal;
import com.harsh.notesapp.repo.NotesRepo;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    private final NotesRepo notesRepo;

    public NotesService(NotesRepo notesRepo){
        this.notesRepo=notesRepo;
    }

    public List<NoteResponse> getAllNotes() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        User user = principal.getUser();
        List<Notes> allNotes = notesRepo.findByOwner(user);
        List<NoteResponse> noteResponses = new ArrayList<>();
        for(Notes note : allNotes){ // preparing all the responses and putting them in the lists;
            NoteResponse noteResponse = new NoteResponse();
            noteResponse.setNoteId(note.getNoteId());
            noteResponse.setTitle(note.getTitle());
            noteResponse.setBody(note.getBody());
            noteResponse.setCreatedAt(note.getCreatedAt()   );
            noteResponse.setLastEditedAt(note.getLastEditedAt());
            noteResponses.add(noteResponse);
        }
        return noteResponses;
    }

    public NoteResponse createNote(CreateNoteRequest noteRequest) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        User user = principal.getUser();


        //preparing entity from RequestNote to save in database
        Notes note = new Notes();
        note.setTitle(noteRequest.getTitle());
        note.setBody(noteRequest.getBody());
        note.setLastEditedAt(LocalDateTime.now());
        note.setCreatedAt(LocalDateTime.now());
        note.setOwner(user);

        Notes savedNote = notesRepo.save(note);

        // preparing NoteResponse dto to send to client
        NoteResponse response = new NoteResponse();
        response.setNoteId(savedNote.getNoteId());
        response.setTitle(savedNote.getTitle());
        response.setBody(savedNote.getBody());
        response.setCreatedAt(savedNote.getCreatedAt());
        response.setLastEditedAt(savedNote.getLastEditedAt());
        return response;
    }

    public Optional<NoteResponse> updateNote(int noteId, UpdateNoteRequest updatedNote) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        User user = principal.getUser();
        Optional<Notes> existingNote  = notesRepo.findByNoteIdAndOwner(noteId,user);
       if(existingNote .isPresent()){
           Notes note = existingNote.get();
           note.setLastEditedAt(LocalDateTime.now());
           note.setBody(updatedNote.getBody());
           note.setTitle(updatedNote.getTitle());

           Notes savedNote = notesRepo.save(note);
           NoteResponse response = new NoteResponse();
           response.setNoteId(savedNote.getNoteId());
           response.setTitle(savedNote.getTitle());
           response.setBody(savedNote.getBody());
           response.setCreatedAt(savedNote.getCreatedAt());
           response.setLastEditedAt(savedNote.getLastEditedAt());

           return Optional.of(response);
       } else {
           return Optional.empty();
       }
    }

    public Optional<NoteResponse> getNoteById(int noteId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        User user = principal.getUser();
        Optional<Notes> note = notesRepo.findByNoteIdAndOwner(noteId, user);
        if(note.isPresent()) {
            Notes savedNote = note.get();
            NoteResponse response = new NoteResponse();
            response.setNoteId(savedNote.getNoteId());
            response.setTitle(savedNote.getTitle());
            response.setBody(savedNote.getBody());
            response.setLastEditedAt(savedNote.getLastEditedAt());
            response.setCreatedAt(savedNote.getCreatedAt());
            return Optional.of(response);
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
