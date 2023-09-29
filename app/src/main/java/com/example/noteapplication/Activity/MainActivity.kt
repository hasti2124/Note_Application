package com.example.noteapplication.Activity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.noteapplication.Adapter.NoteAdapter
import com.example.noteapplication.DataBase.RoomDb
import com.example.noteapplication.Entity.NoteEntity
import com.example.noteapplication.databinding.ActivityMainBinding
import com.example.noteapplication.databinding.NoteDialogBinding
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity : AppCompatActivity() {
    lateinit var db : RoomDb
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = RoomDb.init(this@MainActivity)

        initView()
    }

    private fun initView() {
        binding.fbButton.setOnClickListener{
            addNoteDialog()
        }
        adapter = NoteAdapter{
            var ispin = false
            if(it.pin){
                ispin = false
            }else{
                ispin = true
            }
            var data = NoteEntity(it.title,it.text,it.date,ispin)
            data.id = it.id
            db.note().updateNote(data)
            adapter.update(db.note().getNote())
        }
        adapter.setNote(db.note().getNote())
        binding.rcvNote.layoutManager =StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.rcvNote.adapter = adapter
    }

    private fun addNoteDialog() {
        var dialog  =Dialog(this)
        var bind = NoteDialogBinding.inflate(layoutInflater)
        dialog.setContentView(bind.root)

        bind.btnSubmit.setOnClickListener {
            var title = bind.edtTitle.text.toString()
            var text = bind.edtText.text.toString()
            var format = SimpleDateFormat("DD/MM/YYYYY hh:mm:ss a")
            var current  = format.format(Date())

            var data = NoteEntity(title,text,current,false)
            db.note().addnote(data)
            adapter.update(db.note().getNote())
            dialog.dismiss()
        }
        dialog.show()
    }
}