package com.yts.cleannote.features.note.presentation.notes

import com.yts.cleannote.features.note.domain.model.Note
import com.yts.cleannote.features.note.domain.util.NoteOrder
import com.yts.cleannote.features.note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderedSectionVisible: Boolean = false
)
