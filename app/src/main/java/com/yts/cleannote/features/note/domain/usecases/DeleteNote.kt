package com.yts.cleannote.features.note.domain.usecases

import com.yts.cleannote.features.note.domain.model.Note
import com.yts.cleannote.features.note.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun  invoke(note: Note) {
        repository.deleteNote(note)
    }

}