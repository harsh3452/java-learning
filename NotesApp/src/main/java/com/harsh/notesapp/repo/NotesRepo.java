package com.harsh.notesapp.repo;

import com.harsh.notesapp.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepo extends JpaRepository<Notes,Integer> {

}
