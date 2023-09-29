package com.example.noteapplication.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.noteapplication.Entity.NoteEntity

@Dao
interface NoteDao {

    @Insert
    fun addnote(noteEntity: NoteEntity)

    @Query("SELECT * FROM note")
    fun  getNote() : List<NoteEntity>

    @Update
    fun updateNote(noteEntity: NoteEntity)

    @Delete
    fun deleteNote(noteEntity: NoteEntity)

    @Query("DELETE FROM note")
    fun allDelete()
}