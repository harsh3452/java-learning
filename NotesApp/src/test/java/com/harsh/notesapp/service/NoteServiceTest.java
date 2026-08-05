package com.harsh.notesapp.service;

import com.harsh.notesapp.config.UserPrincipal;
import com.harsh.notesapp.dto.notes.CreateNoteRequest;
import com.harsh.notesapp.dto.notes.NoteResponse;
import com.harsh.notesapp.dto.notes.UpdateNoteRequest;
import com.harsh.notesapp.dto.user.UserResponse;
import com.harsh.notesapp.exception.NoteNotFoundException;
import com.harsh.notesapp.model.Notes;
import com.harsh.notesapp.model.User;
import com.harsh.notesapp.repo.NotesRepo;
import jakarta.persistence.OneToMany;
import org.assertj.core.error.OptionalShouldContainInstanceOf;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NoteServiceTest {

    private UserPrincipal userPrincipal;
    private User user;

    @Mock
    private NotesRepo notesRepo;
    @Mock
    private SecurityContext securityContext;
    @Mock
    private Authentication authentication;
    @InjectMocks
    private NotesService notesService;

    @BeforeEach
    void setUp() {

        user = new User();
        user.setUsername("harsh");

        userPrincipal = new UserPrincipal(user);

        when(securityContext.getAuthentication())
                .thenReturn(authentication);

        when(authentication.getPrincipal())
                .thenReturn(userPrincipal);

        SecurityContextHolder.setContext(securityContext);
    }


    @AfterEach
    void tearDown() {
        SecurityContextHolder.clearContext();
    }

    @Test
    void shouldCreateNoteSuccessfully(){


        CreateNoteRequest createNoteRequest = new CreateNoteRequest();
        createNoteRequest.setBody("Learning Arguments");
        createNoteRequest.setTitle("ArgumentCaptor");

        Notes savedNote = new Notes();
        savedNote.setTitle("ArgumentCaptor");
        savedNote.setBody("Learning Arguments");
        savedNote.setNoteId(1);
        savedNote.setOwner(user);

        when(notesRepo.save(any(Notes.class)))
                .thenReturn(savedNote);

        ArgumentCaptor<Notes> captor = ArgumentCaptor.forClass(Notes.class);

        NoteResponse noteResponse = notesService.createNote(createNoteRequest);

        verify(notesRepo).save(captor.capture());
        Notes capturedNote = captor.getValue();

        assertEquals(createNoteRequest.getTitle(), capturedNote.getTitle());
        assertEquals(createNoteRequest.getBody(), capturedNote.getBody());

        assertEquals(user, capturedNote.getOwner());
        assertNotNull(capturedNote.getCreatedAt());
        assertNotNull(capturedNote.getLastEditedAt());

        assertEquals(savedNote.getNoteId(), noteResponse.getNoteId());
        assertEquals(savedNote.getTitle(), noteResponse.getTitle());

    }


    @Test
    void shouldUpdateNoteSuccessfully(){

        UpdateNoteRequest update = new UpdateNoteRequest();
        update.setTitle("New Title");
        update.setBody("New Body");
        int id = 1;



        Notes existingNote = new Notes();
        existingNote.setBody("Old Body");
        existingNote.setTitle("Old Title");
        existingNote.setOwner(user);
        existingNote.setNoteId(id);

        Notes savedNote = new Notes();
        savedNote.setNoteId(id);
        savedNote.setOwner(user);
        savedNote.setTitle("New Title");
        savedNote.setBody("New Body");



        when(notesRepo.findByNoteIdAndOwner(id,user)).thenReturn(Optional.of(existingNote));
        when(notesRepo.save(any(Notes.class))).thenReturn(savedNote);

        ArgumentCaptor<Notes> captor = ArgumentCaptor.forClass(Notes.class);

        NoteResponse response = notesService.updateNote(id,update);
        verify(notesRepo).save(captor.capture());
        verify(notesRepo).findByNoteIdAndOwner(id, user);

        Notes capturedNote = captor.getValue();

        //making sure the captured note has been updated properly
        assertEquals(update.getTitle(),capturedNote.getTitle());
        assertEquals(update.getBody(),capturedNote.getBody());
        assertNotNull(capturedNote.getLastEditedAt());
        assertEquals(user, capturedNote.getOwner());
        assertEquals(id, capturedNote.getNoteId());


        //Checking Proper Response is sent to the user.
        assertEquals(savedNote.getNoteId(),response.getNoteId());
        assertEquals(savedNote.getTitle(),response.getTitle());
        assertEquals(savedNote.getBody(),response.getBody());


    }

    @Test
    void shouldThrowNoteNotFoundExceptionWhenUpdatingNote(){

        UpdateNoteRequest r = new UpdateNoteRequest();
        r.setTitle("New Title");
        r.setBody("New Body");
        int noteId = 3;

        when(notesRepo.findByNoteIdAndOwner(noteId,user)).thenReturn(Optional.empty());
        NoteNotFoundException exception = assertThrows(NoteNotFoundException.class,()-> notesService.updateNote(noteId,r));

        assertEquals("Note not found", exception.getMessage());
        verify(notesRepo).findByNoteIdAndOwner(noteId,user);
        verify(notesRepo,never()).save(any(Notes.class));


    }

    @Test
    void shouldGetNoteByIdSuccessfully(){
        int noteId = 4;
        LocalDateTime now = LocalDateTime.now();
        Notes existingNote = new Notes();
        existingNote.setNoteId(4);
        existingNote.setTitle("Title");
        existingNote.setBody("Body");
        existingNote.setOwner(user);
        existingNote.setLastEditedAt(now);
        existingNote.setCreatedAt(now);


        when(notesRepo.findByNoteIdAndOwner(noteId, user))
                .thenReturn(Optional.of(existingNote));

        NoteResponse response = notesService.getNoteById(noteId);

        assertEquals(existingNote.getNoteId(), response.getNoteId());
        assertEquals(existingNote.getTitle(), response.getTitle());
        assertEquals(existingNote.getBody(), response.getBody());
        assertEquals(existingNote.getCreatedAt(), response.getCreatedAt());
        assertEquals(existingNote.getLastEditedAt(), response.getLastEditedAt());

        verify(notesRepo).findByNoteIdAndOwner(noteId, user);



    }

    @Test
    void shouldThrowNotNoteFoundExceptionWhenGettingNoteById(){
        int noteId = 4;

        when(notesRepo.findByNoteIdAndOwner(noteId,user)).thenReturn(Optional.empty());

        NoteNotFoundException exception = assertThrows(NoteNotFoundException.class,()->notesService.getNoteById(noteId));

        assertEquals("Note not found",exception.getMessage());
        verify(notesRepo).findByNoteIdAndOwner(noteId,user);
    }




}
