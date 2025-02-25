package com.nishiket.task.recyclerview.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nishiket.task.recyclerview.model.Message

@Database(entities = [Message::class], version = 1) // defining the database schema and its version
abstract class DatabaseInstance: RoomDatabase() {
    abstract fun chatDao(): ChatDao // return our Dao
    companion object { // to make singleton object of our database
        @Volatile
        private var INSTANCE: DatabaseInstance? = null

        fun getDatabase(context: Context): DatabaseInstance {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DatabaseInstance::class.java,
                    "chat_database"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}