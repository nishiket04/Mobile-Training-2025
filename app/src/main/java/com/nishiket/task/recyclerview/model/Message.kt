package com.nishiket.task.recyclerview.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity // using this defining schema of our table.
data class Message(@PrimaryKey(autoGenerate = true) val id: Int = 0,var message: String, var time: String,var msgType:Boolean)
