package com.example.repeatnavigation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.repeatnavigation.databinding.ItemNoteBinding
import com.example.repeatnavigation.models.Notes

class NotesAdapter(private val notes: ArrayList<Notes>) : ListAdapter<Notes,NotesAdapter.NotesViewHolder>(DiffCallback()) {


    fun setData(notes: List<Notes>) {
        this.notes.clear()
        this.notes.addAll(notes)
        notifyDataSetChanged()
    }

    inner class NotesViewHolder(private val binding : ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Notes) {
            binding.tvTitle.text = note.title

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding: ItemNoteBinding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return NotesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NotesAdapter.NotesViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    class DiffCallback : DiffUtil.ItemCallback<Notes>(){
        override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem.title == newItem.title
        }

    }
}