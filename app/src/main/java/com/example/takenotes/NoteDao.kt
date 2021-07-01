package com.example.takenotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    //fun insert(note : Notes) // insert and delete function are performed by I/O (input / output operation) they are heavy so the should run in backend (if we perform them in mainthread app will become lagy )

    // we can do this by the help of kotlin coroutines ( here we are using suspend)


//    A coroutine is an instance of suspendable computation. It is conceptually similar to a thread, in the sense that it takes a block of code to run that works concurrently with the rest of the code. However, a coroutine is not bound to any particular thread. It may suspend its execution in one thread and resume in another one.
    suspend fun insert(note :Notes)

    @Delete
    suspend fun delete(note:Notes)
   //fun delete(note:Notes)

    @Query("Select * from notes_table order by id ASC")
   // fun getAllNotes() : List<Notes> // agr apne chahte h ki apni activity ko pta chle jb bhi data change ho tu ise livedata bna do

    fun getAllNotes():LiveData<List<Notes>>
}