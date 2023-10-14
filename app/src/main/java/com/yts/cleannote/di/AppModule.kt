package com.yts.cleannote.di

import android.app.Application
import androidx.room.Room
import com.yts.cleannote.features.note.data.repository.NoteRepositoryImpl
import com.yts.cleannote.features.note.data.source.NoteDatabase
import com.yts.cleannote.features.note.domain.repository.NoteRepository
import com.yts.cleannote.features.note.domain.usecases.AddNote
import com.yts.cleannote.features.note.domain.usecases.DeleteNote
import com.yts.cleannote.features.note.domain.usecases.GetNote
import com.yts.cleannote.features.note.domain.usecases.GetNotes
import com.yts.cleannote.features.note.domain.usecases.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}