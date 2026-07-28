package com.harsh.notesapp.mapper;

import com.harsh.notesapp.dto.CreateNoteRequest;
import com.harsh.notesapp.dto.NoteResponse;
import com.harsh.notesapp.dto.UpdateNoteRequest;
import com.harsh.notesapp.model.Notes;

public final class NoteMapper {

    public static Notes toEntity(CreateNoteRequest createNoteRequest){
        Notes note = new Notes();
        note.setTitle(createNoteRequest.getTitle());
        note.setBody(createNoteRequest.getBody());
        return note;
    }

    public static NoteResponse toResponse(Notes note){
        NoteResponse noteResponse = new NoteResponse();
        noteResponse.setNoteId(note.getNoteId());
        noteResponse.setTitle(note.getTitle());
        noteResponse.setBody(note.getBody());
        noteResponse.setCreatedAt(note.getCreatedAt());
        noteResponse.setLastEditedAt(note.getLastEditedAt());
        return noteResponse;
    }

    public static void applyUpdate(UpdateNoteRequest updateNoteRequest, Notes note){
        note.setTitle(updateNoteRequest.getTitle());
        note.setBody(updateNoteRequest.getBody());
    }
}
