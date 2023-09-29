package com.example.noteapplication.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
data class NoteEntity(
    @ColumnInfo(name = "title") var title:String,
    @ColumnInfo(name = "text") var text:String,
    @ColumnInfo(name = "date") var date:String,
    @ColumnInfo(name = "pin") var pin:Boolean
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}
