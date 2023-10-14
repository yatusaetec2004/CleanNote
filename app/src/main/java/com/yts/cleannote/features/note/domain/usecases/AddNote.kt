package com.yts.cleannote.features.note.domain.usecases

import com.yts.cleannote.features.note.domain.model.InvalidNoteException
import com.yts.cleannote.features.note.domain.model.Note
import com.yts.cleannote.features.note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("El título no puede estar vacío")
        }
        if(note.content.isBlank()) {
            throw InvalidNoteException("El contenido no puede estar vacío")
        }
        repository.addNote(note)
    }

}