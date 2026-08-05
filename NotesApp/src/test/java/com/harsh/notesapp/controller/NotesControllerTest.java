package com.harsh.notesapp.controller;

import com.harsh.notesapp.dto.notes.CreateNoteRequest;
import com.harsh.notesapp.dto.notes.NoteResponse;
import com.harsh.notesapp.service.NotesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotesController.class)
public class NotesControllerTest {

    @Autowired
    MockMvc mockMvc; // acts the as the browser instead of we needing an browser;

    @MockitoBean
    NotesService notesService; // mocking dependencies of the controller

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateNoteSuccessfully() throws Exception {

        CreateNoteRequest request = new CreateNoteRequest();
        request.setTitle("Mockito");
        request.setBody("Learning MockMvc");

        NoteResponse response = new NoteResponse();
        response.setNoteId(1);
        response.setTitle("Mockito");
        response.setBody("Learning MockMvc");

        when(notesService.createNote(any(CreateNoteRequest.class)))
                .thenReturn(response);

        mockMvc.perform(
                post("/notes")
                        .with(csrf())
                        .with(user("harsh"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpect(status().isCreated())
                .andExpect(jsonPath("$.noteId").value(1))
                .andExpect(jsonPath("$.title").value("Mockito"))
                .andExpect(jsonPath("$.body").value("Learning MockMvc"));


    }
}
