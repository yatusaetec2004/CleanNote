package com.yts.cleannote.features.note.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yts.cleannote.features.note.presentation.add_edit_note.AddEditNoteScreen
import com.yts.cleannote.features.note.presentation.add_edit_note.AddEditNoteViewModel
import com.yts.cleannote.features.note.presentation.notes.NotesScreen
import com.yts.cleannote.features.note.presentation.notes.NotesViewModel
import com.yts.cleannote.features.note.presentation.util.Screen
import com.yts.cleannote.ui.theme.CleanNoteTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanNoteTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.NotesScreen.route) {
                        composable(Screen.NotesScreen.route) {
                            val viewModel = hiltViewModel<NotesViewModel>()
                            val state by viewModel.state.collectAsState()
                            NotesScreen(navController = navController, state = state, onEvent = viewModel::onEvent)
                        }

                        composable(
                            Screen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(name = "noteId") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(name = "noteColor") {
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) { entry ->
                            val viewModel = hiltViewModel<AddEditNoteViewModel>()
                            val titleState by viewModel.noteTitle.collectAsState()
                            val contentState by viewModel.noteContent.collectAsState()
                            val colorState by viewModel.noteColor.collectAsState()
                            val noteColor = entry.arguments?.getInt("noteColor") ?: -1
                            val eventFlow = viewModel.eventFlow
                            AddEditNoteScreen(
                                navController = navController,
                                noteColor = noteColor,
                                titleState = titleState,
                                contentState = contentState,
                                colorState = colorState,
                                eventFlow = eventFlow,
                                onEvent = viewModel::onEvent
                            )
                        }
                    }
                }
            }
        }
    }
}