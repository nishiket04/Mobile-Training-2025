package com.nishiket.task.recyclerview.roomdatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.nishiket.task.recyclerview.model.Message

@Dao
interface ChatDao {
    @Insert
    fun insertChat(chat: Message):Long // Insert the message in the table, and returns inserted row Id
    @Query("SELECT * FROM Message")
    fun getChats(): List<Message> // get all the the message present in the table
    @Update
    fun updateChat(chat: Message):Int // update the message in the table, and return Int
    @Delete
    fun deleteChat(chat: Message):Int // delete the message in the table. and return Int
}

// @Entity -> lets you define table schema
// @Ignore -> to ignore property of model class for schema
// @PrimaryKey -> lets you define primary key of table
// @ColumnInfo -> lets you define colum property like name,default value
// @Embeded -> lets you combine two model class for one schema
// @ForeignKey -> lets you define foreignKey of table
// @Insert -> lets you insert row in table and returns Id of inserted row
// @Query -> lets you make custom query
// @Update -> lets you update row data based on Id, return Int 1:updated,0:fail to update
// @Delete -> lets you delete row form the table based on Id, return Int 1:deleted,0:fail to delete
// @Database -> lets you define all associated table in schema and version.