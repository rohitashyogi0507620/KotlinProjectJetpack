package com.yogify.kotlinprojectjetpack.RoomDataBase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "Contact")
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val phone: String,
    val imageurl: String,
    val date: Date,
    val isactive: Int
)