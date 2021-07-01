package com.example.takenotes

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert

class NoteRepositry(private val noteDao: NoteDao) {

    val allNotes : LiveData<List<Notes>>  = noteDao.getAllNotes()

    @Insert
    suspend fun insert(note:Notes)
    {
        noteDao.insert(note)
    }

    @Delete
    suspend fun delete(note: Notes)
    {
        noteDao.delete(note)
    }


}