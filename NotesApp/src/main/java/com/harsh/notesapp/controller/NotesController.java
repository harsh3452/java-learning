package com.harsh.notesapp.controller;

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
    public List<Notes> getAllNotes(){
        return notesService.getAllNotes();
    }

    @PostMapping()
    public Notes createNote(@RequestBody Notes note){
        return notesService.createNote(note);
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<Notes> getNoteById(@PathVariable int noteId) {
        Optional<Notes> note = notesService.getNoteById(noteId);
        if (note.isPresent()) {
            return ResponseEntity.ok(note.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{noteId}")
    public ResponseEntity<Notes> updateNote(@PathVariable int noteId, @RequestBody Notes note){
        Optional<Notes> result =  notesService.updateNote(noteId,note);
        if(result.isPresent()){
            return new ResponseEntity<Notes>(result.get(), HttpStatus.OK);
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
