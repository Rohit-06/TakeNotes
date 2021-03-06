package com.example.takenotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVAdapter(private val context: Context, private val listener: MainActivity):RecyclerView.Adapter<NotesRVAdapter.NoteViewHolder>() {

    private val allNotes = ArrayList<Notes>()

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val textView: TextView = itemView.findViewById(R.id.text)
        val delbutton: ImageView = itemView.findViewById(R.id.delbutton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
     val viewHolder =  NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note , parent ,false ))
      viewHolder.delbutton.setOnClickListener{
          listener.onItemClicked(allNotes[viewHolder.adapterPosition])
      }

        return viewHolder
    }

    override fun getItemCount(): Int {
      return allNotes.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
       val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

    fun updateList(newList: List<Notes>)
    {
        allNotes.clear()
        allNotes.addAll(newList)
     notifyDataSetChanged()
    }
}


 interface INotesRVAdapter{
     fun onItemClicked(note:Notes)
 }