package com.harsh.notesapp.dto.notes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateNoteRequest {
    @NotBlank
    @Size(min = 2,max = 100)
    private String title;
    @NotNull
    private String body;
}
