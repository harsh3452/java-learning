package com.harsh.notesapp.controller;

import com.harsh.notesapp.dto.notes.CreateNoteRequest;
import com.harsh.notesapp.dto.notes.NoteResponse;
import com.harsh.notesapp.dto.notes.UpdateNoteRequest;
import com.harsh.notesapp.service.NotesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/notes")
public class NotesController {
    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping
    public List<NoteResponse> getAllNotes(){
        return notesService.getAllNotes();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public NoteResponse createNote(@Valid @RequestBody CreateNoteRequest note){
        return notesService.createNote(note);
    }

    @GetMapping("/{noteId}")
    public NoteResponse getNoteById(@PathVariable int noteId) {
       return notesService.getNoteById(noteId);
    }

    @PutMapping("/{noteId}")
    public NoteResponse updateNote(@PathVariable int noteId,@Valid @RequestBody UpdateNoteRequest note){
        return notesService.updateNote(noteId,note);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteNote(@PathVariable int noteId){
        notesService.deleteNoteById(noteId);
        return ResponseEntity.noContent().build();
    }
}
