package com.yogify.kotlinprojectjetpack.RoomDataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contact::class], version = 1)
abstract class ContactDataBase : RoomDatabase() {

    abstract fun contactDao(): ContactDAO

    companion object {
        //   @Volatile  If Something is changed then every thred get updated value Automatic
        @Volatile
        private var INSTANCE: ContactDataBase? = null

        fun getDataBase(context: Context): ContactDataBase {
            if (INSTANCE == null) {
                // Create Only single , if two class trying to create this at same time , This is Called Locking
                 synchronized(this){
                     INSTANCE =
                         Room.databaseBuilder(context, ContactDataBase::class.java, "ContactDataBase")
                             .build()
                 }

            }
            return INSTANCE!!
        }
    }
}