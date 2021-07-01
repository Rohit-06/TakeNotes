package com.example.takenotes

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity(), INotesRVAdapter {

    private lateinit var viewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv:RecyclerView = findViewById(R.id.recycler)
        rv.layoutManager = LinearLayoutManager(this)

        val adapter = NotesRVAdapter(this , this)
        rv.adapter = adapter

        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this , {list->
            list?.let{
                adapter.updateList(it)
            }

        })
    }

    override fun onItemClicked(note: Notes) {
       viewModel.delNote(note)
        Toast.makeText(this , "${note.text} Deleted" , Toast.LENGTH_LONG).show()
    }

    fun SubmitData(view: View) {
        val i:TextView = findViewById(R.id.input)
        val noteText = i.text.toString()

        if(noteText.isNotEmpty())
        {
            viewModel.insertNote(Notes(noteText))
            Toast.makeText(this , "${noteText} Inserted" , Toast.LENGTH_LONG).show()
        }
    }



}
