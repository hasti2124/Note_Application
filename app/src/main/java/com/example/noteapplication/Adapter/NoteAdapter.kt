package com.example.noteapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.noteapplication.Entity.NoteEntity
import com.example.noteapplication.R
import com.example.noteapplication.databinding.NoteItemBinding

class NoteAdapter(updatePin: (NoteEntity) -> Unit) : Adapter<NoteAdapter.NoteHolder>() {

    var updatePin = updatePin
    var note = ArrayList<NoteEntity>()
    class NoteHolder(itemView: NoteItemBinding) : ViewHolder(itemView.root){
        var binding = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        var binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NoteHolder(binding)
    }

    override fun getItemCount(): Int {
        return note.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.binding.apply {
            txtTitle.isSelected = true
            note.get(position).apply{
                txtTitle.text = title
                txtText.text = text
                if(pin){
                    imgPin.setImageResource(R.drawable.pined)
                }else{
                    imgPin.setImageResource(R.drawable.unpin)
                }
                imgPin.setOnClickListener {
                    updatePin.invoke(note.get(position))
                }
            }
        }
    }

    fun update(note: List<NoteEntity>) {
        this.note = note as ArrayList<NoteEntity>
        notifyDataSetChanged()
    }

    fun setNote(note: List<NoteEntity>) {
        this.note = note as ArrayList<NoteEntity>
    }
}