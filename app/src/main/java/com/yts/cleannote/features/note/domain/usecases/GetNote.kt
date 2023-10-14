package com.yts.cleannote.features.note.domain.usecases

import com.yts.cleannote.features.note.domain.model.Note
import com.yts.cleannote.features.note.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }

}