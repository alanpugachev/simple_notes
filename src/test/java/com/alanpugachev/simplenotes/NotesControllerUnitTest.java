package com.alanpugachev.simplenotes;

import com.alanpugachev.simplenotes.controllers.NotesController;
import com.alanpugachev.simplenotes.entities.Note;
import com.alanpugachev.simplenotes.services.NotesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NotesControllerUnitTest {
    @Test
    void getAllNotes_returnsNotesFromService() {
        // given
        Note note1 = new Note();
        note1.setId(1L);
        note1.setContent("Test Note 1");

        Note note2 = new Note();
        note2.setId(2L);
        note2.setContent("Test Note 2");

        NotesService mockService = Mockito.mock(NotesService.class);
        Mockito.when(mockService.findAll()).thenReturn(List.of(note1, note2));

        NotesController controller = new NotesController(mockService);

        // when
        List<Note> result = controller.getAllNotes();

        // then
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getContent()).isEqualTo("Test Note 1");
        Mockito.verify(mockService).findAll();
    }
}
