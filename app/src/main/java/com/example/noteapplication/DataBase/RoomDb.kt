package com.example.noteapplication.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteapplication.Dao.NoteDao
import com.example.noteapplication.Entity.NoteEntity
import kotlin.coroutines.CoroutineContext

@Database(entities = [NoteEntity::class], version = 1)
abstract class RoomDb : RoomDatabase() {
    companion object{
        fun init(context: Context):RoomDb{
            var db =Room.databaseBuilder(context,RoomDb::class.java,"Note.db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
            return db
        }
    }
    abstract fun note():NoteDao
}