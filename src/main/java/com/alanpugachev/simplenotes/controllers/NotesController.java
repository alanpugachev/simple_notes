package com.alanpugachev.simplenotes.controllers;

import com.alanpugachev.simplenotes.entities.Note;
import com.alanpugachev.simplenotes.services.NotesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NotesController {
    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return notesService.findAll();
    }
}
