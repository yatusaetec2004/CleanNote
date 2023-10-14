package com.yts.cleannote.features.note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.yts.cleannote.ui.theme.BabyBlue
import com.yts.cleannote.ui.theme.LightGreen
import com.yts.cleannote.ui.theme.RedOrange
import com.yts.cleannote.ui.theme.RedPink
import com.yts.cleannote.ui.theme.Violet

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int,
    @PrimaryKey val id: Int? = null
) {
    companion object {
        val noteColors = listOf(RedOrange, RedPink, Violet, LightGreen, BabyBlue)
    }
}

class InvalidNoteException(message: String): Exception(message)
