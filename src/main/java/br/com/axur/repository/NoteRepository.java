package br.com.axur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.axur.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long>{

}
