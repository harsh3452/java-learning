package com.harsh.notesapp.controller;

import com.harsh.notesapp.model.Notes;
import com.harsh.notesapp.service.NotesService;
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
    public List<Notes> getAllNotes(){
        return notesService.getAllNotes();
    }

    @PostMapping("/{noteId}")
    public Notes createNote(@RequestBody Notes note){
        return notesService.createNote(note);
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<Notes> getNoteById(@PathVariable int noteId){
        Notes result = notesService.getNoteById(noteId);
        if(result == null){
            return ResponseEntity.notFound().build();
        } return ResponseEntity.ok(result);
    }


    @PutMapping("/{noteId}")
    public ResponseEntity<String> updateNote(@PathVariable int noteId, @RequestBody Notes note){
        Notes result =  notesService.updateNote(noteId,note);
        if(result == null){
            return new ResponseEntity<String>("Failed! Note not found.", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Note Updated Success", HttpStatus.OK);
        }
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<String> deleteNote(@PathVariable int noteId){
        boolean result =  notesService.deleteNoteById(noteId);
        if(result){
            return ResponseEntity.ok("Deletion Success");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
