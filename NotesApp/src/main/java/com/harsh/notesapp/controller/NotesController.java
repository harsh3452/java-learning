package com.harsh.notesapp.controller;

import com.harsh.notesapp.dto.CreateNoteRequest;
import com.harsh.notesapp.dto.NoteResponse;
import com.harsh.notesapp.dto.UpdateNoteRequest;
import com.harsh.notesapp.model.Notes;
import com.harsh.notesapp.service.NotesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @PostMapping()
    public NoteResponse createNote(@RequestBody CreateNoteRequest note){
        return notesService.createNote(note);
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<NoteResponse> getNoteById(@PathVariable int noteId) {
        Optional<NoteResponse> note = notesService.getNoteById(noteId);
        if (note.isPresent()) {
            return ResponseEntity.ok(note.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{noteId}")
    public ResponseEntity<NoteResponse> updateNote(@PathVariable int noteId, @RequestBody UpdateNoteRequest note){
        Optional<NoteResponse> result =  notesService.updateNote(noteId,note);
        if(result.isPresent()){
            return new ResponseEntity<NoteResponse>(result.get(), HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<String> deleteNote(@PathVariable int noteId){
        boolean result =  notesService.deleteNoteById(noteId);
        if(result){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
