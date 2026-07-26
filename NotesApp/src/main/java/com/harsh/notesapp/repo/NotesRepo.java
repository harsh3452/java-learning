package com.harsh.notesapp.repo;

import com.harsh.notesapp.model.Notes;
import com.harsh.notesapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotesRepo extends JpaRepository<Notes,Integer> {
    List<Notes> findByOwner(User owner);
    Optional<Notes> findByNoteIdAndOwner(Integer noteId, User owner);
}
