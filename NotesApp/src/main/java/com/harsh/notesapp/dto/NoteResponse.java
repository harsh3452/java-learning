package com.harsh.notesapp.dto;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponse {
    private Integer noteId;
    private String title;
    private String body;
    private LocalDateTime createdAt;
    private LocalDateTime lastEditedAt;
}
