package com.example.takenotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    val allNotes : LiveData<List<Notes>>
 private val repositry: NoteRepositry

    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repositry = NoteRepositry(dao)
        allNotes = repositry.allNotes
    }

    fun delNote(note : Notes) = viewModelScope.launch(Dispatchers.IO) {
        repositry.delete(note)

    }
    // suspend function can be called by only another suspend function or by coroutines


    fun insertNote(note:Notes) = viewModelScope.launch(Dispatchers. IO) {
        repositry.insert(note)
    }
}