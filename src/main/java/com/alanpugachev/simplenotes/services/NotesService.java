package com.alanpugachev.simplenotes.services;

import com.alanpugachev.simplenotes.entities.Note;
import com.alanpugachev.simplenotes.repository.NotesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotesService {
    private final NotesRepository notesRepository;

    public NotesService(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    public Note save(Note note) {
        return notesRepository.save(note);
    }

    public List<Note> findAll() {
        return notesRepository.findAll();
    }
}
