package com.yogify.kotlinprojectjetpack.RoomDataBase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ContactDAO {

    @Insert
    suspend fun insertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Update
    suspend fun updateContact(contact: Contact)

    @Query("select *from contact")
    fun getContact(): LiveData<List<Contact>>


}